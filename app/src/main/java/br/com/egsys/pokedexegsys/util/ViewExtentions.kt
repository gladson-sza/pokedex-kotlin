package br.com.egsys.pokedexegsys.util

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.graphics.drawable.DrawableCompat

fun View.setBackgroundTintColor(hexColor: String) {
    var drawable: Drawable = this.background
    drawable = DrawableCompat.wrap(drawable)
    DrawableCompat.setTint(drawable, Color.parseColor(hexColor))
    this.background = drawable
}

fun View.hideSoftKeyboard() {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}