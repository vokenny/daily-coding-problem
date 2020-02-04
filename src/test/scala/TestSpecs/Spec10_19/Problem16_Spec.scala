package TestSpecs.Spec10_19

import Problems10_19.{Order, OrderIdCsv, OrderIdGen}
import TestSpecs.BaseSpec

class Problem16_Spec extends BaseSpec {

  "OrderGenId genUuid" should "return new UUID in String format" in {
    OrderIdGen.genUuid() should fullyMatch regex """[a-z0-9]{8}-[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{12}""".r
    OrderIdGen.genUuid().isInstanceOf[String] should be (true)
  }

  "Trait Csv filePath" should "return canonical path of filename" in {
    OrderIdCsv.filePath("kenny.csv") should be ("/Users/kennyvo/Documents/Learning/daily-coding-problem/src/main/resources/kenny.csv")
    OrderIdCsv.filePath("testfile.txt") should be ("/Users/kennyvo/Documents/Learning/daily-coding-problem/src/main/resources/testfile.txt")
  }

  "OrderIdCsv appendNewOrderId" should "add a single line to an empty csv" in {
    OrderIdCsv.clear()
    OrderIdCsv.readOrders().size should be (0)
    OrderIdCsv.appendNewOrderId()
    OrderIdCsv.readOrders().size should be (1)
  }

  it should "add a single line to a non-empty csv" in {
    OrderIdCsv.clear()
    OrderIdCsv.readOrders().size should be (0)
    OrderIdCsv.appendNewOrderId()
    OrderIdCsv.readOrders().size should be (1)
    OrderIdCsv.appendNewOrderId()
    OrderIdCsv.readOrders().size should be (2)
  }

  "OrderIdCsv appendMultiNewOrderId" should "add multiple lines to an empty csv" in {
    OrderIdCsv.clear()
    OrderIdCsv.readOrders().size should be (0)
    OrderIdCsv.appendMultiNewOrderId(10)
    OrderIdCsv.readOrders().size should be (10)
  }

  it should "add multiple lines to a non-empty csv" in {
    OrderIdCsv.clear()
    OrderIdCsv.readOrders().size should be (0)
    OrderIdCsv.appendNewOrderId()
    OrderIdCsv.readOrders().size should be (1)
    OrderIdCsv.appendMultiNewOrderId(10)
    OrderIdCsv.readOrders().size should be (11)
  }

  it should "return IllegalArgumentException for a zero Int parameter" in {
    an [IllegalArgumentException] should be thrownBy OrderIdCsv.appendMultiNewOrderId(0)
  }

  it should "return IllegalArgumentException for a negative Int parameter" in {
    an [IllegalArgumentException] should be thrownBy OrderIdCsv.appendMultiNewOrderId(-1)
  }

  "OrderIdCsv clear" should "remove all lines from a csv" in {
    OrderIdCsv.clear()
    OrderIdCsv.readOrders().size should be (0)
    OrderIdCsv.appendMultiNewOrderId(10)
    OrderIdCsv.readOrders().size should be (10)
    OrderIdCsv.clear()
    OrderIdCsv.readOrders().size should be (0)
  }

  "OrderIdCsv getLastI" should "get last ith Order, e.g. last 2nd = 2nd last" in {
    OrderIdCsv.clear()
    OrderIdCsv.appendMultiNewOrderId(10)
    val secondLast: Order = OrderIdCsv.readOrders()(8)
    OrderIdCsv.getLastI(2) should be (secondLast)
  }
}