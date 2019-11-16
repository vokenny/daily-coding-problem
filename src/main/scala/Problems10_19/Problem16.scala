package Problems10_19

import java.io.{BufferedWriter, File, FileWriter}
import java.util.UUID

import scala.annotation.tailrec
import scala.io.Source

object Problem16 extends App {

  // EASY
  // This problem was asked by Twitter.
  //
  // You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:
  //
  // record(order_id): adds the order_id to the log
  // get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
  // You should be as efficient with time and space as possible.

  // Record orders to a csv file
  // Read and parse orders
  // Get last ith, by reverse then i

  OrderIdCsv.clear()
  OrderIdCsv.appendNewOrderId()
  OrderIdCsv.appendMultiNewOrderId(10)
  println(OrderIdCsv.readOrders())
  println(OrderIdCsv.readOrders().size)
  println(OrderIdCsv.getLastI(1))
}

case class Order(id: String)

object OrderIdGen {

  def genUuid(): String = UUID.randomUUID().toString
}

trait Csv {

  def filePath(name: String): String = new File(s"src/main/resources/$name").getCanonicalPath

  def readLines(fileName: String): List[String] = Source.fromFile(fileName).getLines().toList
}

object OrderIdCsv extends Csv {

  def clear(): Unit = new BufferedWriter(new FileWriter(filePath("OrderIds.csv"))).close()

  def appendNewOrderId(): Unit = {
    val bw: BufferedWriter = new BufferedWriter(new FileWriter(filePath("OrderIds.csv"), true))

    if (readOrders().isEmpty) bw.write(OrderIdGen.genUuid())
    else {
      bw.write(",\n")
      bw.write(OrderIdGen.genUuid())
    }

    bw.close()
  }

  def appendMultiNewOrderId(num: Int): Unit = {
    val bw: BufferedWriter = new BufferedWriter(new FileWriter(filePath("OrderIds.csv"), true))

    @tailrec
    def appendNewOrderId(count: Int): Unit = {
      count match {
        case c if c <= 0 => throw new IllegalArgumentException
        case 1 =>
          if (readOrders().isEmpty) bw.write(OrderIdGen.genUuid())
          else bw.write(",\n" + OrderIdGen.genUuid())
        case _ =>
          if (readOrders().isEmpty) bw.write(OrderIdGen.genUuid() + ",\n")
          else bw.write(",\n" + OrderIdGen.genUuid())

          appendNewOrderId(count - 1)
      }
    }

    appendNewOrderId(num)
    bw.close()
  }

  def readOrders(): List[Order] = readLines(filePath("OrderIds.csv")).map(id => Order(id.replaceAll(",", "")))

  def getLastI(i: Int): Order = readOrders().reverse(i - 1)
}

