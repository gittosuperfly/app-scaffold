package com.cai.base.widget.bottombar

import android.view.MenuItem

interface IMenuListener {
    fun onNavigationItemSelected(position: Int, menu: MenuItem, isReSelected: Boolean): Boolean
}

abstract class AbsMenuListener : IMenuListener {
    override fun onNavigationItemSelected(
        position: Int,
        menu: MenuItem,
        isReSelected: Boolean
    ): Boolean {
        return true
    }

    abstract fun onEmptyItemClick(position: Int, menu: MenuItem)
}

interface IMenuDoubleClickListener {
    fun onDoubleClick(position: Int, menu: MenuItem)
}