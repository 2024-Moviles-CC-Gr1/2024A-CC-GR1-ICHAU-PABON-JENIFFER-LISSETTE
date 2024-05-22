import java.awt.datatransfer.StringSelection
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.ArrayList

fun main() {
    println("Hola mundo")
    // Inmutables (NO se Reasignan "=")
    val inmutable: String = "Jeniffer";
    // val inmutable: String = "Lissette"; Error

    // MUTABLES
    var mutable: String = "Lissette"
    mutable = "Jeniffer" //OK
    //VAL > VAR
    //Duck Typing
    val ejemploVariable = "Clase 3"
    val edadEjemplo: Int= 16
    ejemploVariable.trim()
    // ejemploVariable = edadEjemplo //Error!

    //Variables Primitivas
    val nombreProfesor: String = "Adrian Eguez"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'C'
    val mayorEdad: Boolean = true

    //Clases en Java
    val fechaNacimiento: Date = Date()

    //When (Switch)
    val estadoCivilWhen = "C"
    when (estadoCivilWhen){
         ("C") ->{
             println("Casado")
        }
        "S" -> {
            println("Soltero")
        }
        else -> {
            println("No sabemos")
        }
    }

    val esSoltero = (estadoCivilWhen == "S")
    val coqueteo = if (esSoltero) "Si" else "No"

    //Named parameters
    //calcularSueldo(sueldo, tasa, bonoEspecial)
    calcularSueldo(10.00, bonoEspecial = 20.00)
    calcularSueldo(bonoEspecial = 20.00, sueldo = 10.00, tasa = 14.00)

    val sumaUno = Suma(1,1)
    val sumaDos = Suma(null,1)
    val sumaTres = Suma(1, null)
    val sumaCuatro = Suma (null, null)
    sumaUno.sumar()
    sumaDos.sumar()
    sumaTres.sumar()
    sumaCuatro.sumar()

    println(Suma.pi)
    println(Suma.elevarAlCuadrado(2))
    println(Suma.historialSuma)


    //Arreglos
    //Estatico
    val arregloEstatico: Array<Int> = arrayOf<Int>(1,2,3)
    println(arregloEstatico)

    //Dinamico
    val arregloDinamico: ArrayList<Int> = arrayListOf<Int>(1,2,3,4,5,6,7,8,9)
    println(arregloDinamico)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)

    //FOR EACH => Unit
    //Iterar un arreglo
    val respuestaForEach: Unit = arregloDinamico
        .forEach{valorActual: Int ->
            println("Valor actual: ${valorActual}");
        }
    //*it (en ingles "eso") significa el elemento iterado
    arregloDinamico.forEach{ println("Valor Actual (it): ${it}") }

    //Operador map
    val respuestaMap: List<Double> = arregloDinamico
        .map{valorActual: Int ->
            return@map valorActual.toDouble() + 100
        }
    println(respuestaMap)
    val respuestaMapDos = arregloDinamico.map { it + 15 }
    println(respuestaMapDos)

    //Operador Filter
    val respuestaFilter: List<Int> = arregloDinamico
        .filter { valorActual: Int ->
            val mayoresACinco: Boolean = valorActual > 5
            return@filter mayoresACinco
        }
    val respuestaFilterDos = arregloDinamico.filter { it <= 5 }
    println(respuestaFilter)
    println(respuestaFilterDos)

    //Operador any (OR)
    val respuestaAny: Boolean = arregloDinamico
        .any{ valorActual: Int ->
            return@any (valorActual > 5)
        }
    println(respuestaAny)
    //Operador all (AND)
    val respuestaAll: Boolean = arregloDinamico
        .all{valorActual: Int ->
            return@all (valorActual > 5)
        }
    println(respuestaAll)

    //Operador reduce
    val respuestaReduce: Int = arregloDinamico
        .reduce{ acumulado: Int, valorActual: Int ->
            return@reduce (acumulado+valorActual)
        }
    println(respuestaReduce)
}//termina main


fun imprimirNombre(nombre:String): Unit{
    println("Nombre: $(nombre)") //Template Strings
}

fun calcularSueldo(
    sueldo: Double, //Requerido
    tasa: Double = 12.00, //Opcional (defecto)
    bonoEspecial: Double? = null //Opcional (nullable)
    //Variable -> "?" es nullable (osea que puede en algun momento ser null)
):Double{
    //Int -> Int? (nullable)
    //String -> String? (nullable)
    //Date -> Date? (nullable)
    if(bonoEspecial == null){
        return sueldo * (100/tasa)
    } else {
         return sueldo * (100/tasa) * bonoEspecial
    }
}

abstract class NumerosJava{
    protected val numeroUno:Int
    private val numeroDos: Int
    constructor(
        uno:Int,
        dos:Int
    ){
        this.numeroUno = uno
        this.numeroDos = dos
        println("Inicializando")
    }
}

abstract class Numeros( //Constructor primario
    // Caso 1) Parametro normal
    // uno: Int, (parametro (sin modificador acceso))

    //Caso 2) Parametro o propiedad
    //private val uno: Int (propiedad "instancia uno")

    //Caso 3) Parametro o propiedad
    // var uno:Int (propiedad "instancia uno") (public)
    protected  val numeroUno: Int, //instancia numeroUno
    protected val numeroDos:Int, //instancia numeroDos
){
    init{
        println("Inicializando")
    }
}

class Suma(
    unoParametro:Int, //Parametro
    dosParametro:Int, //Parametro
): Numeros( //Clase padre, Numeros (extendiendo)
    unoParametro,
    dosParametro
){
    public val soyPublicoExplicito:String = "Explicito" //Publico
    val soyPublicoImplicito: String ="Implicito" //Publico (propiedades, metodos)
    init { //Bloque codigo constructor primario
        this.numeroUno
        this.numeroDos
        numeroUno //this es opcional (propiedades, metodos)
        numeroDos //this es opcional (propiedades, metodos)
        this.soyPublicoExplicito
        soyPublicoImplicito
    }

    //public fun sumar():Int{ (opcional "public")
    constructor( //Constructor secundario
        uno: Int?,
        dos: Int
    ):this(
        if(uno == null) 0 else uno,
        dos
    )

    constructor( //Constructor tercero
        uno: Int,
        dos: Int?
    ):this(
        uno,
        if(dos == null) 0 else dos,
    )

    constructor( //Constructor cuarto
        uno: Int?,
        dos: Int?
    ):this(
        if(uno == null) 0 else uno,
        if(dos == null) 0 else dos,
    )

    fun sumar():Int{
        val total= numeroUno + numeroDos
        //Suma.agregarHistorial(total) ("Suma" )
        agregarHistorial(total)
        return total
    }
    companion object{ //Comparte entre todas las instancias , similar al static
        //Funciones y variables
        val pi = 3.14
        fun elevarAlCuadrado(num:Int):Int{
            return num * num
        }
        val historialSuma = arrayListOf<Int>()
        fun agregarHistorial (valorTotalSuma:Int){
            historialSuma.add(valorTotalSuma)
        }
    }
}