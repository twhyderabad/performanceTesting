package scenario

import io.gatling.core.Predef._
import query._

object BlazedemoLoginScenario {

  val feeder = csv("loginDetails.csv").random

  val scn = scenario("LoginSimulation")
    .exec(LoginQuery.getLoginQuery)
    .exec(LoginQuery.query)
    .exec(LoginQuery.home)

  val scn1 = scenario("LoginSimulation").feed(feeder)
    .exec(LoginQuery.getLoginQuery)
    .exec(LoginQuery.queryLogin)

}
