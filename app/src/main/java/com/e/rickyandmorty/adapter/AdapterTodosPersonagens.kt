package com.e.rickyandmorty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.rickyandmorty.R
import com.e.rickyandmorty.models.personagem.Results
import kotlinx.android.synthetic.main.item_personagem.view.*

class AdapterTodosPersonagens(val listaTodosPersonagens : List<Results>, val listener: personagemOnClickListener) : RecyclerView.Adapter<AdapterTodosPersonagens.PersonagemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonagemViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_personagem, parent, false)
        return PersonagemViewHolder(item)
    }

    override fun onBindViewHolder(holder: PersonagemViewHolder, position: Int) {
        val personagem = listaTodosPersonagens[position]

        holder.nomePersonagem.text = personagem.name
        holder.especiePersonagem.text = personagem.species

        holder.itemView.setOnClickListener{
            listener.escolhePersonagem(position)
        }

    }

    interface personagemOnClickListener{

        fun escolhePersonagem(position: Int)


    }

    override fun getItemCount() = listaTodosPersonagens.size

    inner class PersonagemViewHolder(item : View) : RecyclerView.ViewHolder(item) {

        val nomePersonagem : TextView = item.tv_item_nome_personagem
        val especiePersonagem : TextView = item.tv_item_specie_personagem

    }
}