package com.example.gestiontareas.DAO

import com.example.gestiontareas.BaseDatos.ConexionBD
import com.example.gestiontareas.BaseDatos.SQL_Equipo
import com.example.gestiontareas.Negocio.Equipo

class EquipoDAOImp: EquipoDAO
{
    private val conexion = ConexionBD()

    override fun getEquipoByID(id: Int): Equipo? {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Equipo.SELECT_BY_CODIGO)
        ps?.setInt(1, id)
        val rs = ps?.executeQuery()
        var equipo: Equipo? = null
        if (rs?.next() == true) {
            equipo = Equipo(rs.getInt("ID_EQUIPO"), rs.getString("NOMBRE"), rs.getString("DESCRIPCIÓN"), rs.getString("FECHA_CREACION"), rs.getInt("ID_USU_LIDER"))
        }
        ps?.close()
        conexion.desconectar()
        return equipo
    }

    override fun getAllEquipos(): List<Equipo> {
        conexion.conectar()
        val st = conexion.getStatement()
        val rs = st?.executeQuery(SQL_Equipo.SELECT_ALL)
        val equipos = mutableListOf<Equipo>()
        while (rs?.next() == true) {
            val equipo = Equipo(rs.getInt("ID_EQUIPO"), rs.getString("NOMBRE"), rs.getString("DESCRIPCION"), rs.getString("FECHA_CREACION"), rs.getInt("ID_USU_LIDER"))
            equipos.add(equipo)
        }
        st?.close()
        conexion.desconectar()
        return equipos
    }

    override fun insertEquipo(equipo: Equipo): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Equipo.INSERT)
        ps?.setInt(1, equipo.id_equipo)
        ps?.setString(2, equipo.nombre)
        ps?.setString(3, equipo.descripcion)
        ps?.setString(4, equipo.fecha_creacion)
        ps?.setInt(5, equipo.id_usu_lider)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateEquipo(equipo: Equipo): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Equipo.UPDATE)
        ps?.setString(1, equipo.nombre)
        ps?.setInt(2, equipo.id_equipo)
        ps?.setString(3, equipo.descripcion)
        ps?.setString(4, equipo.fecha_creacion)
        ps?.setInt(5, equipo.id_usu_lider)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteEquipo(id: Int): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Equipo.DELETE)
        ps?.setInt(1, id)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }
}