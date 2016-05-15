object Main extends App {
  val r = scala.util.Random
  val secretNum = r.nextInt(100)

  println("Guess the number")

  println("Secret " + secretNum)

  haveAGuess(secretNum)

  object Comp extends Enumeration {
    type Comp = Value
    val Less, Equal, Greater = Value
  }

  def compare(a: Int, b: Int): Comp.Value = {
    if (a > b) {
      Comp.Greater
    } else if (a < b) {
      Comp.Less
    } else {
      Comp.Equal
    }
  }

  def haveAGuess(secret: Int): Unit = {
    println("Input your guess")
    val input = scala.io.StdIn.readInt()
    println("You guessed: " + input)

    compare(input, secret) match {
      case Comp.Equal => println("You win!")
      case Comp.Greater => {
        println("Too big!")
        haveAGuess(secret)
      }
      case Comp.Less => {
        println("Too small!")
        haveAGuess(secret)
      }
    }
  }
}
