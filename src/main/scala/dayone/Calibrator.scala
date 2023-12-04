package dayone

import scala.io.Source

class Calibrator {
  def sumTheNumbers: Int = {
    val fr = new FileReader
    val input = fr.getInputData("src/main/resources/input.txt")
    val converter = new Converter
    val properDigitsPerInput = converter.getNumbers(input)
    properDigitsPerInput.sum
  }
}

class FileReader {
  def getInputData(src: String): List[String] = {
    val input = Source.fromFile(src)
    input.getLines().toList
  }
}

class Converter {
  def getNumbers(list: List[String]): List[Int] = {
    list
      .map(input => input.filter(_.isDigit))
      .map(input => if(input.length == 1) input + input else input)
      .map(inputDigits => inputDigits.head.toString + inputDigits.last.toString)
      .map(_.toInt)
  }
}
