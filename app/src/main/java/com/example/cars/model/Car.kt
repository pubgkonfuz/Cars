package com.example.cars.model

import java.io.Serializable

data class Car(
    val image: String,
    val name: String,
    val year: Int
):Serializable
