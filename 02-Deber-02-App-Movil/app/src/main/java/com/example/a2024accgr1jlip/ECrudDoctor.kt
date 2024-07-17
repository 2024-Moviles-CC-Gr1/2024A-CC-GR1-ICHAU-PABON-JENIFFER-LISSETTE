package com.example.a2024accgr1jlip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class ECrudDoctor : AppCompatActivity() {
    fun mostrarSnackbar(texto: String) {
        val snack = Snackbar.make(
            findViewById(R.id.cl_sqlite_doctor),
            texto,
            Snackbar.LENGTH_INDEFINITE
        )
        snack.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecrud_doctor)

        val botonBuscarBDD = findViewById<Button>(R.id.btn_buscar_bdd_doctor)
        botonBuscarBDD.setOnClickListener {
            val cedula = findViewById<EditText>(R.id.input_cedula)
            val nombre = findViewById<EditText>(R.id.input_nombre_doctor)
            val especialidad = findViewById<EditText>(R.id.input_especialidad)
            val edad = findViewById<EditText>(R.id.input_edad_doctor)
            val salario = findViewById<EditText>(R.id.input_salario_doctor)
            val idHospital = findViewById<EditText>(R.id.input_id_hospital)
            val doctor = EBaseDeDatos.tablaDoctor!!.consultarDoctorPorCedula(cedula.text.toString())
            if (doctor == null) {
                mostrarSnackbar("Doctor no encontrado")
                cedula.setText("")
                nombre.setText("")
                especialidad.setText("")
                edad.setText("")
                salario.setText("")
                idHospital.setText("")
            } else {
                cedula.setText(doctor.cedula)
                nombre.setText(doctor.nombre)
                especialidad.setText(doctor.especialidad)
                edad.setText(doctor.edad.toString())
                salario.setText(doctor.salario.toString())
                idHospital.setText(doctor.idHospital.toString())
                mostrarSnackbar("Doctor encontrado")
            }
        }

        val botonCrearBDD = findViewById<Button>(R.id.btn_crear_bdd_doctor)
        botonCrearBDD.setOnClickListener {
            val cedula = findViewById<EditText>(R.id.input_cedula)
            val nombre = findViewById<EditText>(R.id.input_nombre_doctor)
            val especialidad = findViewById<EditText>(R.id.input_especialidad)
            val edad = findViewById<EditText>(R.id.input_edad_doctor)
            val salario = findViewById<EditText>(R.id.input_salario_doctor)
            val idHospital = findViewById<EditText>(R.id.input_id_hospital)
            val respuesta = EBaseDeDatos.tablaDoctor!!.crearDoctor(
                cedula.text.toString(),
                nombre.text.toString(),
                especialidad.text.toString(),
                edad.text.toString().toInt(),
                salario.text.toString().toDouble(),
                idHospital.text.toString().toInt()
            )
            if (respuesta) mostrarSnackbar("Doctor creado")
        }

        val botonActualizarBDD = findViewById<Button>(R.id.btn_actualizar_bdd_doctor)
        botonActualizarBDD.setOnClickListener {
            val cedula = findViewById<EditText>(R.id.input_cedula)
            val nombre = findViewById<EditText>(R.id.input_nombre_doctor)
            val especialidad = findViewById<EditText>(R.id.input_especialidad)
            val edad = findViewById<EditText>(R.id.input_edad_doctor)
            val salario = findViewById<EditText>(R.id.input_salario_doctor)
            val idHospital = findViewById<EditText>(R.id.input_id_hospital)
            val respuesta = EBaseDeDatos.tablaDoctor!!.actualizarDoctor(
                cedula.text.toString(),
                nombre.text.toString(),
                especialidad.text.toString(),
                edad.text.toString().toInt(),
                salario.text.toString().toDouble(),
                idHospital.text.toString().toInt()
            )
            if (respuesta) mostrarSnackbar("Doctor actualizado")
        }

        val botonEliminarBDD = findViewById<Button>(R.id.btn_eliminar_bdd_doctor)
        botonEliminarBDD.setOnClickListener {
            val cedula = findViewById<EditText>(R.id.input_cedula)
            val respuesta = EBaseDeDatos.tablaDoctor!!.eliminarDoctor(cedula.text.toString())
            if (respuesta) mostrarSnackbar("Doctor eliminado")
        }
    }
}