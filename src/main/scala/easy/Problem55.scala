package easy

import scala.util.{Failure, Random, Success, Try}

object Problem55 extends App {

  // 2020-11-10

  //  EASY
  //  This problem was asked by Microsoft.
  //
  //  Implement a URL shortener with the following methods:
  //
  //      shorten(url), which shortens the url into a six-character alphanumeric string, such as zLg6wl.
  //      restore(short), which expands the shortened string into the original url.
  //      If no such shortened string exists, return null.
  //
  //  Hint: What if we enter the same URL twice?

  var urlMap: Map[String, String] = Map()

  def shorten(url: String): String = {
    val short: String = Random.alphanumeric.take(6).mkString
    urlMap = urlMap + (short -> url)
    short
  }

  def restore(short: String): Option[String] = {
    Try(urlMap(short)) match {
      case Success(u) => Some(u)
      case Failure(_) => None
    }
  }

  println("urlMap: " + urlMap)
  val shortUrl1: String = shorten("https://www.google.com")
  val shortUrl2: String = shorten("https://www.google.com")
  println(shortUrl1)
  println(shortUrl2)
  println("urlMap: " + urlMap)
  println(restore(shortUrl1))
  println(restore("Hello"))

}
