package com.example.teoriaCompose.introduccion.diseniosBasicos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pruebaborrar2.R

@Composable
fun FavouriteCollectionCard(
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                // al establecerlo, el contorno (perteneciente
                // a Surface) que hace de background con el texto se apadta
                // al tamanio de la imagen
                modifier = Modifier.size(80.dp)
            )
            Text(text = stringResource(R.string.ab1_inversions))
        }
    }

}

// colores HTML
@Preview(showBackground = true, backgroundColor = 0xbfff33)
@Composable
fun previewFavouriteCollectionCard() {
    FavouriteCollectionCard(
        modifier = Modifier.padding(8.dp)
    )
}
