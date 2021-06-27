package com.abbas.compose.common

import androidx.fragment.app.Fragment

interface NavigationHost {

    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean = true)

    fun pop()

}