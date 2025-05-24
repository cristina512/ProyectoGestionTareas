package com.example.gestiontareas.BaseDatos

object SQL_Comentario
{
    const val comentario: String = "comentario"
    const val id: String = "ID_COMENTARIO"
    const val contenido: String = "CONTENIDO"
    const val fecha_creacion: String = "FECHA_CREACION"
    const val id_usuario: String = "ID_USUARIO"
    const val id_tarea: String = "ID_TAREA"

    const val SELECT_BY_CODIGO = "SELECT * FROM $comentario WHERE $id = ?"
    const val SELECT_ALL = "SELECT ^FROM $comentario"
    const val INSERT = "INSERT INTO $comentario ($id, $contenido, $fecha_creacion, $id_usuario, $id_tarea) VALUES (?, ?, ?, ?, ?)"
    const val UPDATE = "UPDATE $comentario SET $contenido = ? WHERE $id = ?"
    const val DELETE = "DELETE FROM $comentario WHERE $id = ?"
}