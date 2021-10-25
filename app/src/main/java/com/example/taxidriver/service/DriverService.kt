package com.example.taxidriver.service

import com.example.taxidriver.R
import com.example.taxidriver.model.Driver

class DriverService {
    companion object {
        val listOfDrivers =
            mutableListOf(
                Driver("Brad Pitt", R.drawable.bradpitt, 4.5F, "Aparan"),
                Driver("Will Smith", R.drawable.willsmith, 3F, "Goris"),
                Driver("Nicolas Cage", R.drawable.cage, 1.6F, "Sisian"),
                Driver("Dicaprio", R.drawable.dicaprio, 3.7F, "Yaravan"),
                Driver("Robert De Niro", R.drawable.deniro, 4.5F, "Gyumri"),
                Driver("Piter Dinklage", R.drawable.dinklage, 2.8F, "Khndzoresk"),
                Driver("Keanu Reaves", R.drawable.keanureeves, 4.8F, "Hrazdan"),
                Driver("CHUCK NORRIS", R.drawable.norris, 4.5F, "Earth"),

                )

    }
}