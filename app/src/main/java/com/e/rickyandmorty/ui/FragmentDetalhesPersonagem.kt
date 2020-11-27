package com.e.rickyandmorty.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.e.rickyandmorty.R
import com.e.rickyandmorty.models.personagem.Results
import com.e.rickyandmorty.repository.service
import kotlinx.android.synthetic.main.fragment_detalhes_personagem.*
import kotlinx.android.synthetic.main.fragment_detalhes_personagem.view.*
import kotlinx.android.synthetic.main.item_personagem.view.*

class FragmentDetalhesPersonagem : Fragment() {


    private val viewModel by viewModels<ViewModelFragmentDetalhesPersonagem> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ViewModelFragmentDetalhesPersonagem(service) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detalhes_personagem, container, false)


        //pegar id do outro fragement
        val idPersonagem = arguments?.get("chave") as Int

        viewModel.getPersonagemPeloID(idPersonagem)

        viewModel.personagemPeloID.observe(viewLifecycleOwner, {
            tv_detalhes_personagem_nome.text = it.name
        })

        viewModel.personagemPeloID.observe(viewLifecycleOwner, {
            tv_detalhes_personagem_status.text = it.status
        })


        return view
    }


}