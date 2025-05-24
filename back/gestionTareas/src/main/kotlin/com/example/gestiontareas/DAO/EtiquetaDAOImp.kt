package com.example.gestiontareas.DAO

import com.example.gestiontareas.BaseDatos.ConexionBD
import com.example.gestiontareas.BaseDatos.SQL_Etiqueta
import com.example.gestiontareas.Negocio.Etiqueta

class EtiquetaDAOImp: EtiquetaDAO
{
    private val conexion = ConexionBD()

    override fun getEtiquetaByID(id: Int): Etiqueta? {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Etiqueta.SELECT_BY_CODIGO)
        ps?.setInt(1, id)
        val rs = ps?.executeQuery()
        var etiqueta: Etiqueta? = null
        if (rs?.next() == true) {
            etiqueta = Etiqueta(rs.getInt("ID_ETIQUETA"), rs.getString("NOMBRE"), rs.getInt("ID_USUARIO"), rs.getInt("ID_EQUIPO"))
        }
        ps?.close()
        conexion.desconectar()
        return etiqueta
    }

    override fun getAllEtiquetas(): List<Etiqueta> {
        conexion.conectar()
        val st = conexion.getStatement()
        val rs = st?.executeQuery(SQL_Etiqueta.SELECT_ALL)
        val etiquetas = mutableListOf<Etiqueta>()
        while (rs?.next() == true) {
            val etiqueta = Etiqueta(rs.getInt("ID_ETIQUETA"), rs.getString("NOMBRE"), rs.getInt("ID_USUARIO"), rs.getInt("ID_EQUIPO"))
            etiquetas.add(etiqueta)
        }
        st?.close()
        conexion.desconectar()
        return etiquetas
    }

    override fun insertEtiqueta(etiqueta: Etiqueta): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Etiqueta.INSERT)
        ps?.setInt(1, etiqueta.id_etiqueta)
        ps?.setString(2, etiqueta.nombre)
        ps?.setInt(3, etiqueta.id_usuario)
        ps?.setInt(4, etiqueta.id_equipo)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateEtiqueta(etiqueta: Etiqueta): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Etiqueta.UPDATE)
        ps?.setString(1, etiqueta.nombre)
        ps?.setInt(2, etiqueta.id_etiqueta)
        ps?.setInt(3, etiqueta.id_usuario)
        ps?.setInt(4, etiqueta.id_equipo)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteEtiqueta(id: Int): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Etiqueta.DELETE)
        ps?.setInt(1, id)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }
}