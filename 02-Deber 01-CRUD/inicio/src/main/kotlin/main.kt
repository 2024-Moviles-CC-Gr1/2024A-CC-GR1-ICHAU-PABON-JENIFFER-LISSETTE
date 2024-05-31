import java.time.LocalDate

fun main() {
    Hospital.leerDatosHospitales()
    Doctor.leerDatosDoctores()

    var exit = false

    while (!exit) {
        println("\n-----------------------------------------------------")
        println("\t\t\t\tBIENVENIDO AL SISTEMA")
        println("\t\t\t\t\t\tMENÚ")
        println("-----------------------------------------------------")
        println("---------------------Hospitales----------------------")
        println("1. Ver hospitales")
        println("2. Agregar hospital")
        println("3. Actualizar hospital")
        println("4. Eliminar hospital")
        println("----------------------Doctores-----------------------")
        println("5. Ver doctores por hospital")
        println("6. Agregar doctor")
        println("7. Actualizar doctor")
        println("8. Eliminar doctor")
        println("9. Salir")

        print("\nSeleccione una opción: ")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("\nLista de Hospitales:")
                Hospital.listarHospitales()
            }
            2 -> {
                println("\nAgregar hospital")
                print("Nombre: ")
                val nombre = readLine() ?: ""
                print("Dirección: ")
                val direccion = readLine() ?: ""
                print("Capacidad: ")
                val capacidad = readLine()?.toIntOrNull() ?: 0
                print("Fecha de fundación (AAAA-MM-DD): ")
                val fechaFundacion = LocalDate.parse(readLine())
                val id = (Hospital.hospitales.maxOfOrNull { it.id } ?: 0) + 1
                Hospital.crearHospital(id, nombre, direccion, capacidad, fechaFundacion)
                Hospital.escribirDatosHospitales()
                println("¡Información de Hospital creada con éxito!")
            }
            3 -> {
                println("\nActualizar hospital")
                print("ID del hospital a actualizar: ")
                val hospitalId = readLine()?.toIntOrNull() ?: 0
                val hospitalToUpdate = Hospital.hospitales.find { it.id == hospitalId }
                if (hospitalToUpdate != null) {
                    print("Nuevo nombre (presione Enter para no realizar cambios): ")
                    val nombre = readLine()
                    print("Nueva dirección (presione Enter para no realizar cambios): ")
                    val direccion = readLine()
                    print("Nueva capacidad (presione Enter para no realizar cambios): ")
                    val capacidadStr = readLine()
                    val capacidad = capacidadStr?.toIntOrNull()
                    print("Nueva fecha de fundación (AAAA-MM-DD, presione Enter para no realizar cambios): ")
                    val fechaFundacionStr = readLine()
                    val fechaFundacion = if (fechaFundacionStr.isNullOrBlank()) null else LocalDate.parse(fechaFundacionStr)

                    Hospital.actualizarHospital(hospitalId, nombre, direccion, capacidad, fechaFundacion)
                    Hospital.escribirDatosHospitales()
                    println("¡Información de Hospital actualizada con éxito!")
                } else {
                    println("Hospital no encontrado.")
                }
            }
            4 -> {
                println("\nEliminar hospital:")
                print("ID del hospital a eliminar: ")
                val hospitalId = readLine()?.toIntOrNull() ?: 0
                Hospital.borrarHospital(hospitalId)
                Hospital.escribirDatosHospitales()
                println("¡Información de Hospital eliminada con éxito!")
            }
            5 -> {
                println("\nVer doctores por hospital")
                print("Ingrese el ID del hospital: ")
                val hospitalId = readLine()?.toIntOrNull() ?: 0
                val hospital = Hospital.hospitales.find { it.id == hospitalId }
                if (hospital != null) {
                    Doctor.listarDoctoresHospital(hospitalId)
                } else {
                    println("No existe información de hospital con ese ID.")
                }
            }
            6 -> {
                println("\nAgregar doctor")
                print("Cédula: ")
                val cedula = readLine() ?: ""
                print("Nombre: ")
                val nombre = readLine() ?: ""
                print("Especialidad: ")
                val especialidad = readLine() ?: ""
                print("Edad: ")
                val edad = readLine()?.toIntOrNull() ?: 0
                print("Salario: ")
                val salario = readLine()?.toDoubleOrNull() ?: 0.0
                print("ID del hospital: ")
                val idHospital = readLine()?.toIntOrNull() ?: 0
                val hospitalExistente = Hospital.hospitales.any { it.id == idHospital }

                if (hospitalExistente) {
                    Doctor.crearDoctor(cedula, nombre, especialidad, edad, salario, idHospital)
                    Doctor.escribirDatosDoctores()
                    println("Doctor creado correctamente")
                } else {
                    println("No se pudo crear el doctor. No existe información de hospital con ese ID.")
                }
            }
            7 -> {
                println("\nActualizar doctor:")
                print("Cédula del doctor a actualizar: ")
                val cedula = readLine() ?: ""
                val doctorToUpdate = Doctor.doctores.find { it.cedula == cedula }
                if (doctorToUpdate != null) {
                    print("Nuevo nombre (presione Enter para no realizar cambios): ")
                    val nombre = readLine()
                    print("Nueva especialidad (presione Enter para no realizar cambios): ")
                    val especialidad = readLine()
                    print("Nueva edad (presione Enter para no realizar cambios): ")
                    val edadStr = readLine()
                    val edad = edadStr?.toIntOrNull()
                    print("Nuevo salario (presione Enter para no realizar cambios): ")
                    val salarioStr = readLine()
                    val salario = salarioStr?.toDoubleOrNull()
                    print("Nuevo ID del hospital (presione Enter para no realizar cambios): ")
                    val idHospitalStr = readLine()
                    val idHospital = idHospitalStr?.toIntOrNull()

                    Doctor.actualizarDoctor(cedula, nombre, especialidad, edad, salario, idHospital)
                    Doctor.escribirDatosDoctores()
                    println("¡Información de Doctor actualizada con éxito!")
                } else {
                    println("Doctor no encontrado.")
                }
            }
            8 -> {
                println("\nEliminar doctor:")
                print("Cédula del doctor a eliminar: ")
                val cedula = readLine() ?: ""
                Doctor.borrarDoctor(cedula)
                Doctor.escribirDatosDoctores()
                println("¡Información de Doctor eliminada con éxito!")
            }
            9 -> {
                println("¡Gracias por usar el sistema! ¡Hasta luego!")
                exit = true
            }
            else -> println("Opción no válida.")
        }
    }
}
