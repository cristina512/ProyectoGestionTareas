package com.example.gestiontareas.BaseDatos

object SQL_Equipo
{
    const val equipo: String = "equipo"
    const val id: String = "ID_EQUIPO"
    const val nombre: String = "NOMBRE"
    const val descripcion: String = "DESCRIPCION"
    const val fecha_creacion: String = "FECHA_CREACION"
    const val id_usu_lider: String = "ID_USU_LIDER"

    const val SELECT_BY_CODIGO = "SELECT * FROM $equipo WHERE $id = ?"
    const val SELECT_ALL = "SELECT * FROM $equipo"
    const val INSERT = "INSERT INTO $equipo ($id, $nombre, $descripcion, $fecha_creacion, $id_usu_lider) VALUES (?, ?, ?, ?, ?)"
    const val UPDATE = "UPDTAE $equipo SET $nombre = ? WHERE $id = ?"
    const val DELETE = "DELETE FROM $equipo WHERE $id = ?"
}