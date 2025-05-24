package com.example.gestiontareas.DAO

import com.example.gestiontareas.BaseDatos.ConexionBD
import com.example.gestiontareas.BaseDatos.SQL_Tarea
import com.example.gestiontareas.Negocio.Tarea

class TareaDAOImp: TareaDAO
{
    private val conexion = ConexionBD()

    override fun getTareaByID(id: Int): Tarea? {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Tarea.SELECT_BY_CODIGO)
        ps?.setInt(1, id)
        val rs = ps?.executeQuery()
        var tarea: Tarea? = null
        if (rs?.next() == true) {
            tarea = Tarea(rs.getInt("ID_TAREA"), rs.getString("TITULO"), rs.getString("DESCRIPCION"), rs.getString("FECHA_CREACION"), rs.getString("FECHA_VENCIMIENTO"), rs.getInt("ID_USU_CREADOR"), rs.getInt("ID_USU_ASIGNADO"), rs.getInt("ID_PROYECTO"))
        }
        ps?.close()
        conexion.desconectar()
        return tarea
    }

    override fun getAllTarea(): List<Tarea> {
        conexion.conectar()
        val st = conexion.getStatement()
        val rs = st?.executeQuery(SQL_Tarea.SELECT_ALL)
        val tareas = mutableListOf<Tarea>()
        while (rs?.next() == true) {
            val tarea = Tarea(rs.getInt("ID_TAREA"), rs.getString("TITULO"), rs.getString("DESCRIPCION"), rs.getString("FECHA_CREACION"), rs.getString("FECHA_VENCIMIENTO"), rs.getInt("ID_USU_CREADOR"), rs.getInt("ID_USU_ASIGNADO"), rs.getInt("ID_PROYECTO"))
            tareas.add(tarea)
        }
        st?.close()
        conexion.desconectar()
        return tareas
    }

    override fun insertTarea(tarea: Tarea): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Tarea.INSERT)
        ps?.setInt(1, tarea.id_tarea)
        ps?.setString(2, tarea.titulo)
        ps?.setString(3, tarea.descripcion)
        ps?.setString(4, tarea.fecha_creacion)
        ps?.setString(5, tarea.fecha_vencimiento)
        ps?.setInt(6, tarea.id_usu_creador)
        ps?.setInt(7, tarea.id_usu_asignado)
        ps?.setInt(8, tarea.id_proyecto)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateTarea(tarea: Tarea): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Tarea.UPDATE)
        ps?.setString(1, tarea.titulo)
        ps?.setInt(2, tarea.id_tarea)
        ps?.setString(3, tarea.descripcion)
        ps?.setString(4, tarea.fecha_creacion)
        ps?.setString(5, tarea.fecha_vencimiento)
        ps?.setInt(6, tarea.id_usu_creador)
        ps?.setInt(7, tarea.id_usu_asignado)
        ps?.setInt(8, tarea.id_proyecto)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteTarea(id: Int): Boolean {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Tarea.DELETE)
        ps?.setInt(1, id)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }
}