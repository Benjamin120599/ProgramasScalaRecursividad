
import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {

    var opcion = 0

    do {

      println("================== M E N U ==================")
      println("")
      println("1) Calcular Sumatoria de un número")
      println("2) Mostrar Divisores de un número")
      println("3) Calcular Factorial de un número")
      println("4) Mostrar los cocientes de una división")
      println("5) Calcular total de divisores entreros de un número")
      println("6) Convertir Decimal a Binario")
      println("7) Calcular el total de vocales en una cadena")
      println("8) Salir.")
      println("")
      println("------------------------------------------------")
      println("")
      println("Elige una opción: ")
      opcion = StdIn.readInt()

      if(opcion == 1) {

        println("================== Calcular Sumatoria ==================\n")
        println("Ingresa de que número deseas iniciar: ")
        var num1 = StdIn.readInt()
        println("Ingresa hasta que número deseas terminar: ")
        var num2 = StdIn.readInt()
        ej01Sumatoria(num1, num2, num1)

      } else if(opcion == 2) {

        println("================== Mostrar Divisores de un Número ==================\n")
        println("Ingresa un número: ")
        var num1 = StdIn.readInt()
        ej02Divisores(num1, 1)

      } else if(opcion == 3) {

        println("================== Calcular Factorial ==================\n")
        println("Ingresa un número: ")
        var num1 = StdIn.readInt()
        ej03Factorial(num1, 1, 1)

      } else if(opcion == 4) {

        println("================== Calcular Cocientes Enteros ==================\n")
        println("Ingresa un número: ")
        var num1 = StdIn.readInt()
        println("Ingresa otro número: ")
        var num2 = StdIn.readInt()

        ej04CocienteEntero(num1,num2, 0)


      } else if(opcion == 5) {

        println("================== Mostrar el total de divisores de un numero ==================\n")
        println("Ingresa un número: ")
        var num1 = StdIn.readInt()
        println("Ingresa de que número quieres iniciar: ")
        var num2 = StdIn.readInt()
        ej05TotalDivisoresEnteros(num1, num2, 0)

      } else if(opcion == 6) {
        println("================== Convertir número Decimal a Binario ==================\n")
        println("Ingresa un número: ")
        var num1 = StdIn.readInt()
        ej06DecimalToBinario(num1, "")
      } else if(opcion == 7) {
        println("================== Total de Vocales en una cadena ==================\n")
        println("Ingresa un texto o frase: ")
        var cadena = StdIn.readLine()
        ej07TotalVocales(cadena, 1, 0)
      }

    } while(opcion != 8)


    //ej01Sumatoria(20, 50, 20)
    //ej02Divisores(20, 1)
    //ej03Factorial(9, 1, 1)

    //ej05TotalDivisoresEnteros(9, 3, 0)
    //ej06DecimalToBinario(24, "")
    //ej07TotalVocales("Hola mundo, esta es una prueba", 1, 0)
  }

  def ej01Sumatoria(sumatoria:Int, limF:Int, cont:Int) : Unit = {

    if(cont < (limF )) {
      ej01Sumatoria(sumatoria+(cont+1), limF, cont+1)
    } else {
      println("Valor de sumatoria: "+sumatoria)
    }

  }

  def ej02Divisores(num:Int, div:Int) : Unit = {
    if(div <= num) {
      if(num%div == 0){
        println("El número "+div+" es divisor de "+num)
      }
      ej02Divisores(num, div+1)
    }

  }

  def ej03Factorial(num:Int, cont:Int, factorial:Int) : Unit = {
    var resultado = factorial
    if(cont<num) {
      resultado = resultado * (cont+1)
      ej03Factorial(num, cont+1, resultado)
    } else
      println("El factorial de "+num+" es "+resultado)
  }

  def ej04CocienteEntero(num1:Int, num2:Int, cont:Int): Unit = {
    var total = num1
    var contador = cont
    if((total-num2) >= 0 ) {
      println(total+" - "+num2+" = "+(total-num2))
      contador+=1
      ej04CocienteEntero(total-num2, num2, contador)
    } else {
      println("El cociente es: "+contador)
    }
  }

  def ej05TotalDivisoresEnteros(num:Int, div:Int, total:Int): Unit = {
    var cont = total
    if(div <= num) {
      if(num%div == 0){
        cont += 1
      }
      ej05TotalDivisoresEnteros(num, div+1, cont)
    } else {
      println("El número "+num+" tiene "+cont+" divisores enteros" )
    }
  }

  def ej06DecimalToBinario(num:Int, cadena:String): Unit = {
    var binario = cadena
    if(num != 0) {
      binario = cadena+(num%2)+""
      ej06DecimalToBinario(num/2, binario)
    } else {
      println("El número Binario es "+binario.reverse)
    }
  }

  def ej07TotalVocales(cadena:String, posicion:Int, totalVocales:Int): Unit = {

    var total = totalVocales

    if(posicion < cadena.length) {
      if(cadena.toLowerCase().substring(posicion, posicion+1).equals("a") || cadena.toLowerCase().substring(posicion, posicion+1).equals("e") || cadena.toLowerCase().substring(posicion, posicion+1).equals("i") || cadena.toLowerCase().substring(posicion, posicion+1).equals("o") || cadena.toLowerCase().substring(posicion, posicion+1).equals("u")) {
        total += 1
      }
      ej07TotalVocales(cadena, posicion+1, total)
    } else {
      println("La cadena tiene "+total+" vocales")
    }

  }


}
