package com.example.gestiontareas.BaseDatos

object SQL_Proyecto
{
    const val proyecto: String = "proyecto"
    const val id: String = "ID_PROYECTO"
    const val nombre: String = "NOMBRE"
    const val descripcion: String = "DESCRIPCION"
    const val fecha_inicio: String = "FECHA_INICIO"
    const val fecha_fin: String = "FECHA_FIN"
    const val id_equipo: String = "ID_EQUIPO"

    const val SELECT_BY_CODIGO = "SELECT * FROM $proyecto WHERE $id = ?"
    const val SELECT_ALL = "SELECT * FROM $proyecto"
    const val INSERT = "INSERT INTO $proyecto ($id, $nombre, $descripcion, $fecha_inicio, $fecha_fin, $id_equipo) VALUES (?, ?, ?, ?, ?, ?)"
    const val UPDATE = "UPDATE $proyecto SET $nombre = ? WHERE $id = ?"
    const val DELETE = "DELETE FROM $proyecto WHERE $id = ?"
}