package com.e.rickyandmorty.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.rickyandmorty.models.personagem.Results
import com.e.rickyandmorty.repository.Service
import com.e.rickyandmorty.repository.service
import kotlinx.coroutines.launch

class ViewModelFragmentDetalhesPersonagem(service: Service) : ViewModel () {

    //essa é a variavél que vai ficar escutando o retorno do service
    val personagemPeloID = MutableLiveData<Results>()

    fun getPersonagemPeloID(id : Int) {
        viewModelScope.launch {
            personagemPeloID.value = service.getPersonagemPeloIDRepo(id)
            Log.i("PESONAGEM PELO ID", personagemPeloID.toString())


        }
    }
}