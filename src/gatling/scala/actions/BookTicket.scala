package actions

/**
  * Created by biswajip on 11/25/17.
  */

import io.gatling.http.Predef._
import io.gatling.core.Predef._

object BookTicket {
  def apply() = {
    http("Buy Ticket")
      .post("/confirmation.php")
      .formParam("_token", "")
      .formParam("inputName", "Biswajit")
      .formParam("address", "123 Main St")
      .formParam("city", "Dallas")
      .formParam("state", "Texas")
      .formParam("zipCode", "75754")
      .formParam("cardType", "visa")
      .formParam("creditCardNumber", "1111222233334444")
      .formParam("creditCardMonth", "11")
      .formParam("creditCardYear", "2018")
      .formParam("nameOnCard", "Biswajit Pattanayak")
      .check(status.is(s => 200))
  }
}
