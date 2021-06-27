package com.abbas.compose.common

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(){

    protected var navigationHost: NavigationHost? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationHost){
            this.navigationHost = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.navigationHost = null
    }

    abstract fun onViewCreated(composeView: ComposeView)

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext())
    }

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (view is ComposeView) {
            onViewCreated(view)
        }
    }

}