package controllers
import java.util.Scanner


fun main() {
    val scan = Scanner(System.`in`)
    val FILAS = 20
    val ASIENTOS = 15
    var sala = crearSalaOVaciarla(FILAS, ASIENTOS)
    var seguir = true
    while (seguir) {
    var resupuestaMenu = menu(scan)
    if (resupuestaMenu == 1){ sala = crearSalaOVaciarla(FILAS, ASIENTOS) }
    else if (resupuestaMenu == 2){ visualizarAsientosDisponibles(sala, FILAS) }
    else if (resupuestaMenu == 3){ sala = reservarAsientos(sala, scan) }
        else seguir = false
    }
}
/**
 * Funcion para imprimir el menu
 * @param scanner para poder pedir al usuario los numeros
 * @return retorna la opción que el usuario ha elegido ene le menú
 */
fun menu(scanner: Scanner): Int{
    println("""
        - LBRE - --> VOL DIR QUE EL SEIENT ESTA LLIURE
        - OCUP - --> VOL DIR QUE EL SEIENT ESTA OCUPAT
        
        TRIA ENTRE LES SEGUENTS OPCIONS ( PER SELECCIONAR-HO ESCRIU EL NUMERO DE LA SELECCIÓ )
        
        1 - BUIDAR LA SALA
        2 - VISUALITZAR SEIENTS DISPONIBLES
        3 - RESERVAR SEIENT 
        4 - SALIR(PUEDES PULSAR CUALQUIER OTRO NUMERO)
    """.trimIndent())

    val eleccion = scanner.nextInt()

    return  eleccion
}

/**
 * Función para poder crear o vaciar la sala, nos servira para las dos situaciones
 * @param filas la fila
 * @param asientos los asientos
 * @return devuelve la sala completamente vacia
 */
fun crearSalaOVaciarla(filas:Int, asientos:Int):MutableList<MutableList<String>> {

    var salaCine:MutableList<MutableList<String>> = MutableList(filas, {MutableList(asientos, {"LBRE"})})
    println("SALA VACIADA")
    return  salaCine
}

/**
 * Función para imprimir de forma grafica el estado de ocupación de la sala de cine
 * @param numeroFilas
 * @param salaCine La lista completa para poder imprimirla por pantalla
 */
fun visualizarAsientosDisponibles( salaCine:MutableList<MutableList<String>> ,numeroFilas:Int){

    for (x in 0 until  numeroFilas ){
       println( salaCine[x].joinToString())

    }

}

/**
 * Función para reservar un asiento, usando las coordenadas (fila(x) aisento(y)
 * @param salaCine es la matriz con la sala
 * @param scanner para poder recoger datos del usuario
 * @return devuelve la sala acutalizada
 */

fun reservarAsientos(salaCine: MutableList<MutableList<String>>, scanner: Scanner): MutableList<MutableList<String>>{
    println("INDICA'M LA FILA I LA BUTACA QUE VOLS RESERVAR\n")
    print("FILA: ")
    var fila = scanner.nextInt()-1
    print("BUTACA: ")
    var butaca = scanner.nextInt()-1

    if (salaCine[fila][butaca] == "LBRE") {
        salaCine[fila][butaca] = "OCUP"
        println("Fila reservada")
    }
    else println("Aquesta butaca ja esta ocupada")

    return salaCine


}
