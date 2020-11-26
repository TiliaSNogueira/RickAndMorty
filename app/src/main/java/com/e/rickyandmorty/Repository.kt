package com.e.rickyandmorty

import com.e.rickyandmorty.models.personagem.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//aqui teremos a interface que implementa os métodos que fazem a requisição e também a instancia do service

interface Service {

    @GET("character")
    suspend fun getTodosPersonagensRepo(): PersonagemWrapper

}

val retrofit = Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/")
    .addConverterFactory(GsonConverterFactory.create()).build()

val service: Service = retrofit.create(Service::class.java)