package org.example.gestiontareas.CONTROLLER

import com.example.debbddajavafx.AccesoDatos.ProyectoDAOImpl
import com.example.debbddajavafx.Negocio.Proyecto
import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Alert
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField
import javafx.stage.Stage


class HelloControllerProyecto {
    @FXML private lateinit var comboProyectos: ComboBox<Proyecto>
    @FXML private lateinit var txtCodigo: TextField
    @FXML private lateinit var txtNombre: TextField

    private val dao = ProyectoDAOImpl()

    @FXML
    fun initialize() {
        cargarProyectos()

        comboProyectos.setOnAction {
            val seleccionada = comboProyectos.selectionModel.selectedItem
            if (seleccionada != null) {
                txtCodigo.text = seleccionada.codigo.toString()
                txtNombre.text = seleccionada.nombre
            }
        }
    }

    private fun cargarProyectos() {
        val lista = FXCollections.observableArrayList(dao.getAllProyectos())
        comboProyectos.items = lista
    }

    @FXML
    fun cerrarVentana(event: ActionEvent) {
        val nodo = event.source as Node
        val ventana = nodo.scene.window as Stage
        ventana.close()
    }

    @FXML
    fun anadirProyecto(event: ActionEvent) {
        try {
            val nuevoCodigo = dao.getAllProyectos().maxOfOrNull { it.codigo }?.plus(1) ?: 1
            val nombre = txtNombre.text

            if (nombre.isBlank()) {
                mostrarAlerta("Advertencia", "El nombre no puede estar vacío.")
                return
            }

            if (dao.insertProyecto(Proyecto(nuevoCodigo, nombre))) {
                mostrarAlerta("Éxito", "Proyecto añadido con código $nuevoCodigo.")
                cargarProyectos()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo añadir el proyecto.")
            }
        } catch (e: Exception) {
            mostrarAlerta("Error", "Error al añadir: ${e.message}")
        }
    }

    @FXML
    fun modificarProyecto(event: ActionEvent) {
        try {
            val codigo = txtCodigo.text.toInt()
            val nombre = txtNombre.text

            if (dao.updateProyecto(Proyecto(codigo, nombre))) {
                mostrarAlerta("Éxito", "Proyecto modificado correctamente.")
                cargarProyectos()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo modificar el proyecto.")
            }
        } catch (e: Exception) {
            mostrarAlerta("Error", "Datos inválidos: ${e.message}")
        }
    }

    @FXML
    fun borrarProyecto(event: ActionEvent) {
        try {
            val codigo = txtCodigo.text.toInt()

            if (dao.deleteProyecto(codigo)) {
                mostrarAlerta("Éxito", "Proyecto borrado correctamente.")
                cargarProyectos()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo borrar el proyecto.")
            }
        } catch (e: Exception) {
            mostrarAlerta("Error", "Datos inválidos: ${e.message}")
        }
    }

    private fun limpiarCampos() {
        txtCodigo.clear()
        txtNombre.clear()
        comboProyectos.selectionModel.clearSelection()
    }

    private fun mostrarAlerta(titulo: String, contenido: String) {
        val alert = Alert(Alert.AlertType.INFORMATION)
        alert.title = titulo
        alert.contentText = contenido
        alert.showAndWait()
    }

}