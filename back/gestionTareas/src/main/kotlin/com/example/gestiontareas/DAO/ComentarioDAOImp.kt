package com.example.gestiontareas.DAO

import com.example.gestiontareas.BaseDatos.ConexionBD
import com.example.gestiontareas.BaseDatos.SQL_Comentario
import com.example.gestiontareas.Negocio.Comentario

class ComentarioDAOImp: ComentarioDAO
{
    private val conexion = ConexionBD()

    override fun getComentarioByID(id: Int): Comentario? {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Comentario.SELECT_BY_CODIGO)
        ps?.setInt(1, id)
        val rs = ps?.executeQuery()
        var comentario: Comentario? = null
        if (rs?.next() == true) {
            comentario = Comentario(rs.getInt("ID_COMENTARIO"), rs.getString("CONTENIDO"), rs.getString("FECHA_CREACION"), rs.getInt("ID_USUARIO"), rs.getInt("ID_TAREA"))
        }
        ps?.close()
        conexion.desconectar()
        return comentario
    }

    override fun getAllComentarios(): List<Comentario> {
        conexion.conectar()
        val st = conexion.getStatement()
        val rs = st?.executeQuery(SQL_Comentario.SELECT_ALL)
        val comentarios = mutableListOf<Comentario>()
        while (rs?.next() == true) {
            val comentario = Comentario(rs.getInt("ID_COMENTARIO"), rs.getString("CONTENIDO"), rs.getString("FECHA_CREACION"), rs.getInt("ID_USUARIO"), rs.getInt("ID_TAREA"))
            comentarios.add(comentario)
        }
        st?.close()
        conexion.desconectar()
        return comentarios
    }

    override fun insertComentario(comentario: Comentario): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Comentario.INSERT)
        ps?.setInt(1, comentario.id_comentario)
        ps?.setString(2, comentario.contenido)
        ps?.setString(3, comentario.fecha_creacion)
        ps?.setInt(4, comentario.id_usuario)
        ps?.setInt(5, comentario.id_tarea)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateComentario(comentario: Comentario): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Comentario.UPDATE)
        ps?.setString(1, comentario.contenido)
        ps?.setInt(2, comentario.id_comentario)
        ps?.setString(3, comentario.fecha_creacion)
        ps?.setInt(4, comentario.id_usuario)
        ps?.setInt(5, comentario.id_tarea)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteComentario(id: Int): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Comentario.DELETE)
        ps?.setInt(1, id)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }
}