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
      .map(input => replaceStringWithNumber(input))
      .map(input => input.filter(_.isDigit))
      .map(input => if(input.length == 1) input + input else input)
      .map(inputDigits => inputDigits.head.toString + inputDigits.last.toString)
      .map(_.toInt)
  }
  def replaceStringWithNumber(input: String): String = {
    val map = Map(
      "one" -> "1",
      "two" -> "2",
      "three" -> "3",
      "four" -> "4",
      "five" -> "5",
      "six" -> "6",
      "seven" -> "7",
      "eight" -> "8",
      "nine" -> "9",
    )
    var output = ""
    map.foreach(entry => output = input.replace(entry._1, entry._2))
    output
  }
}
