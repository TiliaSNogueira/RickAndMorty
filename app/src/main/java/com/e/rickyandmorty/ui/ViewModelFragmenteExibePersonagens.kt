package com.e.rickyandmorty.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.rickyandmorty.repository.Service
import com.e.rickyandmorty.models.personagem.Results
import kotlinx.coroutines.launch

class ViewModelFragmenteExibePersonagens(val service: Service) : ViewModel() {

    //essa é a variavél que vai ficar escutando o retorno do service
    val todosPersonagens = MutableLiveData<List<Results>>()

    fun getTodosPersonagens(page: Int) {
        viewModelScope.launch {
            todosPersonagens.value = service.getTodosPersonagensRepo(page).results
            Log.i("ViewModelPersonagens", todosPersonagens.toString())


        }
    }


}