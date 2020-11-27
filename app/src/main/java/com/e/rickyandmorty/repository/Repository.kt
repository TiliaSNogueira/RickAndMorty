package com.e.rickyandmorty.repository

import com.e.rickyandmorty.models.personagem.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//aqui teremos a interface que implementa os métodos que fazem a requisição e também a instancia do service

interface Service {

    @GET("character")
    suspend fun getTodosPersonagensRepo(
        @Query("page") page: Int = 1
    ): PersonagemWrapper

    @GET("character/{id}")
    suspend fun getPersonagemPeloIDRepo(@Path("id") id: Int): Results


}

val retrofit = Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/")
    .addConverterFactory(GsonConverterFactory.create()).build()

val service: Service = retrofit.create(Service::class.java)