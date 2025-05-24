package com.example.gestiontareas.Presentacion

import com.example.gestiontareas.DAO.EquipoDAOImp
import com.example.gestiontareas.Negocio.Equipo
import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField

class EquipoController
{
    private val dao = EquipoDAOImp()

    @FXML
    private lateinit var CmbEquipos: ComboBox<Equipo>

    @FXML
    private lateinit var txtDescripcion: TextField

    @FXML
    private lateinit var txtFechaCreacion: TextField

    @FXML
    private lateinit var txtJefeEquipo: TextField

    @FXML
    private lateinit var txtNombreEquipo: TextField

    fun initialize()
    {
        cargarEquipos()
        CmbEquipos.setOnAction {
            val seleccionado = CmbEquipos.selectionModel.selectedItem
            if(seleccionado != null)
            {
                txtNombreEquipo.text = seleccionado.nombre
                txtDescripcion.text = seleccionado.descripcion
                txtFechaCreacion.text = seleccionado.fecha_creacion
                //txtJefeEquipo.text = seleccionado.id_usu_lider
            }
        }
    }

    @FXML
    fun OnClickAñadir(event: ActionEvent)
    {
        val nuevoID = dao.getAllEquipos().maxOfOrNull { it.id_equipo }?.plus(1) ?: 1
        val nombre = txtNombreEquipo.text
        val descripcion = txtDescripcion.text
        val fecha_creacion = txtFechaCreacion.text
        //val id_usu_lider = txtJefeEquipo.text.toInt()

        if(nombre.isBlank())
        {
            mostrarAlerta("Advertencia", "El nombre no puede estar vacío.")
        }
        else if (dao.insertEquipo(Equipo(nuevoID, nombre, descripcion, fecha_creacion, id_usu_lider = 1)))
        {
            mostrarAlerta("Éxito", "Equipo añadido correctamente.")
            cargarEquipos()
            limpiarCampos()
        }
        else
        {
            mostrarAlerta("Error", "No se pudo añadir el equipo.")
        }
    }

    @FXML
    fun OnClickModificar(event: ActionEvent)
    {
        try
        {
            val seleccionado = CmbEquipos.selectionModel.selectedItem
            val id = seleccionado.id_equipo
            val nombre = txtNombreEquipo.text
            val descripcion = txtDescripcion.text
            val fecha_creacion = txtFechaCreacion.text
            //val id_usu_lider = txtjefeEquipo.text.toInt()
            if (dao.updateEquipo(Equipo(id, nombre,descripcion,fecha_creacion, id_usu_lider = 1)))
            {
                mostrarAlerta("Éxito", "Equipo modificado correctamente.")
                cargarEquipos()
                limpiarCampos()
            }
            else
            {
                mostrarAlerta("Error", "No se pudo modificar el equipo.")
            }
        }
        catch (e: Exception)
        {
            mostrarAlerta("Error", "Datos inválidos: ${e.message}")
        }
    }

    @FXML
    fun OnClickEliminar(event: ActionEvent)
    {
        try
        {
            val seleccionado = CmbEquipos.selectionModel.selectedItem
            val id = seleccionado.id_equipo

            if (dao.deleteEquipo(id))
            {
                mostrarAlerta("Éxito", "Equipo eliminado correctamente.")
                cargarEquipos()
                limpiarCampos()
            }
            else
            {
                mostrarAlerta("Error", "No se pudo eliminar el equipo.")
            }
        }
        catch (e: Exception)
        {
            mostrarAlerta("Error", "Datos inválidos: ${e.message}")
        }
    }
    private fun cargarEquipos()
    {
        val lista = FXCollections.observableArrayList(dao.getAllEquipos())
        CmbEquipos.items = lista
    }

    fun limpiarCampos()
    {
        txtNombreEquipo.clear()
        txtDescripcion.clear()
        txtFechaCreacion.clear()
        txtJefeEquipo.clear()
    }

    private fun mostrarAlerta(titulo: String, contenido: String)
    {
        val alert = Alert(Alert.AlertType.INFORMATION)

        alert.title = titulo
        alert.contentText = contenido
        alert.showAndWait()
    }
}