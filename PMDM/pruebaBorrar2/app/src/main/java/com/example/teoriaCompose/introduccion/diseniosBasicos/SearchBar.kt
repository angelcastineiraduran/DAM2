package com.example.teoriaCompose.introduccion.diseniosBasicos

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pruebaborrar2.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchBar(modificador: Modifier = Modifier) {
    TextField(
        // campo vacio inicialmente
        value = "",
        // el estado no haria nada:
        onValueChange = { /*TODO*/},
        modifier = modificador
            // altura minima Especifica
            .heightIn(min = 56.dp)
            // ocupa tod0 el espacio horizontal de su elemento superior
            .fillMaxWidth(),
        // agregamos el icono de la lupa
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                // no necesita descripcion porque el campo ded txt ya define su
                // significado
                contentDescription = null
            )
        },
        // color de fondo del campo txt. en lugar de un param por separado para
        // cada color, el elemento componible contiene un param combinado.
        // con TextFieldDefaults pasas una copia de la clase de datos en
        // la que solo actualizas los colores que son diferentes, y en este
        // caso se trata solo de los colores: unfocused... y focusedLabel..
        colors = TextFieldDefaults.textFieldColors(
            // me da error con los que habia en la guia y puse esos elementos
            unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
            focusedLabelColor = MaterialTheme.colorScheme.surface
        ),
        // el placeholder en un ele TextField representa el txt que se muestra dentro
        // del campo cuando esta vacio y no tiene ningun valor ingresado por el usu.
        placeholder = {
            // esto lo tengo que agregar en values -> strings -> <añadir entrada xml>
            Text(stringResource(id = R.string.placeholder_search))
        }
    )
}

@Composable
fun MyApp() {
    SearchBar()
}

@Preview(showBackground = true)
@Composable
fun preview() {
    MyApp()
}
