package com.example.gestiontareas

import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.Label
import javafx.stage.Modality
import javafx.stage.Stage

class MainController {
    @FXML
    fun OnClickSalir(event: ActionEvent)
    {
        val alert = Alert(Alert.AlertType.CONFIRMATION)

        alert.title = "Saliendo de la Aplicación"
        alert.buttonTypes.setAll(ButtonType.YES, ButtonType.NO)
        alert.contentText = "¿Estás seguro de que quieres salir?"

        val res = alert.showAndWait()
        if(res.isPresent)
        {
            if(res.get() == ButtonType.YES)
            {
                Platform.exit()
            }
        }
    }

    @FXML
    fun OnClickUsuario(event: ActionEvent)
    {
        val fxmlLoader = FXMLLoader(javaClass.getResource("usuario-view.fxml"))
        val root = fxmlLoader.load<Parent>()

        val stage = Stage()
        stage.title = "Gestión de Usuarios"
        stage.scene = Scene(root)
        stage.show()
    }


    @FXML
    fun OnClickComentario(event: ActionEvent)
    {
        val fxmlLoader = FXMLLoader(javaClass.getResource("resumen-view.fxml"))
        val root = fxmlLoader.load<Parent>()

        val stage = Stage()
        stage.title = "Resumen Tareas"
        stage.scene = Scene(root)
        stage.show()
    }

    @FXML
    fun OnClickEquipo(event: ActionEvent)
    {
        val fxmlLoader = FXMLLoader(javaClass.getResource("equipo-view.fxml"))
        val root = fxmlLoader.load<Parent>()

        val stage = Stage()
        stage.title = "Gestión de Equipos"
        stage.scene = Scene(root)
        stage.show()
    }

    @FXML
    fun OnClickTarea(event: ActionEvent)
    {
        val fxmlLoader = FXMLLoader(javaClass.getResource("tarea-view.fxml"))
        val root = fxmlLoader.load<Parent>()

        val stage = Stage()
        stage.title = "Gestión de Tareas"
        stage.scene = Scene(root)
        stage.show()
    }
}