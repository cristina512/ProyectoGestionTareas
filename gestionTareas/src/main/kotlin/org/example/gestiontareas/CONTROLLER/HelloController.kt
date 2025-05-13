package com.example.debbddajavafx.Presentacion

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.VBox
import javafx.stage.Stage

class HelloController {

    @FXML
    fun cargarCategorias(event: ActionEvent) {
        cargarVentana("categorias.fxml", "Gestionar Categorías")
    }

    @FXML
    fun cargarProyectos(event: ActionEvent) {
        cargarVentana("proyecto.fxml", "Gestionar Proyectos")
    }

    @FXML
    fun cargarTareas(event: ActionEvent) {
        cargarVentana("tarea.fxml", "Gestionar Tareas")
    }

    @FXML
    fun cargarUsuarios(event: ActionEvent) {
        cargarVentana("usuario.fxml", "Gestionar Usuarios")
    }

    @FXML
    fun cargarEquipos(event: ActionEvent) {
        cargarVentana("equipo.fxml", "Gestionar Equipos")
    }

    @FXML
    fun cargarEtiquetas(event: ActionEvent) {
        cargarVentana("etiqueta.fxml", "Gestionar Etiquetas")
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