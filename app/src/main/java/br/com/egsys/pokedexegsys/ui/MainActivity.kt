package br.com.egsys.pokedexegsys.ui

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.ViewCompat
import br.com.egsys.pokedexegsys.R
import br.com.egsys.pokedexegsys.data.model.TypeColor
import br.com.egsys.pokedexegsys.databinding.ActivityMainBinding
import br.com.egsys.pokedexegsys.databinding.ActivitySplashBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}