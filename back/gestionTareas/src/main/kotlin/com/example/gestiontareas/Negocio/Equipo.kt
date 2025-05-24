package com.example.gestiontareas.Negocio

class Equipo
{
    var id_equipo = 0
    var nombre = ""
    var descripcion = ""
    var fecha_creacion = ""
    var id_usu_lider = 0

    constructor(id_equipo: Int, nombre: String, descripcion: String, fecha_creacion: String, id_usu_lider: Int)
    {
        this.id_equipo = id_equipo
        this.nombre = nombre
        this.descripcion = descripcion
        this.fecha_creacion = fecha_creacion
        this.id_usu_lider = id_usu_lider
    }

    override fun toString(): String {
        return "Equipo(nombre: '$nombre', descripcion: '$descripcion', fecha de creacion: '$fecha_creacion')"
    }
}