package com.capitansolnan.calculate2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.capitansolnan.calculate2.ui.theme.Calculate2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculate2Theme {
                    BMIScreen(

                    )
            }
        }
    }
}


@Composable
fun BMIScreen() {
    var nom: String by remember { mutableStateOf(value = "") }
    var pes: Int by remember { mutableStateOf(value = 80) }
    var altura: Int by remember { mutableStateOf(value = 170) }
    var imc: Double by remember { mutableStateOf(value = 0.0) }
    Column() {
        Text(
            text = "Calculate 2",
            modifier = Modifier.padding(16.dp)
        )
        TextField(
            value = nom,
            onValueChange = { nom = it },
            label = {
                Text("Nom")
            },
            modifier = Modifier.padding(16.dp)
        )
        Row() {
            Text(text = "Pes: $pes Kg")
            Button(onClick = { pes++ }) {
                Text(text = "+")
            }
            Button(onClick = { pes-- }) {
                Text(text = "-")
            }
        }
        Text(text = "Altura: $altura cm")
        Slider(
            value = altura.toFloat(),
            onValueChange = { altura = it.toInt() },
            valueRange = 100f..300f,
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = {
            val alturaMetros = altura / 100.0
            imc = pes / (alturaMetros * alturaMetros)
        }) {
            Text(text = "Calculate")
        }
        Text(text = "IMC: $imc")

    }
}


@Preview(showBackground = true)
@Composable
fun BMIScreenPreview() {
    Calculate2Theme {
        BMIScreen()
    }
}

