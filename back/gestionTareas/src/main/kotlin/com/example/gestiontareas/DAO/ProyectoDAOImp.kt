package com.example.gestiontareas.DAO

import com.example.gestiontareas.BaseDatos.ConexionBD
import com.example.gestiontareas.BaseDatos.SQL_Proyecto
import com.example.gestiontareas.Negocio.Proyecto

class ProyectoDAOImp: ProyectoDAO
{
    private val conexion = ConexionBD()

    override fun getProyectoByID(id: Int): Proyecto? {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Proyecto.SELECT_BY_CODIGO)
        ps?.setInt(1, id)
        val rs = ps?.executeQuery()
        var proyecto: Proyecto? = null
        if (rs?.next() == true) {
            proyecto = Proyecto(rs.getInt("ID_PROYECTO"), rs.getString("NOMBRE"), rs.getString("DESCRIPCION"), rs.getString("FECHA_INICIO"), rs.getString("FECHA_FIN"), rs.getString("ID_EQUIPO"))
        }
        ps?.close()
        conexion.desconectar()
        return proyecto
    }

    override fun getAllProyecto(): List<Proyecto> {
        conexion.conectar()
        val st = conexion.getStatement()
        val rs = st?.executeQuery(SQL_Proyecto.SELECT_ALL)
        val proyectos = mutableListOf<Proyecto>()
        while (rs?.next() == true) {
            val proyecto = Proyecto(rs.getInt("ID_PROYECTO"), rs.getString("NOMBRE"), rs.getString("DESCRIPCION"), rs.getString("FECHA_INICIO"), rs.getString("FECHA_FIN"), rs.getString("ID_EQUIPO"))
            proyectos.add(proyecto)
        }
        st?.close()
        conexion.desconectar()
        return proyectos
    }

    override fun insertProyecto(proyecto: Proyecto): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Proyecto.INSERT)
        ps?.setInt(1, proyecto.id_proyecto)
        ps?.setString(2, proyecto.nombre)
        ps?.setString(3, proyecto.descripcion)
        ps?.setString(4, proyecto.fecha_inicio)
        ps?.setString(5, proyecto.fecha_fin)
        ps?.setString(6, proyecto.id_equipo)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateProyecto(proyecto: Proyecto): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Proyecto.UPDATE)
        ps?.setString(1, proyecto.nombre)
        ps?.setInt(2, proyecto.id_proyecto)
        ps?.setString(3, proyecto.descripcion)
        ps?.setString(4, proyecto.fecha_inicio)
        ps?.setString(5, proyecto.fecha_fin)
        ps?.setString(6, proyecto.id_equipo)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteProyecto(id: Int): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Proyecto.DELETE)
        ps?.setInt(1, id)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }
}