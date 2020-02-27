package app.vineshbuilds.githubtrending

import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("tint")
fun setTint(view: ImageView, @ColorInt tint: Int?) =
    tint?.let { DrawableCompat.setTint(view.drawable, tint) }
