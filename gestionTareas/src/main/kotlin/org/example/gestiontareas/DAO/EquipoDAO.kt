package org.example.gestiontareas.DAO

import org.example.gestiontareas.NEGOCIO.Equipo


interface EquipoDAO {
    fun getEquipoByID(id: Int): Equipo?
    fun getAllEquipos(): List<Equipo>
    fun insertEquipo(equipo: Equipo): Boolean
    fun updateEquipo(Equipo: Equipo): Boolean
    fun deleteEquipo(id: Int): Boolean
}