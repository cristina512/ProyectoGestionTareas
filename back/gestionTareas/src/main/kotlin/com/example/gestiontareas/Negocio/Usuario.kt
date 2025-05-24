package com.example.gestiontareas.Negocio

class Usuario
{
    var id_usuario = 0
    var nombre = ""
    var email = ""
    var password = ""
    var fecha_registro = ""

    constructor(id_usuario: Int, nombre: String, email: String, password: String, fecha_registro: String)
    {
        this.id_usuario = id_usuario
        this.nombre = nombre
        this.email = email
        this.password = password
        this.fecha_registro = fecha_registro
    }

    override fun toString(): String {
        return "Usuario(nombre: '$nombre', email: '$email', password: '$password')"
    }
}