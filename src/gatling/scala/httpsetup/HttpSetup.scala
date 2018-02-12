package httpsetup

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object HttpSetup {
  val httpProtocol = http
    .baseURL("http://www.google.com")
    .contentTypeHeader("application/json")
}