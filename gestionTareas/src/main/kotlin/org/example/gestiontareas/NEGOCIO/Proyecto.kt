package org.example.gestiontareas.NEGOCIO

class Proyecto {
    var id_proyecto=0
    var nombre=""
    var descripcion=""
    var fecha_inicio:String?=""
    var fecha_fin:String?=""
    var id_equipo:String?=""

    constructor(
        id_proyecto: Int,
        nombre: String,
        descripcion: String,
        fecha_inicio: String,
        fecha_fin: String,
        id_equipo: String
    ) {
        this.id_proyecto = id_proyecto
        this.nombre = nombre
        this.descripcion = descripcion
        this.fecha_inicio = fecha_inicio
        this.fecha_fin = fecha_fin
        this.id_equipo = id_equipo
    }

    override fun toString(): String {
        return "Proyecto(id_proyecto=$id_proyecto, nombre='$nombre', descripcion='$descripcion', fecha_inicio='$fecha_inicio', fecha_fin='$fecha_fin', id_equipo='$id_equipo')"
    }

}