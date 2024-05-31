import java.io.File

class Doctor(
    val cedula: String,
    var nombre: String,
    var especialidad: String,
    var edad: Int,
    var salario: Double,
    var idHospital: Int
) {
    override fun toString(): String {
        return "Cédula: $cedula, Nombre: $nombre, Especialidad: $especialidad, Edad: $edad, Salario: $salario, ID Hospital: $idHospital"
    }

    companion object {
        val doctores = arrayListOf<Doctor>()

        fun listarDoctoresHospital(idHospital: Int) {
            val listaDoctores = doctores.filter { it.idHospital == idHospital }
            listaDoctores.forEach { println(it) }
        }

        fun crearDoctor(
            cedula: String,
            nombre: String,
            especialidad: String,
            edad: Int,
            salario: Double,
            idHospital: Int
        ) {
            doctores.add(Doctor(cedula, nombre, especialidad, edad, salario, idHospital))
        }

        fun borrarDoctor(cedula: String) {
            val doctor = doctores.firstOrNull { it.cedula == cedula }
            if (doctor != null) {
                doctores.remove(doctor)
            }
        }

        fun actualizarDoctor(
            cedula: String,
            nombre: String?,
            especialidad: String?,
            edad: Int?,
            salario: Double?,
            idHospital: Int?
        ) {
            val doctor = doctores.firstOrNull { it.cedula == cedula }
            if (doctor != null) {
                if (!nombre.isNullOrBlank()) doctor.nombre = nombre
                if (!especialidad.isNullOrBlank()) doctor.especialidad = especialidad
                if (edad != null) doctor.edad = edad
                if (salario != null) doctor.salario = salario
                if (idHospital != null) doctor.idHospital = idHospital
            }
        }

        fun leerDatosDoctores() {
            val pathName = "doctores.txt"
            val miArchivo = File(pathName)
            if (miArchivo.exists()) {
                val lineasLista = mutableListOf<String>()
                miArchivo.useLines { lines -> lines.forEach { lineasLista.add(it) } }
                lineasLista.forEach {
                    val registro = it.split(',').toTypedArray()
                    val cedula = registro[0]
                    val nombre = registro[1]
                    val especialidad = registro[2]
                    val edad = registro[3].toInt()
                    val salario = registro[4].toDouble()
                    val idHospital = registro[5].toInt()
                    doctores.add(Doctor(cedula, nombre, especialidad, edad, salario, idHospital))
                }
                println("${doctores.size} doctores cargados")
            } else {
                println("No se encontró el archivo de doctores.")
            }
        }

        fun escribirDatosDoctores() {
            val ruta = "doctores.txt"
            val archivo = File(ruta)
            archivo.printWriter().use { out ->
                doctores.forEach { out.println("${it.cedula},${it.nombre},${it.especialidad},${it.edad},${it.salario},${it.idHospital}") }
            }
        }
    }
}
