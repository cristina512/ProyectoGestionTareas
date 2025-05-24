package com.example.gestiontareas.Negocio

class Comentario
{
    var id_comentario = 0
    var contenido = ""
    var fecha_creacion = ""
    var id_usuario = 0
    var id_tarea = 0

    constructor(id_comentario: Int, contenido: String, fecha_creacion: String, id_usuario: Int, id_tarea: Int)
    {
        this.id_comentario = id_comentario
        this.contenido = contenido
        this.fecha_creacion = fecha_creacion
        this.id_usuario = id_usuario
        this.id_tarea = id_tarea
    }

    override fun toString(): String {
        return "Comentario(contenido: '$contenido', fecha de creación: '$fecha_creacion')"
    }
}