package br.com.gladson.pokedex.data.datasource

import android.content.Context

class AppPreference(context: Context) {

    private companion object {
        const val PREFERENCES_NAME = "pokedex.sp"
        const val ENTRIES_QUANTITY = "entries_quantity"
    }

    private val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun setEntryQuantity(quantity: Int) {
        val editor = preferences.edit()
        editor.putInt(ENTRIES_QUANTITY, quantity)
        editor.apply()
    }

    fun getEntryQuantity() = preferences.getInt(ENTRIES_QUANTITY, 0)
}