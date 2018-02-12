package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class LoginSimulationComplete extends Simulation {

//  http request builder
  val httpProtocol = http
    .baseURL("http://blazedemo.com")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")

//variables
  val username="TestGatling@gmail.com"
  val password="TestGatling"

  val uri1 = "http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"
//Sceanrio building
  val scn = scenario("LoginSimulation")
    .exec(http("request_0")
      .get("/login")
      .resources(http("request_1")
        .get("/favicon.ico")))
    .pause(26)
    .exec(http("request_2")
      .post("/login")
      .formParam("_token", "wTNUh7hBpCniRsSRc2gLPpBBzSpSHDKcxYuUCDPs")
      .formParam("email", {username})
      .formParam("password", {password})
      .check(status.is(s => 200))
      .check())
    .pause(8)
    .exec(http("request_3")
      .post("/logout")
      .formParam("_token", "wTNUh7hBpCniRsSRc2gLPpBBzSpSHDKcxYuUCDPs"))

  //Test runner
  setUp(scn.inject(
    atOnceUsers(1)).protocols(httpProtocol))
}
