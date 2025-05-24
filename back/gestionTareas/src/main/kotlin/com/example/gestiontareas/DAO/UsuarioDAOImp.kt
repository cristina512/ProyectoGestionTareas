package com.example.gestiontareas.DAO

import com.example.gestiontareas.BaseDatos.ConexionBD
import com.example.gestiontareas.BaseDatos.SQL_Usuario
import com.example.gestiontareas.Negocio.Usuario

class UsuarioDAOImp: UsuarioDAO
{
    private val conexion = ConexionBD()

    override fun getUsuarioByID(id: Int): Usuario? {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Usuario.SELECT_BY_CODIGO)
        ps?.setInt(1, id)
        val rs = ps?.executeQuery()
        var usuario: Usuario? = null
        if (rs?.next() == true) {
            usuario = Usuario(rs.getInt("ID_USUARIO"), rs.getString("NOMBRE"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("FECHA_REGISTRO"))
        }
        ps?.close()
        conexion.desconectar()
        return usuario
    }

    override fun getAllUsuario(): List<Usuario> {
        conexion.conectar()
        val st = conexion.getStatement()
        val rs = st?.executeQuery(SQL_Usuario.SELECT_ALL)
        val usuarios = mutableListOf<Usuario>()
        while (rs?.next() == true) {
            val usuario = Usuario(rs.getInt("ID_USUARIO"), rs.getString("NOMBRE"), rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("FECHA_REGISTRO"))
            usuarios.add(usuario)
        }
        st?.close()
        conexion.desconectar()
        return usuarios
    }

    override fun insertUsuario(usuario: Usuario): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Usuario.INSERT)
        ps?.setInt(1, usuario.id_usuario)
        ps?.setString(2, usuario.nombre)
        ps?.setString(3, usuario.email)
        ps?.setString(4, usuario.password)
        ps?.setString(5, usuario.fecha_registro)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateUsuario(usuario: Usuario): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Usuario.UPDATE)
        ps?.setString(1, usuario.nombre)
        ps?.setInt(2, usuario.id_usuario)
        ps?.setString(3, usuario.email)
        ps?.setString(4, usuario.password)
        ps?.setString(5, usuario.fecha_registro)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteUsuario(id: Int): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Usuario.DELETE)
        ps?.setInt(1, id)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1

    }
}