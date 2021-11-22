package ru.sberschool.hystrix

class FallbackSlowlyApi : SlowlyApi {
    override fun getPokemonByName(pokemonName: String): Pokemon = Pokemon(0, "Fallback $pokemonName", 0, 0)
}


