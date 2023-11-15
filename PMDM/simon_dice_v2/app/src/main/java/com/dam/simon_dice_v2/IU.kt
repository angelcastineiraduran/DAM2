package com.dam.simon_dice_v2

import android.R
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MiInterfaz() {
    Column (
        modifier = Modifier
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally // centra los compos de la Column
    ) {
        Text(text = "Simon dice", modifier = Modifier.padding(10.dp), Color.White)

        Row {
            Button(
                onClick = { /*ACCION*/},
                colors = ButtonDefaults.buttonColors(Color.Red),
            ) { Text(text = "b1")}
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = { /*ACCION*/},
                colors = ButtonDefaults.buttonColors(Color.Yellow),
            ) { Text(text = "b1") }
        }
        Row {
            Button(
                onClick = { /*ACCION*/},
                colors = ButtonDefaults.buttonColors(Color.Green),
            ) { Text(text = "b1") }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = { /*ACCION*/},
                colors = ButtonDefaults.buttonColors(Color.Blue),
            ) { Text(text = "b1") }
        }
        Button(
            onClick = {/*ACCION*/},
            shape = CutCornerShape(0),
            modifier = Modifier
                .padding(10.dp)
        ) { Text(text = "Start") }
    }
}