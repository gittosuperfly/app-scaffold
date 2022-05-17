package com.cai.base.livedata;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ProtectedUnPeekLiveData<T> extends LiveData<T> {

    private final static int START_VERSION = -1;

    private final AtomicInteger mCurrentVersion = new AtomicInteger(START_VERSION);

    protected boolean isAllowNullValue;

    /**
     * 当 liveData 用作 event 用途时，可使用该方法来观察 "生命周期敏感" 的非粘性消息
     * <p>
     * state 是可变且私用的，event 是只读且公用的
     * state 的倒灌是应景的，event 倒灌是不符预期的
     *
     * @param owner    activity 传入 this，fragment 建议传入 getViewLifecycleOwner
     * @param observer observer
     */
    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
        super.observe(owner, createObserverWrapper(observer, mCurrentVersion.get()));
    }

    /**
     * 当 liveData 用作 event 用途时，可使用该方法来观察 "生命周期不敏感" 的非粘性消息
     *
     * @param observer observer
     */
    @Override
    public void observeForever(@NonNull Observer<? super T> observer) {
        super.observeForever(createObserverWrapper(observer, mCurrentVersion.get()));
    }

    /**
     * 当 liveData 用作 state 用途时，可使用该方法来观察 "生命周期敏感" 的粘性消息
     *
     * @param owner    activity 传入 this，fragment 建议传入 getViewLifecycleOwner
     * @param observer observer
     */
    public void observeSticky(@NonNull LifecycleOwner owner, @NonNull Observer<T> observer) {
        super.observe(owner, createObserverWrapper(observer, START_VERSION));
    }

    /**
     * 当 liveData 用作 state 用途时，可使用该方法来观察 "生命周期不敏感" 的粘性消息
     */
    public void observeStickyForever(@NonNull Observer<? super T> observer) {
        super.observeForever(createObserverWrapper(observer, START_VERSION));
    }


    @Override
    protected void setValue(T value) {
        mCurrentVersion.getAndIncrement();
        super.setValue(value);
    }

    class ObserverWrapper implements Observer<T> {
        private final Observer<? super T> mObserver;
        private int mVersion = START_VERSION;

        public ObserverWrapper(@NonNull Observer<? super T> observer, int version) {
            this.mObserver = observer;
            this.mVersion = version;
        }

        @Override
        public void onChanged(T t) {
            if (mCurrentVersion.get() > mVersion && (t != null || isAllowNullValue)) {
                mObserver.onChanged(t);
            }
        }

        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ObserverWrapper that = (ObserverWrapper) o;
            return Objects.equals(mObserver, that.mObserver);
        }

        @Override
        public int hashCode() {
            return Objects.hash(mObserver);
        }
    }

    /**
     * 通过 ObserveForever 的 Observe，需要记得 remove，不然存在 LiveData 内存泄漏的隐患，
     * 保险的做法是，在页面的 onDestroy 环节安排 removeObserver 代码，
     *
     * @param observer observeForever 注册的 observer，或 observe 注册的 observerWrapper
     */
    @Override
    public void removeObserver(@NonNull Observer<? super T> observer) {
        if (observer.getClass().isAssignableFrom(ObserverWrapper.class)) {
            super.removeObserver(observer);
        } else {
            super.removeObserver(createObserverWrapper(observer, START_VERSION));
        }
    }

    private ObserverWrapper createObserverWrapper(@NonNull Observer<? super T> observer, int version) {
        return new ObserverWrapper(observer, version);
    }

    /**
     * 手动将消息从内存中清空，
     * 以免无用消息随着 SharedViewModel 的长时间驻留而导致内存溢出的发生。
     */
    public void clear() {
        super.setValue(null);
    }

}