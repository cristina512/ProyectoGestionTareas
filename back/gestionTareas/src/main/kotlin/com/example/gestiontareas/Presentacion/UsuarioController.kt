package com.example.gestiontareas.Presentacion

import com.example.gestiontareas.DAO.UsuarioDAOImp
import com.example.gestiontareas.Negocio.Usuario
import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField

class UsuarioController
{
    private val dao = UsuarioDAOImp()

    @FXML
    private lateinit var CmbUsuarios: ComboBox<Usuario>

    @FXML
    private lateinit var txtCodigo: TextField

    @FXML
    private lateinit var txtNombre: TextField

    private fun cargarUsuario()
    {
        val lista = FXCollections.observableArrayList(dao.getAllUsuario())
        CmbUsuarios.items = lista
    }

    @FXML
    fun initialize()
    {
        cargarUsuario()

        CmbUsuarios.setOnAction {
            val seleccionado = CmbUsuarios.selectionModel.selectedItem
            if(seleccionado != null)
            {
                txtNombre.text = seleccionado.nombre
                txtCodigo.text = seleccionado.id_usuario.toString()
            }
        }
    }

    @FXML
    fun OnClickAñadir(event: ActionEvent)
    {
        try
        {
            val nuevoCodigo = dao.getAllUsuario().maxOfOrNull { it.id_usuario }?.plus(1) ?: 1
            val nombre = txtNombre.text
            val email = ""
            val password = ""
            val fecha_registro = ""

            if(nombre.isBlank())
            {
                mostrarAlerta("Advertencia", "El nombre no puede estar vacío")
                return
            }
            if(dao.insertUsuario(Usuario(nuevoCodigo, nombre, email, password, fecha_registro)))
            {
                cargarUsuario()
                limpiarCampos()
            }
            else
            {
                mostrarAlerta("Error", "No se pudo añadir el usuario.")
            }
        }
        catch(e: Exception)
        {
            mostrarAlerta("Error", "Error al añadir: ${e.message}")
        }
    }


    @FXML
    fun OnClickModificar(event: ActionEvent)
    {
        try
        {
            val nombre = txtNombre.text
            val codigo = txtCodigo.text.toInt()
            val email = ""
            val password = ""
            val fecha_registro = ""

            if(dao.updateUsuario(Usuario(codigo, nombre, email, password, fecha_registro)))
                {
                mostrarAlerta("Éxito", "Usuario modificado correctamente.")
                cargarUsuario()
                limpiarCampos()
                }
            else
                {
                mostrarAlerta("Error", "No se pudo modificar el usuario.")
                }
        }
        catch(e: Exception)
        {
            mostrarAlerta("Error", "Datos inválidos ${e.message}")
        }
    }

    @FXML
    fun OnClickBorrar(event: ActionEvent)
    {
        try
        {
            val codigo = txtCodigo.text.toInt()

            if(dao.deleteUsuario(codigo))
            {
                mostrarAlerta("Éxito", "Usuario borrado correctamente.")
                cargarUsuario()
                limpiarCampos()
            }
            else
            {
                mostrarAlerta("Error", "No se pudo borrar el usuario.")
            }
        }
        catch(e: Exception)
        {
            mostrarAlerta("Error", "Datos inválidos: ${e.message}")
        }
    }

    fun limpiarCampos()
    {
        txtNombre.clear()
        txtCodigo.clear()
        CmbUsuarios.selectionModel.clearSelection()
    }

    private fun mostrarAlerta(titulo: String, contenido: String)
    {
        val alert = Alert(Alert.AlertType.INFORMATION)

        alert.title = titulo
        alert.contentText = contenido
        alert.showAndWait()
    }
}