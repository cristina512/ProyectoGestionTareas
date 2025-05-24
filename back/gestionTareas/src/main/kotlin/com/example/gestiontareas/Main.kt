package com.example.gestiontareas

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("main-view.fxml"))
        val scene = Scene(fxmlLoader.load())
        stage.title = "Aplicación de Gestión de Tareas"
        stage.scene = scene
        stage.setOnCloseRequest { event ->
            val alert = Alert(Alert.AlertType.CONFIRMATION)
            alert.title = "Saliendo de la Aplicación"
            alert.headerText = "¿Estás seguro de que quieres salir?"
            alert.buttonTypes.setAll(ButtonType.YES, ButtonType.NO)
            alert.contentText = "¿Estás seguro?"

            val res = alert.showAndWait()
            if(res.get() == ButtonType.NO) event.consume()
        }
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}