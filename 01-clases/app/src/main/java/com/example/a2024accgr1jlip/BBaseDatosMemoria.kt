package com.example.a2024accgr1jlip

class BBaseDatosMemoria {
    companion object{
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init{
            arregloBEntrenador.add(
                BEntrenador(1,"Jeniffer","jeniffer@j.com")
            )
            arregloBEntrenador.add(
                BEntrenador(2,"Erick","erick@e.com")
            )
            arregloBEntrenador.add(
                BEntrenador(3,"Cecilia","cecilia@c.com")
            )
        }
    }
}