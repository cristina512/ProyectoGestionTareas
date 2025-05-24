package com.example.gestiontareas.DAO

import com.example.gestiontareas.Negocio.Tarea
interface TareaDAO
{
    fun getTareaByID(id: Int): Tarea?
    fun getAllTarea(): List<Tarea>
    fun insertTarea(tarea: Tarea): Boolean
    fun updateTarea(tarea: Tarea): Boolean
    fun deleteTarea(id: Int): Boolean
}