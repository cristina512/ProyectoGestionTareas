package org.example.gestiontareas.CONTROLLER

import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Alert
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField
import javafx.stage.Stage
import org.example.gestiontareas.DAO.UsuarioDAOImpl
import org.example.gestiontareas.NEGOCIO.Usuario

class HelloControllerUsuario {
    @FXML private lateinit var comboUsuarios: ComboBox<Usuario>
    @FXML private lateinit var txtCodigo: TextField
    @FXML private lateinit var txtNombre: TextField

    private val dao = UsuarioDAOImpl()

    @FXML
    fun initialize() {
        cargarUsuarios()

        comboUsuarios.setOnAction {
            val seleccionada = comboUsuarios.selectionModel.selectedItem
            if (seleccionada != null) {
                txtCodigo.text = seleccionada.id_usuario.toString()
                txtNombre.text = seleccionada.nombre
            }
        }
    }

    private fun cargarUsuarios() {
        val lista = FXCollections.observableArrayList(dao.getAllUsuarios())
        comboUsuarios.items = lista
    }

    @FXML
    fun cerrarVentana(event: ActionEvent) {
        val nodo = event.source as Node
        val ventana = nodo.scene.window as Stage
        ventana.close()
    }

    @FXML
    fun anadirUsuario(event: ActionEvent) {
        try {
            val nuevoCodigo = dao.getAllUsuarios().maxOfOrNull { it.id_usuario }?.plus(1) ?: 1
            val nombre = txtNombre.text
            val email=""
            val password=""
            val fecha_registro=""
            if (nombre.isBlank()) {
                mostrarAlerta("Advertencia", "El nombre no puede estar vacío.")
                return
            }

            if (dao.insertUsuario(Usuario(nuevoCodigo, nombre,email,password,fecha_registro))) {
                mostrarAlerta("Éxito", "Usuario añadido con código $nuevoCodigo.")
                cargarUsuarios()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo añadir el usuario.")
            }
        } catch (e: Exception) {
            mostrarAlerta("Error", "Error al añadir: ${e.message}")
        }
    }

    @FXML
    fun modificarUsuario(event: ActionEvent) {
        try {
            val codigo = txtCodigo.text.toInt()
            val nombre = txtNombre.text
            val email=""
            val password=""
            val fecha_registro=""
            if (dao.updateUsuario(Usuario(codigo, nombre,email,password,fecha_registro))) {
                mostrarAlerta("Éxito", "Usuario modificado correctamente.")
                cargarUsuarios()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo modificar el usuario.")
            }
        } catch (e: Exception) {
            mostrarAlerta("Error", "Datos inválidos: ${e.message}")
        }
    }

    @FXML
    fun borrarUsuario(event: ActionEvent) {
        try {
            val codigo = txtCodigo.text.toInt()

            if (dao.deleteUsuario(codigo)) {
                mostrarAlerta("Éxito", "Usuario borrado correctamente.")
                cargarUsuarios()
                limpiarCampos()
            } else {
                mostrarAlerta("Error", "No se pudo borrar el usuario.")
            }
        } catch (e: Exception) {
            mostrarAlerta("Error", "Datos inválidos: ${e.message}")
        }
    }

    private fun limpiarCampos() {
        txtCodigo.clear()
        txtNombre.clear()
        comboUsuarios.selectionModel.clearSelection()
    }

    private fun mostrarAlerta(titulo: String, contenido: String) {
        val alert = Alert(Alert.AlertType.INFORMATION)
        alert.title = titulo
        alert.contentText = contenido
        alert.showAndWait()
    }

}