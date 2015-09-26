package coffee.lambda

/* Problem 3: Folds.
 * Implement three versions of fold function.
 * a) foldLeft  - tail recursive function applying the function in the left-to-right order.
 * b) foldRight - non-tail recursive, applying right-to-left.
 * c) folds     - using list-manipulation techniques generate a stream of all partial results
 *                of folding in the left-to-right order.
 */

object Ex03FoldsSolution {
  def foldLeft[A, B](fun: (B, A) => B, acc: B, list: List[A]): B = list match {
    case Nil => acc
    case x :: xs => foldLeft(fun, fun(acc, x), xs)
  }

  def foldRight[A, B](fun: (A, B) => B, acc: B, list: List[A]): B = list match {
    case Nil => acc
    case x :: xs => fun(x, foldRight(fun, acc, xs))
  }

  def folds[A, B](fun: (A, B) => B, acc: B, list: List[A]): Stream[B] = {
    lazy val accs: Stream[B] = acc #:: list.toStream.zip(accs).map({ case (x, y) => fun(x, y) })
    accs
  }
}
