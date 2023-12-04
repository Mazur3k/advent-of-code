import dayone.Calibrator

object Main {
  def main(args: Array[String]): Unit = {
    val calibrator = new Calibrator
    val numbers = calibrator.sumTheNumbers
    println(numbers)
  }
}
