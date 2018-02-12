package actions

/**
  * Created by biswajip on 11/25/17.
  */

import io.gatling.http.Predef._
import io.gatling.core.Predef._

object SearchFlight {

  def apply() = {
    http("Search Flight")
        .post("/reserve.php")
      .formParam("fromPort", "${fromPort}")
      .formParam("toPort", "${toPort}")
      .check(status.is(s => 200))
      .check(regex("Lufthansa").find(0).saveAs("airline"))
//      .check(xpath("//table[@class='table']/tbody/tr/td[2]").findAll.saveAs("airlineCode"))
//      .check(xpath("//table[@class='table']/tbody/tr/td[3]").findAll.saveAs("airlineName"))

  }

}
