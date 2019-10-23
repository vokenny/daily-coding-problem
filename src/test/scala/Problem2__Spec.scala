import org.scalatest.FlatSpec

class Problem2__Spec extends FlatSpec {

  "removeAt" should "return list with given index removed" in {
    assert(Problem2.removeAt(0, List(1, 2, 3, 4, 5)) == List(2, 3, 4, 5))
    assert(Problem2.removeAt(1, List(1, 2, 3, 4, 5)) == List(1, 3, 4, 5))
    assert(Problem2.removeAt(2, List(1, 2, 3, 4, 5)) == List(1, 2, 4, 5))
    assert(Problem2.removeAt(3, List(1, 2, 3, 4, 5)) == List(1, 2, 3, 5))
    assert(Problem2.removeAt(4, List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4))
  }

  it should "return NoSuchElementException for input of empty list" in {
    assertThrows[NoSuchElementException] {
      Problem2.removeAt(0, List())
    }
  }

  it should "return NoSuchElementException for index out of bounds of list" in {
    assertThrows[NoSuchElementException] {
      Problem2.removeAt(-1, List(1, 2, 3, 4, 5))
    }

    assertThrows[NoSuchElementException] {
      Problem2.removeAt(5, List(1, 2, 3, 4, 5))
    }
  }

  "getProductsOfOtherElems" should "return products of other elements in a list" in {
    assert(Problem2.getProductsOfOtherElems(List(0)) == List(0))
    assert(Problem2.getProductsOfOtherElems(List(1)) == List(1))
    assert(Problem2.getProductsOfOtherElems(List(1, 2)) == List(2, 1))
    assert(Problem2.getProductsOfOtherElems(List(2, 3, 4, 5, 6)) == List(360, 240, 180, 144, 120))
    assert(Problem2.getProductsOfOtherElems(List(1, -2, 3, 4, 5)) == List(-120, 60, -40, -30, -24))

    assert(Problem2.getProductsOfOtherElemsFunc(List(0)) == List(1)) // Product of all other elems (Nil) == 1
    assert(Problem2.getProductsOfOtherElemsFunc(List(5)) == List(1)) // Product of all other elems (Nil) == 1
    assert(Problem2.getProductsOfOtherElemsFunc(List(1, 2)) == List(2, 1))
    assert(Problem2.getProductsOfOtherElemsFunc(List(2, 3, 4, 5, 6)) == List(360, 240, 180, 144, 120))
    assert(Problem2.getProductsOfOtherElemsFunc(List(1, -2, 3, 4, 5)) == List(-120, 60, -40, -30, -24))
  }

  it should "return empty list for input of empty list" in {
    assert(Problem2.getProductsOfOtherElems(List()) == List())
    assert(Problem2.getProductsOfOtherElemsFunc(List()) == List())
  }

  it should "return empty list for input of no list" in {
    assert(Problem2.getProductsOfOtherElems(Nil) == List())
    assert(Problem2.getProductsOfOtherElemsFunc(Nil) == List())
  }
}
