package com.example.a2024accgr1jlip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.google.android.material.snackbar.Snackbar

class ACicloVida : AppCompatActivity() {
    var textoGlobal = ""
    fun mostrarSnackbar(texto:String){
        textoGlobal += texto
        val snack = Snackbar.make(
            findViewById(R.id.cl_ciclo_vida),
            textoGlobal,
            Snackbar.LENGTH_INDEFINITE
        )
        snack.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aciclo_vida)
        mostrarSnackbar("OnCreate")
    }

    override fun onStart() {
        super.onStart()
        mostrarSnackbar("OnStart")
    }

    override fun onResume() {
        super.onResume()
        mostrarSnackbar("OnResume")
    }

    override fun onPause() {
        super.onPause()
        mostrarSnackbar("OnPause")
    }

    override fun onStop() {
        super.onStop()
        mostrarSnackbar("OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        mostrarSnackbar("On Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        mostrarSnackbar("OnDestroy")
    }
    override fun onSaveInstanceState(outState: Bundle){
        outState.run{
            //GUARDAR LAS PRIMITIVAS
            putString("variableTextoGuardado",textoGlobal)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle){
        super.onRestoreInstanceState(savedInstanceState)
        //Recuperar las variables
        val textoRecuperadoDeVariable: String? = savedInstanceState.getString("variableTextoGuardado")
        if (textoRecuperadoDeVariable != null){
            mostrarSnackbar(textoRecuperadoDeVariable)
            textoGlobal = textoRecuperadoDeVariable
        }
    }

}