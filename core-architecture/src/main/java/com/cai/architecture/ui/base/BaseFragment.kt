package com.cai.architecture.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.cai.base.navigation.NavHostFragment

abstract class BaseFragment : Fragment() {

    /**
     * 改短一点，单纯为了好看...
     */
    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, state: Bundle?): View {
        return super.onCreateView(inflater, root, state)!!
    }

    protected fun nav(): NavController {
        return NavHostFragment.findNavController(this)
    }
}