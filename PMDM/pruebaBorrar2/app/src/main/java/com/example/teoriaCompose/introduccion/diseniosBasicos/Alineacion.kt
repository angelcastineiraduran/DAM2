package com.example.teoriaCompose.introduccion.diseniosBasicos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruebaborrar2.R
import com.example.teoriaCompose.ui.theme.TeoriaComposeTheme

@Composable
fun AlignYourBodyElement(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = null, 
            contentScale = ContentScale.Crop,
            // bordes superiores recortados (pero en este caso se ve =Crop)
            //contentScale = ContentScale.Fit,
            // un poquito mas ampliado que Crop
            //contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(id = R.string.ab1_inversions),
            // ajusta la distancia entre el txt y el borde superior e inferior de
            // su contenedor
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )

    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun previewAlineacion() {
    TeoriaComposeTheme {
        AlignYourBodyElement()
    }
}

