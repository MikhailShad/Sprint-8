package ru.sberschool.hystrix

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)
data class Pokemon(
    val id: Long,
    val name: String,
    val height: Long,
    val weight: Long
) {
    constructor() : this(0, "", 0, 0)
}
