package com.example.gestiontareas.DAO

import com.example.gestiontareas.Negocio.Usuario

interface UsuarioDAO
{
    fun getUsuarioByID(id: Int): Usuario?
    fun getAllUsuario(): List<Usuario>
    fun insertUsuario(usuario: Usuario): Boolean
    fun updateUsuario(usuario: Usuario): Boolean
    fun deleteUsuario(id: Int): Boolean
}