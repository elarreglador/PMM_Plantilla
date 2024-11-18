package com.elarreglador.pmm_parcial1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elarreglador.pmm_parcial1.reusable.TextCheck


@Composable
fun Dos(navController: NavController, listado: SnapshotStateList<TextCheck>) {



//    Scaffold (
//        topBar = {},
//        content = { paddingValues -> }
            // Aplicar modifier = Modifier.padding(paddingValues)
            // al elemento conteniddo
//        bottomBar = {},
//    )

    // Contenido de la pantalla Dos
    Scaffold (

        topBar = {
            Row (
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    "Pantalla Dos",
                    modifier = Modifier.padding(10.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }
        },

        bottomBar = {
            Row (
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(MaterialTheme.colorScheme.secondary)
            ){
                Button(
                    modifier = Modifier.padding(10.dp),
                    onClick = {
                        listado.add(TextCheck(false, "elemento ${listado.size + 1}"))
                    }
                ) {
                    Text("+")
                }

                Button(
                    // Deshabilitar el botón si la lista está vacía
                    enabled = listado.isNotEmpty(),
                    modifier = Modifier
                        .padding(10.dp),
                    onClick = {
                        listado.removeAt(listado.size-1)
                    }
                ) {
                    Text("-")
                }

                Button(
                    modifier = Modifier.padding(10.dp),
                    onClick = {
                        navController.navigate("Uno")
                    }
                ) {
                    Text("Ir a la pantalla Uno")
                }
            }
        },

        content = { paddingValues ->
            // Aplicar modifier = Modifier.padding(paddingValues)
            // al elemento conteniddo
            LazyColumn(
                verticalArrangement = Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                items(listado.size) { index ->
                    val item = listado[index]
                    Row(
                        verticalAlignment = CenterVertically
                    ) {
                        Checkbox(
                            checked = item.isChecked,
                            onCheckedChange = {
                            listado[index] = item.copy(isChecked = it)
                        })
                        Text(text = item.text)
                    }
                }


            }
        }

    )

}



@Preview(showSystemUi = true)
@Composable
fun DosPreview(){
    val navController = rememberNavController()
    val listado = remember { mutableStateListOf<TextCheck>() }
    Dos(navController, listado)
}