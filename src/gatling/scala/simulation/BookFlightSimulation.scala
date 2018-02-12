package simulation

/**
  * Created by biswajip on 11/25/17.
  */

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import config.Config
import actions.SearchFlight
import actions.BookTicket
import actions.SelectFlight

class BookFlightSimulation extends Simulation {

  val httpProtocol = http
    .baseURL(Config.baseUrl)
    .inferHtmlResources(black = BlackList(""".*\.js""", """.*\.css"""))
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")

  val feeder = csv("flight-itenerary.csv").random

  val scenarioBookFlight = scenario("Book Flight").feed(feeder)
    // Search Flight
    .exec(SearchFlight())
    .pause(10)
    // Select Flight
    .exec(SelectFlight())
    .pause(20)
    // Buy Ticket
    .exec(BookTicket())

  setUp(
    scenarioBookFlight.
      inject(
      atOnceUsers(1)
//      atOnceUsers(10),
//      nothingFor(10),
//      rampUsers(10) over(10),
//      constantUsersPerSec(1) during(20) randomized,
//      constantUsersPerSec(0) during (30),
//      rampUsersPerSec(30) to(10) during(20),
//      constantUsersPerSec(0) during(10),
//      rampUsersPerSec(10) to(1) during(10)
    )
  ).protocols(httpProtocol).assertions(forAll.responseTime.min.is(10))
//    assertions(forAll.failedRequests.count.is(0))
}

