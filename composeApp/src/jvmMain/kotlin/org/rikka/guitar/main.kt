package org.rikka.guitar

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "rikka_guitar_app",
    ) {
        App()
    }
}