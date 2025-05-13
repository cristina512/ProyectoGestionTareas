package org.example.gestiontareas.DAO

import org.example.gestiontareas.NEGOCIO.Tarea

interface TareaDAO {
    fun getTareaByID(id: Int): Tarea?
    fun getAllTareas(): List<Tarea>
    fun insertTarea(tarea: Tarea): Boolean
    fun updateTarea(tarea: Tarea): Boolean
    fun deleteTarea(id: Int): Boolean
}