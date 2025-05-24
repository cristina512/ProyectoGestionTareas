package com.example.gestiontareas.Negocio

class Etiqueta
{
    var id_etiqueta = 0
    var nombre = ""
    var id_usuario = 0
    var id_equipo = 0

    constructor(id_etiqueta: Int, nombre: String, id_usuario: Int, id_equipo: Int)
    {
        this.id_etiqueta = id_etiqueta
        this.nombre = nombre
        this.id_usuario = id_usuario
        this.id_equipo = id_equipo
    }

    override fun toString(): String {
        return "Etiqueta(nombre: '$nombre')"
    }
}