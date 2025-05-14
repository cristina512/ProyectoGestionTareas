package org.example.gestiontareas.CONTROLLER

import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Alert
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField
import javafx.stage.Stage
import org.example.gestiontareas.DAO.TareaDAOImpl
import org.example.gestiontareas.NEGOCIO.Tarea

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
                txtCodigo.text = seleccionada.id_tarea.toString()
                txtNombre.text = seleccionada.titulo
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
            val nuevoCodigo = dao.getAllTareas().maxOfOrNull { it.id_tarea }?.plus(1) ?: 1
            val nombre = txtNombre.text
            val descripcion=""
            val fecha_creacion=""
            val fecha_vencimiento=""
            val id_usu_creador=0
            val id_usu_asignado=0
            val id_proyecto=0
            if (nombre.isBlank()) {
                mostrarAlerta("Advertencia", "El nombre no puede estar vacío.")
                return
            }

            if (dao.insertTarea(Tarea(nuevoCodigo, nombre, descripcion, fecha_creacion, fecha_vencimiento, id_usu_creador, id_usu_asignado, id_proyecto))) {
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
            val descripcion=""
            val fecha_creacion=""
            val fecha_vencimiento=""
            val id_usu_creador=0
            val id_usu_asignado=0
            val id_proyecto=0
            if (dao.updateTarea(Tarea(codigo, nombre, descripcion, fecha_creacion, fecha_vencimiento, id_usu_creador, id_usu_asignado, id_proyecto))) {
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