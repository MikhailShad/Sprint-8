package ru.sberschool.hystrix

import feign.Param
import feign.RequestLine

interface SlowlyApi {
    @RequestLine("GET /pokemon/{pokemonName}")
    fun getPokemonByName(@Param("pokemonName") pokemonName: String): Pokemon
}


