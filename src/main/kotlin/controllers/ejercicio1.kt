package org.example.controllers

import java.util.*

data class Punt (
    var x:Float,
    var y:Float,
)
 fun main() {
        val scan = abrirScanner()
        val x = PedirNumero("Introduce un valor para x:", scan)
        val y = PedirNumero("Introduce un valor para y:", scan)
        val p = Punt(x,y)
        mostraPunt(p)
        val a = PedirNumero("Introduce un valor para x:", scan)
        val b = PedirNumero("Introduce un valor para y:", scan)
        translacio(p, Punt(a,b))
        mostraPunt(p)
        val factor = PedirNumero("Introduce un valor para x:", scan)
        escalat(p, factor)
        mostraPunt(p)
        val x2 = PedirNumero("Introduce un valor para x:", scan)
        val y2 = PedirNumero("Introduce un valor para y:", scan)
        println(iguals(p, Punt(x2,y2)))
        cerrarScanner(scan)
    }

/**
 * Procedimiento que imprime cada resultado de las funciones
 *
 * @param p el resultado de la función
 * @return no devuelve nada
 */

fun mostraPunt(p: Punt): Unit {
    println("(${String.format("%.6f", p.x)}, ${String.format("%.6f", p.y)})")
}

/**
 * Procedimiento que desplaza el primer punto según el segundo punto introducido (x+a, y+b)
 * @param p punto inicial introducido
 * @param desp segundo punto que será el desplazamiento
 * @return no devuelve nada
 */
fun translacio(p: Punt, desp: Punt): Unit {
    p.x = p.x + desp.x
    p.y = p.y + desp.y
}

/**
 * Procedimiento que escala el punto según un factor (a*x, a*y)
 * @param p punto incial introducido
 * @param factor factor en el que multiplicaremos el primer punto
 * @return no devuelve nada
 */
fun escalat(p: Punt, factor: Float): Unit {
    p.x = p.x * factor
    p.y = p.y * factor
}

/**
 * Función que comparará el punto incial con otro introducido
 * @param p1 punto incial
 * @param p2 punto segundo
 * @return devuelve si son iguales
 */
fun iguals(p1: Punt, p2: Punt): Boolean {
    var resultat:Boolean
    if (p1 == p2) resultat = true
    else resultat = false
    return resultat
}

/**
 * Función para pedir un número
 * @param msg mensaje para imprimir
 * @param scan scanner
 * @return devuelve el float introducido
 */

fun PedirNumero(msg:String, scan:Scanner) : Float {
    var numero : Float
    print(msg)
    numero = scan.nextFloat()
    return numero
}

/**
 * Función para abrir el scanner
 * @return scanner
 */

fun abrirScanner() : Scanner {
    var scan : Scanner = Scanner(System.`in`)
    return scan
}

/**
 * funcion para cerrar el scanner al final de la ejecución del programa
 */
fun cerrarScanner(scan:Scanner) {
    scan.close()
}