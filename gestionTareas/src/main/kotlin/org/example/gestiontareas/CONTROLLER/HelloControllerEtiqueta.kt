package org.example.gestiontareas.CONTROLLER

import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Alert
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField
import javafx.stage.Stage
import org.example.gestiontareas.DAO.EtiquetaDAOImpl
import org.example.gestiontareas.NEGOCIO.Etiqueta

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
        
        txtCodigo.isEditable = false

        comboEtiquetas.setOnAction {
            val seleccionada = comboEtiquetas.selectionModel.selectedItem
            if (seleccionada != null) {
                txtCodigo.text = seleccionada.id_etiqueta.toString()
                txtDescripcion.text = seleccionada.nombre
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
            val listaEtiquetas = dao.getAllEtiquetas()
            var maxCodigo = 0


            for (etiqueta in listaEtiquetas) {
                if (etiqueta.id_etiqueta > maxCodigo) {
                    maxCodigo = etiqueta.id_etiqueta
                }
            }

            val nuevoCodigo = maxCodigo + 1
            val descripcion = txtDescripcion.text
            val id_usuario=0
            val id_equipo=0
            if (descripcion.isBlank()) {
                mostrarAlerta("Advertencia", "La descripción no puede estar vacía.")
                return
            }

            if (dao.insertEtiqueta(Etiqueta(nuevoCodigo, descripcion,id_usuario,id_equipo))) {
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
            val id_usuario=0
            val id_equipo=0

            if (dao.updateEtiqueta(Etiqueta(codigo, descripcion,id_usuario,id_equipo))) {
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
    }

    private fun mostrarAlerta(titulo: String, contenido: String) {
        val alerta = Alert(Alert.AlertType.INFORMATION)
        alerta.title = titulo
        alerta.headerText = null
        alerta.contentText = contenido
        alerta.showAndWait()
    }
}
