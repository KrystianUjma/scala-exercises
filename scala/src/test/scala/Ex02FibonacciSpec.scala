import org.scalatest._
import coffee.lambda.Ex02Fibonacci._

class Ex02FibonacciSpec extends FlatSpec with Matchers {
  val cases = List((0, BigInt(0)), (3, BigInt(2)), (7, BigInt(13)), (47, BigInt(2971215073L)))

  def testFibonacciImpl(impl: Int => BigInt) = {
    cases.foreach({ case (in, out) => impl(in) should be(out) })
  }

  "tailFibonacci" should "give correct answers" in {
    testFibonacciImpl(tailFibonacci)
  }

  "streamFibonacci" should "give correct answers" in {
    testFibonacciImpl(streamFibonacci)
  }
}
