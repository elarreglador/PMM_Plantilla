package com.elarreglador.pmm_parcial1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.elarreglador.pmm_parcial1.ui.theme.PMM_Parcial1Theme
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(key1 = true){
        delay(8000)
        navController.popBackStack()
        navController.navigate("Uno")
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                // Icono de la app
                text = "\uD83D\uDCDD",
                fontSize = 124.sp,
            )

            Spacer(modifier = Modifier.height(100.dp)) // Espacio entre imagen y texto

            // Titulo
            Text(
                text = "Examen PMM: Parcial 1",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp,

            )

            // Subtitulo
            Text(
                text = "19 noviembre 2024   |   15:00",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 17.sp,
            )
            Text(
                text = "IES Abastos, Aula 301",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 17.sp,
            )

            Spacer(modifier = Modifier.height(80.dp))

            // Autor (yo mismo)
            Text(
                text = "David Moreno Bolivar",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp,
            )
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    val navController = androidx.navigation.compose.rememberNavController()
    SplashScreen(navController)
}