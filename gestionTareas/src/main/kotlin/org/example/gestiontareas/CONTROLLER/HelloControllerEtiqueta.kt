package org.example.gestiontareas.CONTROLLER

import com.example.debbddajavafx.AccesoDatos.EtiquetaDAOImpl
import com.example.debbddajavafx.Negocio.Etiqueta
import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Alert
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField
import javafx.stage.Stage

class HelloControllerEtiqueta {
    @FXML
    private lateinit var comboEtiquetas: ComboBox<Etiqueta>
    @FXML
    private lateinit var txtCodigo: TextField
    @FXML
    private lateinit var txtDescripcion: TextField

    private val dao = EtiquetaDAOImpl()

    @FXML
    fun initialize() {
        cargarEtiquetas()

        comboEtiquetas.setOnAction {
            val seleccionada = comboEtiquetas.selectionModel.selectedItem
            if (seleccionada != null) {
                txtCodigo.text = seleccionada.codigo.toString()
                txtDescripcion.text = seleccionada.descripcion
            }
        }
    }

    private fun cargarEtiquetas() {
        val lista = FXCollections.observableArrayList(dao.getAllEtiquetas())
        comboEtiquetas.items = lista
    }

    @FXML
    fun cerrarVentana(event: ActionEvent) {
        val nodo = event.source as Node
        val ventana = nodo.scene.window as Stage
        ventana.close()
    }

    @FXML
    fun anadirEtiqueta(event: ActionEvent) {
        try {
            val nuevoCodigo = dao.getAllEtiquetas().maxOfOrNull { it.codigo }?.plus(1) ?: 1
            val descripcion = txtDescripcion.text

            if (descripcion.isBlank()) {
                mostrarAlerta("Advertencia", "La descripción no puede estar vacía.")
                return
            }

            if (dao.insertEtiqueta(Etiqueta(nuevoCodigo, descripcion))) {
                mostrarAlerta("Éxito", "Etiqueta añadida con código $nuevoCodigo.")
                cargarEtiquetas()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo añadir la etiqueta.")
            }
        } catch (e: Exception) {
            mostrarAlerta("Error", "Error al añadir: ${e.message}")
        }
    }

    @FXML
    fun modificarEtiqueta(event: ActionEvent) {
        try {
            val codigo = txtCodigo.text.toInt()
            val descripcion = txtDescripcion.text

            if (dao.updateEtiqueta(Etiqueta(codigo, descripcion))) {
                mostrarAlerta("Éxito", "Etiqueta modificada correctamente.")
                cargarEtiquetas()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo modificar la etiqueta.")
            }
        } catch (e: Exception) {
            mostrarAlerta("Error", "Datos inválidos: ${e.message}")
        }
    }

    @FXML
    fun borrarEtiqueta(event: ActionEvent) {
        try {
            val codigo = txtCodigo.text.toInt()

            if (dao.deleteEtiqueta(codigo)) {
                mostrarAlerta("Éxito", "Etiqueta borrada correctamente.")
                cargarEtiquetas()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo borrar la etiqueta.")
            }
        } catch (e: Exception) {
            mostrarAlerta("Error", "Datos inválidos: ${e.message}")
        }
    }

    private fun limpiarCampos() {
        txtCodigo.clear()
        txtDescripcion.clear()
        comboEtiquetas.selectionMod

    }

}