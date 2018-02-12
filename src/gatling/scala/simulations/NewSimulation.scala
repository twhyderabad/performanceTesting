package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class NewSimulation extends Simulation {

  //Step 1 is building http conf
  val httpConf = http.baseURL("http://www.google.com")

  //create myscenario
  val scn = scenario("myScenario")

  //create a run with virtual users.
  setUp(scn.inject(atOnceUsers(1)).protocols(httpConf)).assertions(forAll.responseTime.min.is(10))
  //    assertions(forAll.failedRequests.count.is(0))


  //Step 1 is building http conf
  val httpConf1 = http.baseURL("http://www.google.com")

  //create myscenario
  val scn1 = scenario("getGoogleScenario")
      .exec(http("getGoogle").get("/"))
      .exec(http("getGoogle").get("/search"))



  //create a run
//  setUp(scn1.inject(atOnceUsers(1)).protocols(httpConf1)).assertions(forAll.responseTime.min.is(10))
  //    assertions(forAll.failedRequests.count.is(0))

//  atOnceUsers(10),
  //      nothingFor(10),
  //      rampUsers(10) over(10),
  //      constantUsersPerSec(1) during(20) randomized,
  //      constantUsersPerSec(0) during (30),
  //      rampUsersPerSec(30) to(10) during(20),
  //      constantUsersPerSec(0) during(10),
  //      rampUsersPerSec(10) to(1) during(10)

}
