import scala.io.StdIn
import scala.util.control.Exception.allCatch

object Calculator {
  case object DivisionPorCero

  private var selection: String = _
  private var number1: String = _
  private var number2: String = _
  private var isValid: Boolean = false

  def add(x: Double, y: Double): Double = x + y

  def subtract(x: Double, y: Double): Double = x - y

  def multiply(x: Double, y: Double): Double = x * y

  def divide(x: Double, y: Double): Any = {
    y match {
      case 0 => DivisionPorCero
      case _ => x / y
    }
  }

  def validateSelection(option: String): Boolean = {
    if (option == "1" || option == "2" || option == "3" || option == "4") {
      true
    } else {
      false
    }
  }

  def isDoubleNumber(s: String): Boolean = (allCatch opt s.toDouble).isDefined


  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    do {
      println("\n")
      println("Seleccione la operación que desee realizar:")
      println("1. Sumar ")
      println("2. Restar")
      println("3. Multiplicar")
      println("4. Dividir")
      println("5. Salir del programa")

      selection = StdIn.readLine()
      isValid = validateSelection(selection)

      if (isValid) {
        do {
          println("Inserte el primer número:")
          number1 = StdIn.readLine()
        } while (!isDoubleNumber(number1))

        do {
          println("Inserte el segundo número:")
          number2 = StdIn.readLine()
        } while (!isDoubleNumber(number2))

      }

      selection match {
        case "1" => println("Resultado: " + add(number1.toDouble, number2.toDouble))
        case "2" => println("Resultado: " + subtract(number1.toDouble, number2.toDouble))
        case "3" => println("Resultado: " + multiply(number1.toDouble, number2.toDouble))
        case "4" => println("Resultado: " + divide(number1.toDouble, number2.toDouble))
        case "5" => println("Saliendo del programa...")
        case _ => println("Seleccione una opción válida")
      }
    } while (selection != "5")
  }
}
