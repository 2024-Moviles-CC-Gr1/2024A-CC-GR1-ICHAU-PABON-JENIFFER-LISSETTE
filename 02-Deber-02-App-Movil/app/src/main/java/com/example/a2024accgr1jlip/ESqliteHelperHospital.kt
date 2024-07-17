package com.example.a2024accgr1jlip

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.time.LocalDate

class ESqliteHelperHospital(contexto: Context?) : SQLiteOpenHelper(
    contexto, "hospitalesDB", null, 1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val scriptSQLCrearTablaHospital =
            """
                CREATE TABLE HOSPITAL(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre VARCHAR(50),
                    direccion VARCHAR(50),
                    capacidad INTEGER,
                    fechaFundacion TEXT
                )
            """.trimIndent()
        db?.execSQL(scriptSQLCrearTablaHospital)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}

    fun crearHospital(nombre: String, direccion: String, capacidad: Int, fechaFundacion: String): Boolean {
        val basedatosEscritura = writableDatabase
        val valoresAGuardar = ContentValues()
        valoresAGuardar.put("nombre", nombre)
        valoresAGuardar.put("direccion", direccion)
        valoresAGuardar.put("capacidad", capacidad)
        valoresAGuardar.put("fechaFundacion", fechaFundacion)
        val resultadoGuardar = basedatosEscritura.insert("HOSPITAL", null, valoresAGuardar)
        basedatosEscritura.close()
        return resultadoGuardar.toInt() != -1
    }

    fun eliminarHospital(id: Int): Boolean {
        val conexionEscritura = writableDatabase
        val parametrosConsultaDelete = arrayOf(id.toString())
        val resultadoEliminacion = conexionEscritura.delete("HOSPITAL", "id=?", parametrosConsultaDelete)
        conexionEscritura.close()
        return resultadoEliminacion.toInt() != -1
    }

    fun actualizarHospital(id: Int, nombre: String, direccion: String, capacidad: Int, fechaFundacion: String): Boolean {
        val conexionEscritura = writableDatabase
        val valoresAActualizar = ContentValues()
        valoresAActualizar.put("nombre", nombre)
        valoresAActualizar.put("direccion", direccion)
        valoresAActualizar.put("capacidad", capacidad)
        valoresAActualizar.put("fechaFundacion", fechaFundacion)
        val parametrosConsultaActualizar = arrayOf(id.toString())
        val resultadoActualizacion = conexionEscritura.update("HOSPITAL", valoresAActualizar, "id=?", parametrosConsultaActualizar)
        conexionEscritura.close()
        return resultadoActualizacion.toInt() != -1
    }

    fun consultarHospitalPorID(id: Int): BHospital? {
        val baseDatosLectura = readableDatabase
        val scriptConsultaLectura = "SELECT * FROM HOSPITAL WHERE id = ?"
        val arregloParametrosConsultaLectura = arrayOf(id.toString())
        val resultadoConsultaLectura = baseDatosLectura.rawQuery(scriptConsultaLectura, arregloParametrosConsultaLectura)
        val existeAlMenosUno = resultadoConsultaLectura.moveToFirst()
        val hospital: BHospital? = if (existeAlMenosUno) {
            BHospital(
                resultadoConsultaLectura.getInt(0),
                resultadoConsultaLectura.getString(1),
                resultadoConsultaLectura.getString(2),
                resultadoConsultaLectura.getInt(3),
                resultadoConsultaLectura.getString(4)
            )
        } else {
            null
        }
        resultadoConsultaLectura.close()
        baseDatosLectura.close()
        return hospital
    }
}