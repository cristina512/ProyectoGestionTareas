package com.example.gestiontareas.DAO

import com.example.gestiontareas.Negocio.Proyecto

interface ProyectoDAO
{
    fun getProyectoByID(id: Int): Proyecto?
    fun getAllProyecto(): List<Proyecto>
    fun insertProyecto(proyeto: Proyecto): Boolean
    fun updateProyecto(proyecto: Proyecto): Boolean
    fun deleteProyecto(id: Int): Boolean
}