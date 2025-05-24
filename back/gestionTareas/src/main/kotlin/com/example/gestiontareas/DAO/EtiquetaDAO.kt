package com.example.gestiontareas.DAO

import com.example.gestiontareas.Negocio.Etiqueta

interface EtiquetaDAO
{
    fun getEtiquetaByID(id: Int): Etiqueta?
    fun getAllEtiquetas(): List<Etiqueta>
    fun insertEtiqueta(etiqueta: Etiqueta): Boolean
    fun updateEtiqueta(etiqueta: Etiqueta): Boolean
    fun deleteEtiqueta(id: Int): Boolean
}