package coffee.lambda

/* Problem 1: Closures.
 * Implement an immutable map (dictionary / hash) with String keys and Int values.
 * Don't use any classes, objects or built-in data structures (no Pairs, no Lists etc.).
 * Use just functions, storing all data in closures.
 */

object Ex01MapSolution {
  type Map = String => Option[Int]

  def emptyMap : Map = { _ => None }
  def fetch(map: Map, key: String): Option[Int] = { map(key) }
  def store(map: Map, key: String, value: Int): Map = {
    k => if (key == k) Some(value) else fetch(map, k)
  }
}