package org.example.gestiontareas.DAO

import org.example.gestiontareas.NEGOCIO.Usuario

interface Usuario {
    fun getUsuarioByID(id: Int): Usuario?
    fun getAllUsuarios(): List<Usuario>
    fun insertUsuario(usuario: Usuario): Boolean
    fun updateUsuario(usuario: Usuario): Boolean
    fun deleteUsuario(id: Int): Boolean
}