package com.example.teoriaCompose.introduccion

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.teoriaCompose.datos.SampleData
import com.example.teoriaCompose.ui.theme.TeoriaComposeTheme

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
    TeoriaComposeTheme {
        Conversation(SampleData.conversationSample)
    }
}
