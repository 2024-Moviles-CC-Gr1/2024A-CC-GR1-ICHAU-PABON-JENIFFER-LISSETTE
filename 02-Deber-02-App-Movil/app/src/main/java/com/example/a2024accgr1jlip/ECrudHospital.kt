package com.example.a2024accgr1jlip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import java.time.LocalDate

class ECrudHospital : AppCompatActivity() {
    fun mostrarSnackbar(texto: String) {
        val snack = Snackbar.make(
            findViewById(R.id.cl_sqlite_hospital),
            texto,
            Snackbar.LENGTH_INDEFINITE
        )
        snack.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecrud_hospital)

        val botonBuscarBDD = findViewById<Button>(R.id.btn_buscar_bdd_hospital)
        botonBuscarBDD.setOnClickListener {
            val id = findViewById<EditText>(R.id.input_id)
            val nombre = findViewById<EditText>(R.id.input_nombre_hospital)
            val direccion = findViewById<EditText>(R.id.input_direccion_hospital)
            val capacidad = findViewById<EditText>(R.id.input_capacidad_hospital)
            val fechaFundacion = findViewById<EditText>(R.id.input_fecha_fundacion)
            val hospital = EBaseDeDatos.tablaHospital!!.consultarHospitalPorID(id.text.toString().toInt())
            if (hospital == null) {
                mostrarSnackbar("Hospital no encontrado")
                id.setText("")
                nombre.setText("")
                direccion.setText("")
                capacidad.setText("")
                fechaFundacion.setText("")
            } else {
                id.setText(hospital.id.toString())
                nombre.setText(hospital.nombre)
                direccion.setText(hospital.direccion)
                capacidad.setText(hospital.capacidad.toString())
                fechaFundacion.setText(hospital.fechaFundacion)
                mostrarSnackbar("Hospital encontrado")
            }
        }

        val botonCrearBDD = findViewById<Button>(R.id.btn_crear_bdd_hospital)
        botonCrearBDD.setOnClickListener {
            val nombre = findViewById<EditText>(R.id.input_nombre_hospital)
            val direccion = findViewById<EditText>(R.id.input_direccion_hospital)
            val capacidad = findViewById<EditText>(R.id.input_capacidad_hospital)
            val fechaFundacion = findViewById<EditText>(R.id.input_fecha_fundacion)
            val respuesta = EBaseDeDatos.tablaHospital!!.crearHospital(
                nombre.text.toString(),
                direccion.text.toString(),
                capacidad.text.toString().toInt(),
                fechaFundacion.text.toString()
            )
            if (respuesta) mostrarSnackbar("Hospital creado")
        }

        val botonActualizarBDD = findViewById<Button>(R.id.btn_actualizar_bdd_hospital)
        botonActualizarBDD.setOnClickListener {
            val id = findViewById<EditText>(R.id.input_id)
            val nombre = findViewById<EditText>(R.id.input_nombre_hospital)
            val direccion = findViewById<EditText>(R.id.input_direccion_hospital)
            val capacidad = findViewById<EditText>(R.id.input_capacidad_hospital)
            val fechaFundacion = findViewById<EditText>(R.id.input_fecha_fundacion)
            val respuesta = EBaseDeDatos.tablaHospital!!.actualizarHospital(
                id.text.toString().toInt(),
                nombre.text.toString(),
                direccion.text.toString(),
                capacidad.text.toString().toInt(),
                fechaFundacion.text.toString()
            )
            if (respuesta) mostrarSnackbar("Hospital actualizado")
        }

        val botonEliminarBDD = findViewById<Button>(R.id.btn_eliminar_bdd_hospital)
        botonEliminarBDD.setOnClickListener {
            val id = findViewById<EditText>(R.id.input_id)
            val respuesta = EBaseDeDatos.tablaHospital!!.eliminarHospital(id.text.toString().toInt())
            if (respuesta) mostrarSnackbar("Hospital eliminado")
        }

        val BotonGMaps = findViewById<Button>(R.id.btn_google_maps)
        BotonGMaps.setOnClickListener {
            irActividad(GGoogleMapsActivity::class.java)
        }
    }
    fun irActividad(
        clase: Class<*>
    ){
        val intent = Intent(this, clase)
        startActivity(intent)
    }
}