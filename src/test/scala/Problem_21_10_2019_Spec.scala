import org.scalatest.FlatSpec

class Problem_21_10_2019_Spec extends FlatSpec {

  "removeAt" should "return list with given index removed" in {
    assert(Problem_21_10_2019.removeAt(0, List(1, 2, 3, 4, 5)) == List(2, 3, 4, 5))
    assert(Problem_21_10_2019.removeAt(1, List(1, 2, 3, 4, 5)) == List(1, 3, 4, 5))
    assert(Problem_21_10_2019.removeAt(2, List(1, 2, 3, 4, 5)) == List(1, 2, 4, 5))
    assert(Problem_21_10_2019.removeAt(3, List(1, 2, 3, 4, 5)) == List(1, 2, 3, 5))
    assert(Problem_21_10_2019.removeAt(4, List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4))
  }

  it should "return NoSuchElementException for input of empty list" in {
    assertThrows[NoSuchElementException] {
      Problem_21_10_2019.removeAt(0, List())
    }
  }

  it should "return NoSuchElementException for index out of bounds of list" in {
    assertThrows[NoSuchElementException] {
      Problem_21_10_2019.removeAt(-1, List(1, 2, 3, 4, 5))
    }

    assertThrows[NoSuchElementException] {
      Problem_21_10_2019.removeAt(5, List(1, 2, 3, 4, 5))
    }
  }

  "getProductsOfOtherElems" should "return products of other elements in a list" in {
    assert(Problem_21_10_2019.getProductsOfOtherElems(List(0)) == List(0))
    assert(Problem_21_10_2019.getProductsOfOtherElems(List(1)) == List(1))
    assert(Problem_21_10_2019.getProductsOfOtherElems(List(1, 2)) == List(2, 1))
    assert(Problem_21_10_2019.getProductsOfOtherElems(List(2, 3, 4, 5, 6)) == List(360, 240, 180, 144, 120))
    assert(Problem_21_10_2019.getProductsOfOtherElems(List(1, -2, 3, 4, 5)) == List(-120, 60, -40, -30, -24))
  }

  it should "return empty list for input of empty list" in {
    assert(Problem_21_10_2019.getProductsOfOtherElems(List()) == List())
  }

  it should "return empty list for input of no list" in {
    assert(Problem_21_10_2019.getProductsOfOtherElems(Nil) == List())
  }
}
