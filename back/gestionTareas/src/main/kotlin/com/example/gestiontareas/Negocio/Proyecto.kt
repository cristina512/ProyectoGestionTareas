package com.example.gestiontareas.Negocio

class Proyecto
{
    var id_proyecto = 0
    var nombre = ""
    var descripcion = ""
    var fecha_inicio:String? = ""
    var fecha_fin:String? = ""
    var id_equipo: String? = ""

    constructor(id_proyecto: Int, nombre: String, descripcion: String, fecha_inicio: String, fecha_fin: String, id_equipo: String)
    {
        this.id_proyecto = id_proyecto
        this.nombre = nombre
        this.descripcion = descripcion
        this.fecha_inicio = fecha_inicio
        this.fecha_fin = fecha_fin
        this.id_equipo = id_equipo
    }

    override fun toString(): String {
        return "Proyecto(nombre: '$nombre', descripcion: '$descripcion', fecha de inicio: $fecha_inicio, fecha fin: $fecha_fin)"
    }
}