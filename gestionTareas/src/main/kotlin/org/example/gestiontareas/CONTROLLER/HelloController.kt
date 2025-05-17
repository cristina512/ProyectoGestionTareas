package org.example.gestiontareas.CONTROLLER

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.VBox
import javafx.stage.Stage

class HelloController {

    @FXML
    fun cargarComentarios(event: ActionEvent) {
        cargarVentana("/org/example/gestiontareas/comentario-view.fxml", "Gestionar Comentarios")
    }

    @FXML
    fun cargarProyectos(event: ActionEvent) {
        cargarVentana("/org/example/gestiontareas/proyecto-view.fxml", "Gestionar Proyectos")
    }

    @FXML
    fun cargarTareas(event: ActionEvent) {
        cargarVentana("/org/example/gestiontareas/tarea-view.fxml", "Gestionar Tareas")
    }

    @FXML
    fun cargarUsuarios(event: ActionEvent) {
        cargarVentana("/org/example/gestiontareas/usuario-view.fxml", "Gestionar Usuarios")
    }

    @FXML
    fun cargarEquipos(event: ActionEvent) {
        cargarVentana("/org/example/gestiontareas/equipo-view.fxml", "Gestionar Usuarios")
    }

    @FXML
    fun cargarEtiquetas(event: ActionEvent) {
        cargarVentana("/org/example/gestiontareas/etiqueta-view.fxml", "Gestionar Etiquetas")
    }

    private fun cargarVentana(fxmlFile: String, titulo: String) {
        try {
            val loader = FXMLLoader(javaClass.getResource(fxmlFile))
            val root = loader.load<AnchorPane>()
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