import org.scalatest.FlatSpec

class Problem2_Spec extends FlatSpec {

  "getProductsOfOtherElems" should "return products of other elements in a list" in {
    assert(Problem2.getProductsOfOtherElems(List(0)) == List(1)) // Product of all other elems (Nil) == 1
    assert(Problem2.getProductsOfOtherElems(List(5)) == List(1)) // Product of all other elems (Nil) == 1
    assert(Problem2.getProductsOfOtherElems(List(1, 2)) == List(2, 1))
    assert(Problem2.getProductsOfOtherElems(List(2, 3, 4, 5, 6)) == List(360, 240, 180, 144, 120))
    assert(Problem2.getProductsOfOtherElems(List(1, -2, 3, 4, 5)) == List(-120, 60, -40, -30, -24))
    assert(Problem2.getProductsOfOtherElems(List(1, 0, 1, 1, 4, 1)) == List(0, 4, -0, 0, 0, 0))

    assert(Problem2.getProductsOfOtherElemsCallum(List(0)) == List(1)) // Product of all other elems (Nil) == 1
    assert(Problem2.getProductsOfOtherElemsCallum(List(5)) == List(1)) // Product of all other elems (Nil) == 1
    assert(Problem2.getProductsOfOtherElemsCallum(List(1, 2)) == List(2, 1))
    assert(Problem2.getProductsOfOtherElemsCallum(List(2, 3, 4, 5, 6)) == List(360, 240, 180, 144, 120))
    assert(Problem2.getProductsOfOtherElemsCallum(List(1, -2, 3, 4, 5)) == List(-120, 60, -40, -30, -24))
    assert(Problem2.getProductsOfOtherElemsCallum(List(1, 0, 1, 1, 4, 1)) == List(0, 4, -0, 0, 0, 0))
  }

  it should "return empty list for input of empty list" in {
    assert(Problem2.getProductsOfOtherElems(List()) == List())
    assert(Problem2.getProductsOfOtherElemsCallum(List()) == List())
  }

  it should "return empty list for input of no list" in {
    assert(Problem2.getProductsOfOtherElems(Nil) == List())
    assert(Problem2.getProductsOfOtherElemsCallum(Nil) == List())
  }
}
