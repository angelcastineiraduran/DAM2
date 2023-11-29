package com.dam.teoriacompose
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