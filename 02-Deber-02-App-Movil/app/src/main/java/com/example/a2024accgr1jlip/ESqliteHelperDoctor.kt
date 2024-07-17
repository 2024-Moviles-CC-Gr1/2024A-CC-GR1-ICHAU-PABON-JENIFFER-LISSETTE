package com.example.a2024accgr1jlip

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ESqliteHelperDoctor (contexto: Context?) : SQLiteOpenHelper(
    contexto, "doctoresDB", null, 1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val scriptSQLCrearTablaDoctor =
            """
                CREATE TABLE DOCTOR(
                    cedula TEXT PRIMARY KEY,
                    nombre VARCHAR(50),
                    especialidad VARCHAR(50),
                    edad INTEGER,
                    salario REAL,
                    idHospital INTEGER
                )
            """.trimIndent()
        db?.execSQL(scriptSQLCrearTablaDoctor)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) { }

    fun crearDoctor(cedula: String, nombre: String, especialidad: String, edad: Int, salario: Double, idHospital: Int): Boolean {
        val basedatosEscritura = writableDatabase
        val valoresAGuardar = ContentValues()
        valoresAGuardar.put("cedula", cedula)
        valoresAGuardar.put("nombre", nombre)
        valoresAGuardar.put("especialidad", especialidad)
        valoresAGuardar.put("edad", edad)
        valoresAGuardar.put("salario", salario)
        valoresAGuardar.put("idHospital", idHospital)
        val resultadoGuardar = basedatosEscritura.insert("DOCTOR", null, valoresAGuardar)
        basedatosEscritura.close()
        return resultadoGuardar.toInt() != -1
    }

    fun eliminarDoctor(cedula: String): Boolean {
        val conexionEscritura = writableDatabase
        val parametrosConsultaDelete = arrayOf(cedula)
        val resultadoEliminacion = conexionEscritura.delete("DOCTOR", "cedula=?", parametrosConsultaDelete)
        conexionEscritura.close()
        return resultadoEliminacion.toInt() != -1
    }

    fun actualizarDoctor(cedula: String, nombre: String, especialidad: String, edad: Int, salario: Double, idHospital: Int): Boolean {
        val conexionEscritura = writableDatabase
        val valoresAActualizar = ContentValues()
        valoresAActualizar.put("nombre", nombre)
        valoresAActualizar.put("especialidad", especialidad)
        valoresAActualizar.put("edad", edad)
        valoresAActualizar.put("salario", salario)
        valoresAActualizar.put("idHospital", idHospital)
        val parametrosConsultaActualizar = arrayOf(cedula)
        val resultadoActualizacion = conexionEscritura.update("DOCTOR", valoresAActualizar, "cedula=?", parametrosConsultaActualizar)
        conexionEscritura.close()
        return resultadoActualizacion.toInt() != -1
    }

    fun consultarDoctorPorCedula(cedula: String): BDoctor? {
        val baseDatosLectura = readableDatabase
        val scriptConsultaLectura = "SELECT * FROM DOCTOR WHERE cedula = ?"
        val arregloParametrosConsultaLectura = arrayOf(cedula)
        val resultadoConsultaLectura = baseDatosLectura.rawQuery(scriptConsultaLectura, arregloParametrosConsultaLectura)
        val existeAlMenosUno = resultadoConsultaLectura.moveToFirst()
        val doctor: BDoctor? = if (existeAlMenosUno) {
            BDoctor(
                resultadoConsultaLectura.getString(0),
                resultadoConsultaLectura.getString(1),
                resultadoConsultaLectura.getString(2),
                resultadoConsultaLectura.getInt(3),
                resultadoConsultaLectura.getDouble(4),
                resultadoConsultaLectura.getInt(5)
            )
        } else {
            null
        }
        resultadoConsultaLectura.close()
        baseDatosLectura.close()
        return doctor
    }
}