package com.e.rickyandmorty.models.personagem

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.rickyandmorty.Service
import kotlinx.coroutines.launch

class ViewModelPersonagens(val service: Service) : ViewModel() {

    //essa é a variavél que vai ficar escutando o retorno do service
    val todosPersonagens = MutableLiveData<List<Results>>()

    fun getTodosPersonagens() {
        viewModelScope.launch {
            todosPersonagens.value = service.getTodosPersonagensRepo().results
            Log.i("ViewModelPersonagens", todosPersonagens.toString())


        }
    }


}