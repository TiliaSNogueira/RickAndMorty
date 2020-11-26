package com.e.rickyandmorty.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.e.rickyandmorty.R
import com.e.rickyandmorty.adapter.AdapterTodosPersonagens
import com.e.rickyandmorty.repository.service
import kotlinx.android.synthetic.main.fragment_exibe_personagens.*
import kotlinx.android.synthetic.main.fragment_exibe_personagens.view.*


class FragmentExibePersonagens : Fragment(), AdapterTodosPersonagens.personagemOnClickListener {

    var page = 1

    private lateinit var personagemAdapter: AdapterTodosPersonagens
    private lateinit var layoutManagerP: LinearLayoutManager


    private val viewModel by viewModels<ViewModelFragmenteExibePersonagens> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ViewModelFragmenteExibePersonagens(service) as T
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_exibe_personagens, container, false)

        //configurar adapter
        layoutManagerP = LinearLayoutManager(context)
        view.rv_exibe_personagens.layoutManager = layoutManagerP
        view.rv_exibe_personagens.setHasFixedSize(true)
        viewModel.todosPersonagens.observe(viewLifecycleOwner, {
            personagemAdapter = AdapterTodosPersonagens(it, this)
            view.rv_exibe_personagens.adapter = personagemAdapter
        })

        viewModel.getTodosPersonagens(page)



        setScrollView(view)


        return view
    }

    private fun setScrollView(view: View) {
        view.rv_exibe_personagens?.run {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    //itens passados por cada pagina (no caso dessa api são 20 itens)
                    var itensTotais = personagemAdapter?.itemCount

                    //debug falou que 2 (começa no 0)
                    val ultimoItenVisivel = layoutManagerP.findLastVisibleItemPosition()

                    if (ultimoItenVisivel == itensTotais - 1) {
                        page++
                        viewModel.getTodosPersonagens(page)
                    }

                }
            })

        }

    }

    override fun escolhePersonagem(position: Int) {
        viewModel.todosPersonagens.observe(this, {
            val escolhido = it.get(position)
            Toast.makeText(
                context,
                escolhido.name + " id: " + escolhido.id,
                Toast.LENGTH_SHORT
            )
                .show()
        })
    }


}