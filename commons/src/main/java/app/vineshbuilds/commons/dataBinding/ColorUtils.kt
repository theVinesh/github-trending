package app.vineshbuilds.commons.dataBinding

import android.graphics.Color
import androidx.annotation.ColorInt
import java.util.regex.Pattern

@ColorInt
fun String?.toColor(@ColorInt default: Int = Color.TRANSPARENT): Int =
    Pattern.compile("^#(?:[0-9a-fA-F]{3}){1,2}$").let {
        when {
            this == null -> default
            it.matcher(this).matches() -> Color.parseColor(this)
            it.matcher("#$this").matches() -> Color.parseColor("#$this")
            else -> default
        }
    }


