package com.example.objectifcompose.data

import androidx.annotation.DrawableRes
import com.example.objectifcompose.R

data class Planet(
    val name: String,
    @DrawableRes
    val drawable: Int
)

val planet = Planet("Mercure", R.mipmap.mercure)

val planets = listOf(
    Planet("Mercure", R.mipmap.mercure),
    Planet("Venus", R.mipmap.venus),
    Planet("Terre", R.mipmap.terre),
    Planet("Mars", R.mipmap.mars),
    Planet("Jupiter", R.mipmap.jupiter),
    Planet("Saturne", R.mipmap.saturne),
    Planet("Uranus", R.mipmap.uranus),
    Planet("Neptune", R.mipmap.neptune),
)
