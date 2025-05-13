package org.example.gestiontareas.DAO

import org.example.gestiontareas.NEGOCIO.Proyecto

interface ProyectoDAO {
    fun getProyectoByID(id: Int): Proyecto?
    fun getAllProyectos(): List<Proyecto>
    fun insertProyecto(proyecto: Proyecto): Boolean
    fun updateProyecto(proyecto: Proyecto): Boolean
    fun deleteProyecto(id: Int): Boolean
}