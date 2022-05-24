package com.rodriguesalex.commoms.bindadapter

import android.view.View
import androidx.databinding.BindingAdapter
import com.rodriguesalex.commoms.extensions.gone
import com.rodriguesalex.commoms.extensions.visible

object BindAdapters {

    @JvmStatic
    @BindingAdapter("isViewVisible")
    fun setViewVisibility(view: View, visibility: Boolean?) {
        visibility?.let {
            if (it) {
                view.visible()
            } else {
                view.gone()
            }
        }
    }
}
