package com.elarreglador.pmm_parcial1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.composable

import com.elarreglador.pmm_parcial1.screens.Uno
import com.elarreglador.pmm_parcial1.screens.Dos

@Composable
fun Navigator() {

    // Estado compartido entre pantallas
    val listado = remember { mutableStateListOf<com.elarreglador.pmm_parcial1.reusable.TextCheck>() }

    // Navegacion
    val navController = androidx.navigation.compose.rememberNavController()
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = "Uno"
    ) {
        composable("Uno") {
            Uno(navController, listado)
        }
        composable("Dos") {
            Dos(navController, listado)
        }
    }

}