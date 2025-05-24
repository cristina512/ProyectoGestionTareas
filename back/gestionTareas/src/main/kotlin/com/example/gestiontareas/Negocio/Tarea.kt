package com.example.gestiontareas.Negocio

class Tarea
{
    var id_tarea = 0
    var titulo = ""
    var descripcion = ""
    var fecha_creacion = ""
    var fecha_vencimiento = ""
    var id_usu_creador = 0
    var id_usu_asignado = 0
    var id_proyecto = 0

    constructor(id_tarea: Int, titulo: String, descripcion: String, fecha_creacion: String, fecha_vencimiento: String, id_usu_creador: Int, id_usu_asignado: Int, id_proyecto: Int)
    {
        this.id_tarea = id_tarea
        this.titulo = titulo
        this.descripcion = descripcion
        this.fecha_creacion = fecha_creacion
        this.fecha_vencimiento = fecha_vencimiento
        this.id_usu_creador = id_usu_creador
        this.id_usu_asignado = id_usu_asignado
        this.id_proyecto = id_proyecto
    }

    override fun toString(): String {
        return "Tarea(titulo: '$titulo', descripcion: '$descripcion', fecha de creacion: '$fecha_creacion', fecha de vencimiento: '$fecha_vencimiento')"
    }
}