package org.example.gestiontareas.CONTROLLER

import com.example.debbddajavafx.AccesoDatos.TareaDAOImpl
import com.example.debbddajavafx.Negocio.Tarea
import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Alert
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField
import javafx.stage.Stage

class HelloControllerTarea {
    @FXML private lateinit var comboTareas: ComboBox<Tarea>
    @FXML private lateinit var txtCodigo: TextField
    @FXML private lateinit var txtNombre: TextField

    private val dao = TareaDAOImpl()

    @FXML
    fun initialize() {
        cargarTareas()

        comboTareas.setOnAction {
            val seleccionada = comboTareas.selectionModel.selectedItem
            if (seleccionada != null) {
                txtCodigo.text = seleccionada.codigo.toString()
                txtNombre.text = seleccionada.nombre
            }
        }
    }

    private fun cargarTareas() {
        val lista = FXCollections.observableArrayList(dao.getAllTareas())
        comboTareas.items = lista
    }

    @FXML
    fun cerrarVentana(event: ActionEvent) {
        val nodo = event.source as Node
        val ventana = nodo.scene.window as Stage
        ventana.close()
    }

    @FXML
    fun anadirTarea(event: ActionEvent) {
        try {
            val nuevoCodigo = dao.getAllTareas().maxOfOrNull { it.codigo }?.plus(1) ?: 1
            val nombre = txtNombre.text

            if (nombre.isBlank()) {
                mostrarAlerta("Advertencia", "El nombre no puede estar vacío.")
                return
            }

            if (dao.insertTarea(Tarea(nuevoCodigo, nombre))) {
                mostrarAlerta("Éxito", "Tarea añadida con código $nuevoCodigo.")
                cargarTareas()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo añadir la tarea.")
            }
        } catch (e: Exception) {
            mostrarAlerta("Error", "Error al añadir: ${e.message}")
        }
    }

    @FXML
    fun modificarTarea(event: ActionEvent) {
        try {
            val codigo = txtCodigo.text.toInt()
            val nombre = txtNombre.text

            if (dao.updateTarea(Tarea(codigo, nombre))) {
                mostrarAlerta("Éxito", "Tarea modificada correctamente.")
                cargarTareas()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo modificar la tarea.")
            }
        } catch (e: Exception) {
            mostrarAlerta("Error", "Datos inválidos: ${e.message}")
        }
    }

    @FXML
    fun borrarTarea(event: ActionEvent) {
        try {
            val codigo = txtCodigo.text.toInt()

            if (dao.deleteTarea(codigo)) {
                mostrarAlerta("Éxito", "Tarea borrada correctamente.")
                cargarTareas()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo borrar la tarea.")
            }
        } catch (e: Exception) {
            mostrarAlerta("Error", "Datos inválidos: ${e.message}")
        }
    }

    private fun limpiarCampos() {
        txtCodigo.clear()
        txtNombre.clear()
        comboTareas.selectionModel.clearSelection()
    }

    private fun mostrarAlerta(titulo: String, contenido: String) {
        val alert = Alert(Alert.AlertType.INFORMATION)
        alert.title = titulo
        alert.contentText = contenido
        alert.showAndWait()
    }

}