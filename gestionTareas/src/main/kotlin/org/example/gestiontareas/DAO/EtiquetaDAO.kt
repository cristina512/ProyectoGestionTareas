package org.example.gestiontareas.DAO

import org.example.gestiontareas.NEGOCIO.Etiqueta


interface EtiquetaDAO {
    fun getEtiquetaByID(id: Int): Etiqueta?
    fun getAllEtiquetas(): List<Etiqueta>
    fun insertEtiqueta(etiqueta: Etiqueta): Boolean
    fun updateEtiqueta(etiqueta: Etiqueta): Boolean
    fun deleteEtiqueta(id: Int): Boolean
}