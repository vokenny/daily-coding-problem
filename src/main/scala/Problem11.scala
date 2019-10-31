object Problem11 extends App {

  // MEDIUM
  // This problem was asked by Twitter.
  //
  // Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.
  //
  // For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
  //
  // Hint: Try pre-processing the dictionary into a more efficient data structure to speed up queries.

  // Sort alphabetically
  // Filter by substring
  // Return all that match filter

  val dictionary = List("deutsche", "drive", "dog", "deer", "develop","deal", "dapper", "duo", "drink", "depth", "doppler")

  def autocomplete(dictionary: List[String], queryStr: String): List[String] = {
    dictionary.filter(e => e.contains(queryStr)).sorted
  }

  println(autocomplete(dictionary, "de"))
}
