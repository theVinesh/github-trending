package app.vineshbuilds.commons.dataBinding

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View
import android.widget.ImageView
import android.widget.ViewAnimator
import androidx.annotation.ColorInt
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("viewProvider", "viewBinder", "data")
fun setAdapter(
    view: RecyclerView, viewProvider: ViewProvider, viewBinder: ViewBinder, items: List<ViewModel>
) {
    view.adapter = DataBindingRecyclerViewAdapter(viewProvider, viewBinder).apply {
        data = items
    }
}

@BindingAdapter("breathAnimation")
fun startAlphaBreathingAnimation(view: View, start: Boolean) =
    if (start) {
        ObjectAnimator.ofFloat(view, ViewAnimator.ALPHA, 1f, 0.4f).also {
            it.repeatCount = ValueAnimator.INFINITE
            it.repeatMode = ValueAnimator.REVERSE
            it.duration = 400
            it.setAutoCancel(true)
        }.start()
    } else {
        view.animation.cancel()
        view.alpha = 1f
    }

@BindingAdapter("tint")
fun setTint(view: ImageView, @ColorInt tint: Int?) =
    tint?.let { DrawableCompat.setTint(view.drawable, tint) }


@BindingAdapter("visibleOrGone")
fun setVisibleOrGone(view: View, status: Boolean) {
    view.visibility = if (status) View.VISIBLE else View.GONE
}

