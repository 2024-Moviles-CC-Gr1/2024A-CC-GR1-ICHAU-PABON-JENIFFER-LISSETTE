import java.io.File
import java.time.LocalDate

class Hospital(
    val id: Int,
    var nombre: String,
    var direccion: String,
    var capacidad: Int,
    var fechaFundacion: LocalDate
) {
    override fun toString(): String {
        return "ID: $id, Nombre: $nombre, Dirección: $direccion, Capacidad: $capacidad, Fecha de Fundación: $fechaFundacion"
    }

    companion object {
        val hospitales = arrayListOf<Hospital>()

        fun listarHospitales() {
            hospitales.forEach { println(it) }
        }

        fun crearHospital(
            id: Int,
            nombre: String,
            direccion: String,
            capacidad: Int,
            fechaFundacion: LocalDate
        ) {
            hospitales.add(Hospital(id, nombre, direccion, capacidad, fechaFundacion))
        }

        fun borrarHospital(id: Int) {
            val hospital = hospitales.firstOrNull { it.id == id }
            if (hospital != null) {
                hospitales.remove(hospital)
            }
        }

        fun actualizarHospital(
            id: Int,
            nombre: String?,
            direccion: String?,
            capacidad: Int?,
            fechaFundacion: LocalDate?
        ) {
            val hospital = hospitales.firstOrNull { it.id == id }
            if (hospital != null) {
                if (!nombre.isNullOrBlank()) hospital.nombre = nombre
                if (!direccion.isNullOrBlank()) hospital.direccion = direccion
                if (capacidad != null) hospital.capacidad = capacidad
                if (fechaFundacion != null) hospital.fechaFundacion = fechaFundacion
            }
        }

        fun leerDatosHospitales() {
            val pathName = "hospitales.txt"
            val miArchivo = File(pathName)
            if (miArchivo.exists()) {
                val lineasLista = mutableListOf<String>()
                miArchivo.useLines { lines -> lines.forEach { lineasLista.add(it) } }
                lineasLista.forEach {
                    val registro = it.split(',').toTypedArray()
                    val id = registro[0].toInt()
                    val nombre = registro[1]
                    val direccion = registro[2]
                    val capacidad = registro[3].toInt()
                    val fechaFundacion = LocalDate.parse(registro[4])
                    hospitales.add(Hospital(id, nombre, direccion, capacidad, fechaFundacion))
                }
                println("${hospitales.size} hospitales cargados")
            } else {
                println("No se encontró el archivo de hospitales.")
            }
        }

        fun escribirDatosHospitales() {
            val ruta = "hospitales.txt"
            val archivo = File(ruta)
            archivo.printWriter().use { out ->
                hospitales.forEach { out.println("${it.id},${it.nombre},${it.direccion},${it.capacidad},${it.fechaFundacion}") }
            }
        }
    }
}
