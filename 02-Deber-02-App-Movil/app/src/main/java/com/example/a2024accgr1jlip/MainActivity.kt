package com.example.a2024accgr1jlip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    fun mostrarSnackbar(texto:String){
        val snack = Snackbar.make(
            findViewById(R.id.layout_main),
            texto,
            Snackbar.LENGTH_INDEFINITE
        )
        snack.show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializar Base de datos Hospital
        EBaseDeDatos.tablaHospital = ESqliteHelperHospital(
            this
        )
        val botonSqliteHos = findViewById<Button>(R.id.btn_sqlite_hospital)
        botonSqliteHos.setOnClickListener{
            irActividad(ECrudHospital::class.java)
        }
        //Inicializar Base de datos Doctor
        EBaseDeDatos.tablaDoctor = ESqliteHelperDoctor(
            this
        )
        val botonSqliteDoc = findViewById<Button>(R.id.btn_sqlite_doctor)
        botonSqliteDoc.setOnClickListener{
            irActividad(ECrudDoctor::class.java)
        }

    }
    fun irActividad(
        clase: Class<*>
    ){
        val intent = Intent(this, clase)
        startActivity(intent)
    }
}