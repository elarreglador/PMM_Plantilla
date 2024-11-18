package com.elarreglador.pmm_parcial1.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elarreglador.pmm_parcial1.reusable.TextCheck


@Composable
fun Dos(navController: NavController, listado: SnapshotStateList<TextCheck>) {

    // Contenido de la pantalla Dos
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ){
        Text("Pantalla Dos")
        Button(
            onClick = {
                navController.navigate("Uno")
            }
        ) {
            Text("Ir a la pantalla Uno")
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun DosPreview(){
    val navController = rememberNavController()
    val listado = remember { mutableStateListOf<TextCheck>() }
    Dos(navController, listado)
}