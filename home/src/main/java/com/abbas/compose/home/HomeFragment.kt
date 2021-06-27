package com.abbas.compose.home

import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import com.abbas.compose.common.BaseFragment

class HomeFragment : BaseFragment() {

    override fun onViewCreated(composeView: ComposeView) {
        composeView.setContent {
            Text("home")
        }
    }

    companion object {
        fun createInstance() = HomeFragment()
    }

}