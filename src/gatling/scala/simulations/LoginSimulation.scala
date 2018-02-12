package simulations

import _root_.scenario._
import httpsetup._
import io.gatling.core.Predef._
class LoginSimulation extends Simulation{

  val httpConf = HttpSetupLogin.httpProtocolLogin
  val scn = BlazedemoLoginScenario.scn
  val scn1 = BlazedemoLoginScenario.scn1

  setUp(scn.inject(atOnceUsers(1))
    .protocols(httpConf)).assertions(forAll.failedRequests.count.is(0))

//  setUp(scn1.inject( rampUsers(10) over(10))
//    .protocols(httpConf)).assertions(forAll.failedRequests.count.is(0))

//    setUp(scn1.inject( rampUsers(1) over(1))
//      .protocols(httpConf)).assertions(forAll.failedRequests.count.is(0))

}
