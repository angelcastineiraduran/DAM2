package com.example.pruebaborrar2

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.pruebaborrar2.datos.SampleData
import com.example.pruebaborrar2.ui.theme.PruebaBorrar2Theme

@Composable
fun Conversation(messages: List<Mensaje>) {
    LazyColumn {
        items(messages) { message ->
            MensajesVarios(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    PruebaBorrar2Theme {
        Conversation(SampleData.conversationSample)
    }
}
