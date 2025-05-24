package com.example.gestiontareas.Presentacion

import com.example.gestiontareas.DAO.TareaDAOImp
import com.example.gestiontareas.DAO.UsuarioDAOImp
import com.example.gestiontareas.Negocio.Tarea
import com.example.gestiontareas.Negocio.Usuario
import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.ChoiceBox
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField
import java.net.URL
import java.util.ResourceBundle

class TareaController
{
    private val dao = TareaDAOImp()
    private val dao2 = UsuarioDAOImp()

    @FXML
    private lateinit var ChbEtiqueta: ChoiceBox<String>

    @FXML
    private lateinit var CmbTareas: ComboBox<Tarea>

    @FXML
    private lateinit var CmbUsuarios: ComboBox<Usuario>

    private fun initialize(p0: URL?, p1: ResourceBundle?)
    {
        ChbEtiqueta.items.add("Prioridad Alta")
        ChbEtiqueta.items.add("Prioridad Media")
        ChbEtiqueta.items.add("Prioridad Baja")
        ChbEtiqueta.selectionModel.select(0)
    }

    private fun cargarTareas()
    {
        val lista = FXCollections.observableArrayList(dao.getAllTarea())
        CmbTareas.items = lista
    }

    private fun cargarUsuario()
    {
        val lista = FXCollections.observableArrayList(dao2.getAllUsuario())
        CmbUsuarios.items = lista
    }
}