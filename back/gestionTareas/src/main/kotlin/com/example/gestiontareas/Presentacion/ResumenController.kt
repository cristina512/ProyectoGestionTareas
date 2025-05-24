package com.example.gestiontareas.Presentacion

import com.example.gestiontareas.DAO.ComentarioDAOImp
import com.example.gestiontareas.DAO.TareaDAOImp
import com.example.gestiontareas.DAO.UsuarioDAOImp
import com.example.gestiontareas.Negocio.Comentario
import javafx.beans.property.SimpleStringProperty
import javafx.fxml.FXML
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView

class ResumenController
{
    private val dao = ComentarioDAOImp()


    @FXML
    private lateinit var tblResumen: TableView<Comentario>

    @FXML
    private lateinit var colContenido: TableColumn<Comentario, String>

    @FXML
    private lateinit var colFecha: TableColumn<Comentario, String>

    @FXML
    private lateinit var colTarea: TableColumn<Comentario, String>

    @FXML
    private lateinit var colUsuario: TableColumn<Comentario, String>

   /* @FXML
    fun initialize() {
        colUsuario.setCellValueFactory {
            SimpleStringProperty(it.value.usuario.nombre)
        }
        // Cargar datos
        tblResumen.items.addAll(dao.getAllComentarios())
    }*/
}