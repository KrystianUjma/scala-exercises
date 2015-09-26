import org.scalatest._
import coffee.lambda.Ex01Map._

class Ex01MapSpec extends FlatSpec with Matchers {
  "Empty map" should "always return None" in {
    fetch(emptyMap, "something") should be(None)
  }

  "Store" should "actually store something" in {
    fetch(store(emptyMap, "some key", 40), "some key") should be(Some(40))
  }

  "Stored values" should "persist between store calls" in {
    val biggerMap = store(store(emptyMap, "some key", 40), "other key", 50)
    fetch(biggerMap, "some key") should be(Some(40))
  }

  "Storing again under the same key" should "shadow the old value" in {
    val shadowMap = store(store(emptyMap, "some key", 40), "some key", 75)
    fetch(shadowMap, "some key") should be(Some(75))
  }
}
