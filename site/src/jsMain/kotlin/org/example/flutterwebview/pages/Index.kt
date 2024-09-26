package org.example.flutterwebview.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.forms.Button
import org.jetbrains.compose.web.dom.Text

fun invokeClick(){
    js("MessageInvoker.invokeClick('clicked')")
}

@Page
@Composable
fun HomePage() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {invokeClick()}){
            Text("Click me!")
        }
    }
}
