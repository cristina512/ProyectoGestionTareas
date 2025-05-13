package org.example.gestiontareas.CONTROLLER

import javafx.fxml.FXML
import javafx.scene.control.*
import dao.ComentarioDAOImpl
import models.Comentario

class HelloControllerComentario {
    @FXML
    private lateinit var comentarioTable: TableView<Comentario>
    @FXML
    private lateinit var idColumn: TableColumn<Comentario, Int>
    @FXML
    private lateinit var contenidoColumn: TableColumn<Comentario, String>
    @FXML
    private lateinit var fechaColumn: TableColumn<Comentario, String>
    @FXML
    private lateinit var usuarioColumn: TableColumn<Comentario, Int>
    @FXML
    private lateinit var tareaColumn: TableColumn<Comentario, Int>
    @FXML
    private lateinit var addButton: Button
    @FXML
    private lateinit var editButton: Button
    @FXML
    private lateinit var deleteButton: Button

    private val comentarioDAO = ComentarioDAOImpl()

    @FXML
    fun initialize() {
        // Configurar las columnas
        idColumn.setCellValueFactory { it.value.id_comentarioProperty().asObject() }
        contenidoColumn.setCellValueFactory { it.value.contenidoProperty() }
        fechaColumn.setCellValueFactory { it.value.fecha_creacionProperty() }
        usuarioColumn.setCellValueFactory { it.value.id_usuarioProperty().asObject() }
        tareaColumn.setCellValueFactory { it.value.id_tareaProperty().asObject() }

        // Cargar datos
        comentarioTable.items.addAll(comentarioDAO.getAllComentarios())

        // Configurar botones
        addButton.setOnAction { agregarComentario() }
        editButton.setOnAction { editarComentario() }
        deleteButton.setOnAction { eliminarComentario() }
    }

    private fun agregarComentario() {
        // Lógica para agregar un comentario
    }

    private fun editarComentario() {
        // Lógica para editar un comentario
    }

    private fun eliminarComentario() {
        val comentarioSeleccionado = comentarioTable.selectionModel.selectedItem
        if (comentarioSeleccionado != null) {
            comentarioDAO.deleteComentario(comentarioSeleccionado.id_comentario)
            comentarioTable.items.remove(comentarioSeleccionado)
        }
    }

}