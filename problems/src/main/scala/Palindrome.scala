object Palindrome {
  def main(array: Array[String]): Unit = {
    println(twoPointerSolution("nun"))
  }

  def twoPointerSolution(input: String): Boolean = {
    for (i <- 0 to (input.size / 2 + input.size % 2 - 1)) {
      val left = input(i)
      val right = input(input.size - 1 - i)
      if (left != right) {
        return false
      }
    }
    true
  }
}
