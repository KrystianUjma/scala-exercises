package coffee.lambda


/* Problem 3: Folds.
 * Implement three versions of fold function.
 * a) foldLeft  - tail recursive function applying the function in the left-to-right order.
 * b) foldRight - non-tail recursive, applying right-to-left.
 * c) folds     - using list-manipulation techniques generate a stream of all partial results
 *                of folding in the left-to-right order.
 */

object Ex03Folds {
  def foldLeft[A, B](fun: (B, A) => B, acc: B, list: List[A]): B = list match{
    case Nil => acc
    case x :: xs => foldLeft(fun, fun(acc,x), xs)
  }

  def foldRight[A, B](fun: (A, B) => B, init: B, list: List[A]): B = list match{
    case Nil => init
    case x :: xs => {
      val rest = foldRight(fun, init, xs)
      fun(x, rest)
    }
  }

  def folds[A, B](fun: (A, B) => B, acc: B, list: List[A]): Stream[B] = {
    lazy val res: Stream[B] = acc #:: list.toStream.zip(res).map(x => fun(x._1, x._2))
    res
  }
}
