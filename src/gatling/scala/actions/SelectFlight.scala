package actions

import io.gatling.http.Predef._
import io.gatling.core.Predef._

/**
  * Created by biswajip on 12/4/17.
  */
object SelectFlight {

  def apply() = {
    http("Select Flight")
      .post("/purchase.php")
      .formParam("flight", "4346")
      .formParam("price", "233.98")
      .formParam("airline", "${airline}")
      .formParam("fromPort", "${fromPort}")
      .formParam("toPort", "${toPort}")
  }

}
