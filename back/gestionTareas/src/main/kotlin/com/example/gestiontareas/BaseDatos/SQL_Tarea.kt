package com.example.gestiontareas.BaseDatos

object SQL_Tarea
{
    const val tarea: String = "tarea"
    const val id: String = "ID_TAREA"
    const val nombre: String = "TITULO"
    const val descripcion: String = "DESCRIPCION"
    const val fecha_creacion: String = "FECHA_CREACION"
    const val fecha_vencimiento: String = "FECHA_VENCIMIENTO"
    const val id_usu_creador: String = "ID_USU_CREADOR"
    const val id_usu_asignado :String="ID_USU_ASIGNADO"
    const val id_proyecto:String="ID_PROYECTO"

    const val SELECT_BY_CODIGO = "SELECT * FROM $tarea WHERE $id = ?"
    const val SELECT_ALL = "SELECT * FROM $tarea"
    const val INSERT = "INSERT INTO $tarea ($id, $nombre, $descripcion, $fecha_creacion, $fecha_vencimiento, $id_usu_creador,$id_usu_asignado,$id_proyecto) VALUES (?, ?, ?, ?, ?, ?,?,?)"
    const val UPDATE = "UPDATE $tarea SET $nombre = ? WHERE $id = ?"
    const val DELETE = "DELETE FROM $tarea WHERE $id = ?"
}