package com.cai.base.widget.bottombar

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Typeface
import android.os.Parcelable
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.cai.base.widget.bottombar.internal.InnerListener
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView

class BottomNavigationView : View, IBottomNavigation<com.google.android.material.bottomnavigation.BottomNavigationView, BottomNavigationMenuView, BottomNavigationItemView> {

    @Suppress("JoinDeclarationAndAssignment")
    private var iBottomNavigation: IBottomNavigation<com.google.android.material.bottomnavigation.BottomNavigationView, BottomNavigationMenuView, BottomNavigationItemView>
    private var isLoaded: Boolean = false

    private val inflateRunnable = { inflate() }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        iBottomNavigation = BottomNavigationViewInner(context, attrs, defStyleAttr)
        visibility = GONE
        setWillNotDraw(true)
        post { inflateRunnable }
    }

    override val realView: com.google.android.material.bottomnavigation.BottomNavigationView get() = iBottomNavigation as com.google.android.material.bottomnavigation.BottomNavigationView

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        inflate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(0, 0)
    }

    @SuppressLint("MissingSuperCall")
    override fun draw(canvas: Canvas?) {
    }

    override fun dispatchDraw(canvas: Canvas?) {}

    private fun replaceSelfWithView(parent: ViewGroup) {
        val index = parent.indexOfChild(this)
        if (-1 == index) {
            return
        }
        parent.removeViewInLayout(this)
        val layoutParams = layoutParams
        if (layoutParams != null) {
            parent.addView(realView, index, layoutParams)
        } else {
            parent.addView(realView, index)
        }
    }

    private fun inflate() {
        removeCallbacks(inflateRunnable)
        if (isLoaded) {
            return
        }
        val viewParent = parent
        if (viewParent != null && viewParent is ViewGroup) {
            isLoaded = true
            replaceSelfWithView(viewParent)
        }
    }

    fun setItem(index: Int, text: String?, @DrawableRes icon: Int) {
        getMenu().add(0, index, index, text).setIcon(icon)
    }

    override fun setIconVisibility(visibility: Boolean): BottomNavigationView {
        iBottomNavigation.setIconVisibility(visibility)
        return this
    }

    override fun setTextVisibility(visibility: Boolean): BottomNavigationView {
        iBottomNavigation.setTextVisibility(visibility)
        return this
    }

    override fun enableAnimation(enable: Boolean): BottomNavigationView {
        iBottomNavigation.enableAnimation(enable)
        return this
    }

    override fun enableLabelVisibility(enable: Boolean): BottomNavigationView {
        iBottomNavigation.enableLabelVisibility(enable)
        return this
    }

    override fun enableBNItemViewLabelVisibility(position: Int, enable: Boolean): BottomNavigationView {
        iBottomNavigation.enableBNItemViewLabelVisibility(position, enable)
        return this
    }

    override fun enableItemHorizontalTranslation(enable: Boolean): BottomNavigationView {
        iBottomNavigation.enableLabelVisibility(enable)
        return this
    }

    override fun getCurrentIndex(): Int {
        return iBottomNavigation.getCurrentIndex()
    }

    override fun menuItemPositionAt(item: MenuItem): Int {
        return iBottomNavigation.menuItemPositionAt(item)
    }

    override fun setCurrentItem(index: Int): BottomNavigationView {
        iBottomNavigation.setCurrentItem(index)
        return this
    }

    override fun getMenuListener(): IMenuListener? {
        return iBottomNavigation.getMenuListener()
    }

    override fun setMenuListener(menuListener: IMenuListener): BottomNavigationView {
        iBottomNavigation.setMenuListener(menuListener)
        return this
    }

    override fun setMenuDoubleClickListener(menuDoubleClickListener: IMenuDoubleClickListener): BottomNavigationView {
        iBottomNavigation.setMenuDoubleClickListener(menuDoubleClickListener)
        return this
    }

    override fun getBNMenuView(): BottomNavigationMenuView {
        return iBottomNavigation.getBNMenuView()
    }

    override fun clearIconTintColor(): BottomNavigationView {
        iBottomNavigation.clearIconTintColor()
        return this
    }

    override fun getAllBNItemView(): Array<BottomNavigationItemView> {
        return iBottomNavigation.getAllBNItemView().asList().toTypedArray()
    }

    override fun getBNItemView(position: Int): BottomNavigationItemView? {
        return iBottomNavigation.getBNItemView(position)
    }

    override fun getIconAt(position: Int): ImageView? {
        return iBottomNavigation.getIconAt(position)
    }

    override fun getSmallLabelAt(position: Int): TextView? {
        return iBottomNavigation.getSmallLabelAt(position)
    }

    override fun getLargeLabelAt(position: Int): TextView? {
        return iBottomNavigation.getLargeLabelAt(position)
    }

    override fun getBNItemViewCount(): Int {
        return iBottomNavigation.getBNItemViewCount()
    }

    override fun setSmallTextSize(sp: Float): BottomNavigationView {
        iBottomNavigation.setSmallTextSize(sp)
        return this
    }

    override fun setLargeTextSize(sp: Float): BottomNavigationView {
        iBottomNavigation.setLargeTextSize(sp)
        return this
    }

    override fun setTextSize(sp: Float): BottomNavigationView {
        iBottomNavigation.setTextSize(sp)
        return this
    }

    override fun setIconSizeAt(position: Int, width: Float, height: Float): BottomNavigationView {
        iBottomNavigation.setIconSizeAt(position, width, height)
        return this
    }

    override fun setIconSize(width: Float, height: Float): BottomNavigationView {
        iBottomNavigation.setIconSize(width, height)
        return this
    }

    override fun setIconSize(dpSize: Float): BottomNavigationView {
        iBottomNavigation.setIconSize(dpSize)
        return this
    }

    override fun setBNMenuViewHeight(height: Int): BottomNavigationView {
        iBottomNavigation.setBNMenuViewHeight(height)
        return this
    }

    override fun getBNMenuViewHeight(): Int {
        return iBottomNavigation.getBNMenuViewHeight()
    }

    override fun setTypeface(typeface: Typeface, style: Int): BottomNavigationView {
        iBottomNavigation.setTypeface(typeface, style)
        return this
    }

    override fun setTypeface(typeface: Typeface): BottomNavigationView {
        iBottomNavigation.setTypeface(typeface)
        return this
    }

    override fun setupWithViewPager(vp: ViewPager?): BottomNavigationView {
        iBottomNavigation.setupWithViewPager(vp)
        return this
    }

    override fun setupWithViewPager(
        vp: ViewPager?,
        smoothScroll: Boolean
    ): BottomNavigationView {
        iBottomNavigation.setupWithViewPager(vp, smoothScroll)
        return this
    }

    override fun setupWithViewPager2(vp2: ViewPager2?): BottomNavigationView {
        iBottomNavigation.setupWithViewPager2(vp2)
        return this
    }

    override fun setupWithViewPager2(
        vp2: ViewPager2?,
        smoothScroll: Boolean
    ): BottomNavigationView {
        iBottomNavigation.setupWithViewPager2(vp2, smoothScroll)
        return this
    }

    override fun setBNItemViewBackgroundRes(position: Int, background: Int): BottomNavigationView {
        iBottomNavigation.setBNItemViewBackgroundRes(position, background)
        return this
    }

    override fun setIconTintList(tint: ColorStateList?): BottomNavigationView {
        iBottomNavigation.setIconTintList(tint)
        return this
    }

    override fun setIconTintList(position: Int, tint: ColorStateList?): BottomNavigationView {
        iBottomNavigation.setIconTintList(position, tint)
        return this
    }

    override fun setTextTintList(tint: ColorStateList?): BottomNavigationView {
        iBottomNavigation.setTextTintList(tint)
        return this
    }

    override fun setTextTintList(position: Int, tint: ColorStateList?): BottomNavigationView {
        iBottomNavigation.setTextTintList(position, tint)
        return this
    }

    override fun setIconsMarginTop(marginTop: Int): BottomNavigationView {
        iBottomNavigation.setIconsMarginTop(marginTop)
        return this
    }

    override fun setIconMarginTop(position: Int, marginTop: Int): BottomNavigationView {
        iBottomNavigation.setIconMarginTop(position, marginTop)
        return this
    }

    override fun setInnerListener(listener: InnerListener) {
        throw IllegalStateException("can not call this")
    }

    override fun setEmptyMenuIds(emptyMenuIds: List<Int>): BottomNavigationView {
        iBottomNavigation.setEmptyMenuIds(emptyMenuIds)
        return this
    }

    override fun getMenuItems(): List<MenuItem> {
        return iBottomNavigation.getMenuItems()
    }

    override fun getMenu(): Menu {
        return iBottomNavigation.getMenu()
    }

    override fun restoreInstanceState(state: Parcelable?) {

    }

    override fun saveInstanceState(): Parcelable? {
        return null
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        try {
            super.onRestoreInstanceState(null)
        } catch (e: Exception) {
        }
        iBottomNavigation.restoreInstanceState(state)
    }

    override fun onSaveInstanceState(): Parcelable? {
        try {
            super.onSaveInstanceState()
        } catch (e: Exception) {
        }
        return iBottomNavigation.saveInstanceState()
    }

}