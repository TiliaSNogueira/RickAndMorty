package com.e.rickyandmorty.models.personagem

import com.google.gson.annotations.SerializedName

data class PersonagemWrapper (

	@SerializedName("info") val info : Info,
	@SerializedName("results") val results : List<Results>
)