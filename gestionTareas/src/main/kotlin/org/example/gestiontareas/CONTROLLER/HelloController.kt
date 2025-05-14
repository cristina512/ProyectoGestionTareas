package org.example.gestiontareas.CONTROLLER

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.VBox
import javafx.stage.Stage

class HelloController {

    @FXML
    fun cargarComentarios(event: ActionEvent) {
        cargarVentana("comentario-view.fxml", "Gestionar Comentarios")
    }

    @FXML
    fun cargarProyectos(event: ActionEvent) {
        cargarVentana("proyecto-view.fxml", "Gestionar Proyectos")
    }

    @FXML
    fun cargarTareas(event: ActionEvent) {
        cargarVentana("tarea-view.fxml", "Gestionar Tareas")
    }

    @FXML
    fun cargarUsuarios(event: ActionEvent) {
        cargarVentana("usuario-view.fxml", "Gestionar Usuarios")
    }

    @FXML
    fun cargarEquipos(event: ActionEvent) {
        cargarVentana("equipo-view.fxml", "Gestionar Equipos")
    }

    @FXML
    fun cargarEtiquetas(event: ActionEvent) {
        cargarVentana("etiqueta-view.fxml", "Gestionar Etiquetas")
    }

    private fun cargarVentana(fxmlFile: String, titulo: String) {
        try {
            val loader = FXMLLoader(javaClass.getResource(fxmlFile))
            val root = loader.load<VBox>()
            val scene = Scene(root)
            val stage = Stage()
            stage.title = titulo
            stage.scene = scene
            stage.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}