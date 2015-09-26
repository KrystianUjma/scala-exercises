import org.scalatest._
import coffee.lambda.Ex04ListCombinators._

class Ex04ListCombinatorsSpec extends FlatSpec with Matchers {
  "reverse" should "reverse" in {
    reverse(List(3, 2, 1)) should be(List(1, 2, 3))
  }

  "map" should "map" in {
    map[Int, Int](List(1, 2, 3), _ + 1) should be(List(2, 3, 4))
  }

  "filter" should "filter" in {
    filter[Int](List(1, 2, 3, 4), _ % 2 == 0) should be(List(2, 4))
  }

  "append" should "append" in {
    append(List(1, 2), List(3, 4)) should be(List(1, 2, 3, 4))
  }

  "concat" should "concat" in {
    concat(List(List(1, 2), List(3, 4), List(5))) should be(List(1, 2, 3, 4, 5))
  }

}
