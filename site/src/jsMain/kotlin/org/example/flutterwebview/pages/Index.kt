package org.example.flutterwebview.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.forms.Button
import kotlinx.browser.document
import org.jetbrains.compose.web.dom.Text

@Page
@Composable
fun HomePage() {
    LaunchedEffect(Unit){
        val script = document.createElement("script")
//        script.asDynamic().src = "/script.js"
        script.textContent = """
            function invokeClick() {
                console.log(" MessageInvoker.postMessage('clicked')")
                MessageInvoker.postMessage('clicked')
            }
        """.trimIndent()
        document.body!!.appendChild(script)
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button({}, Modifier.attrsModifier { attr("onClick", "invokeClick()") }) {
            Text("Click me!")
        }
    }
}
