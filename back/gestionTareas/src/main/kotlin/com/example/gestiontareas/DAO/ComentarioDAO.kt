package com.example.gestiontareas.DAO

import com.example.gestiontareas.Negocio.Comentario

interface ComentarioDAO
{
    fun getComentarioByID(id: Int): Comentario?
    fun getAllComentarios(): List<Comentario>
    fun insertComentario(comentario: Comentario): Boolean
    fun updateComentario(comentario: Comentario): Boolean
    fun deleteComentario(id: Int): Boolean
}