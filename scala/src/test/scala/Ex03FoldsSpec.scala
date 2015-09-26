import org.scalatest._
import coffee.lambda.Ex03Folds._

class Ex03FoldsSpec extends FlatSpec with Matchers {
  "foldLeft" should "sum a list" in {
    foldLeft[Int, Int](_ + _, 0, List(1, 2, 3, 4)) should be(10)
  }

  "foldLeft" should "reverse a list when used with ::" in {
    foldLeft[Int, List[Int]]((l, e) => e :: l, List(), List(1, 2, 3, 4)) should be(List(4, 3, 2, 1))
  }

  "foldRight" should "sum a list" in {
    foldRight[Int, Int](_ + _, 0, List(1, 2, 3, 4)) should be(10)
  }

  "foldLeft" should "not reverse a list when used with ::" in {
    foldRight[Int, List[Int]](_ :: _, List(), List(1, 2, 3, 4)) should be(List(1, 2, 3, 4))
  }

  "folds" should "return a stream of all partial results" in {
    folds[Int, Int](_ + _, 0, List(1, 2, 3, 4)) should be(Stream(0, 1, 3, 6, 10))
  }
}
