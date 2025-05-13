package org.example.gestiontareas.CONTROLLER

import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Alert
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField
import javafx.stage.Stage
import org.example.gestiontareas.DAO.EquipoDAOImpl
import org.example.gestiontareas.NEGOCIO.Equipo


class HelloControllerEquipo {
    @FXML private lateinit var comboEquipos: ComboBox<Equipo>
    @FXML private lateinit var txtId: TextField
    @FXML private lateinit var txtNombre: TextField

    private val dao = EquipoDAOImpl()

    @FXML
    fun initialize() {
        cargarEquipos()

        comboEquipos.setOnAction {
            val seleccionado = comboEquipos.selectionModel.selectedItem
            if (seleccionado != null) {
                txtId.text = seleccionado.id_equipo.toString()
                txtNombre.text = seleccionado.nombre
            }
        }
    }

    private fun cargarEquipos() {
        val lista = FXCollections.observableArrayList(dao.getAllEquipos())
        comboEquipos.items = lista
    }

    @FXML
    fun cerrarVentana(event: ActionEvent) {
        val nodo = event.source as Node
        val ventana = nodo.scene.window as Stage
        ventana.close()
    }

    @FXML
    fun anadirEquipo(event: ActionEvent) {
        val nuevoId = dao.getAllEquipos().maxOfOrNull { it.id_equipo }?.plus(1) ?: 1
        val nombre = txtNombre.text
        val descripcion=""
        val fecha_creacion=""
        val id_usu_lider=0
        if (nombre.isBlank()) {
            mostrarAlerta("Advertencia", "El nombre no puede estar vacío.")
            return
        }

        if (dao.insertEquipo(Equipo(nuevoId, nombre, descripcion, fecha_creacion, id_usu_lider))) {
            mostrarAlerta("Éxito", "Equipo añadido correctamente.")
            cargarEquipos()
            limpiarCampos()
        } else {
            mostrarAlerta("Error", "No se pudo añadir el equipo.")
        }
    }

    @FXML
    fun modificarEquipo(event: ActionEvent) {
        try {
            val id = txtId.text.toInt()
            val nombre = txtNombre.text
            val descripcion=""
            val fecha_creacion=""
            val id_usu_lider=0

            if (dao.updateEquipo(Equipo(id, nombre,descripcion,fecha_creacion,id_usu_lider))) {
                mostrarAlerta("Éxito", "Equipo modificado correctamente.")
                cargarEquipos()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo modificar el equipo.")
            }
        } catch (e: Exception) {
            mostrarAlerta("Error", "Datos inválidos: ${e.message}")
        }
    }

    @FXML
    fun borrarEquipo(event: ActionEvent) {
        try {
            val id = txtId.text.toInt()

            if (dao.deleteEquipo(id)) {
                mostrarAlerta("Éxito", "Equipo eliminado correctamente.")
                cargarEquipos()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo eliminar el equipo.")
            }
        } catch (e: Exception) {
            mostrarAlerta("Error", "Datos inválidos: ${e.message}")
        }
    }

    private fun limpiarCampos() {
        txtId.clear()
        txtNombre.clear()
        comboEquipos.selectionModel.clearSelection()
    }

    private fun mostrarAlerta(titulo: String, contenido: String) {
        val alerta = Alert(Alert.AlertType.INFORMATION)
        alerta.title = titulo
        alerta.contentText = contenido
        alerta.showAndWait()
    }

}