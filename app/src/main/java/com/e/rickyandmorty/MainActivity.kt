package com.e.rickyandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.e.rickyandmorty.models.personagem.ViewModelPersonagens

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<ViewModelPersonagens>{
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ViewModelPersonagens(service) as T
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getTodosPersonagens()
        viewModel.todosPersonagens.observe(this, {
            Log.i("MainActivity", it.toString())
        })

    }
}