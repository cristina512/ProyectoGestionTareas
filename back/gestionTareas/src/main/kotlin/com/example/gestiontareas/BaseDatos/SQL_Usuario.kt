package com.example.gestiontareas.BaseDatos

object SQL_Usuario
{
    const val usuario: String = "usuario"
    const val id: String = "ID_USUARIO"
    const val nombre: String = "NOMBRE"
    const val email: String = "EMAIL"
    const val password: String = "PASSWORD"
    const val fecha_registro: String = "FECHA_REGISTRO"


    const val SELECT_BY_CODIGO = "SELECT * FROM $usuario WHERE $id = ?"
    const val SELECT_ALL = "SELECT * FROM $usuario"
    const val INSERT = "INSERT INTO $usuario ($id, $nombre, $email, $password, $fecha_registro) VALUES (?, ?, ?, ?, ?)"
    const val UPDATE = "UPDATE $usuario SET $nombre = ? WHERE $id = ?"
    const val DELETE = "DELETE FROM $usuario WHERE $id = ?"
}