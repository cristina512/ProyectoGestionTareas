package com.example.gestiontareas.BaseDatos

object SQL_Etiqueta
{
    const val etiqueta: String = "etiqueta"
    const val id: String = "ID_ETIQUETA"
    const val nombre: String = "NOMBRE"
    const val id_usuario: String = "ID_USUARIO"
    const val id_equipo: String = "ID_EQUIPO"

    const val SELECT_BY_CODIGO = "SELECT * FROM $etiqueta WHERE $id = ?"
    const val SELECT_ALL = "SELECT * FROM $etiqueta"
    const val INSERT = "INSERT INTO $etiqueta ($id, $nombre, $id_usuario, $id_equipo) VALUES (?, ?, ?, ?)"
    const val UPDATE = "UPDATE $etiqueta SET $nombre = ? WHERE $id = ?"
    const val DELETE = "DELETE FROM $etiqueta WHERE $id = ?"
}