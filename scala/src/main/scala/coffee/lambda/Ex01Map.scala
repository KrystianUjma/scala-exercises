package coffee.lambda

/* Problem 1: Closures.
 * Implement an immutable map (dictionary / hash) with String keys and Int values.
 * Don't use any classes, objects or built-in data structures (no Pairs, no Lists etc.).
 * Use just functions, storing all data in closures.
 */

object Ex01Map {
  type Map = String => Option[Int] // Fill in the type here!

  def emptyMap : Map = _ => None // What is an empty map?
  def fetch(map: Map, key: String): Option[Int] = map(key) // How to fetch anything?
  def store(m1: Map, key: String, value: Int): Map = { (k: String) =>
    if(k == key) Some(value) else fetch(m1, k)
  } // And how to store?
  def remove(m: Map, key:String): Map = { k =>
    if(k == key) None else fetch(m,k)
  }
}