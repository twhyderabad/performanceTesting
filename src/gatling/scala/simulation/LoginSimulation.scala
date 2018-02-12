package simulation


import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class LoginSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://blazedemo.com")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-GB,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:57.0) Gecko/20100101 Firefox/57.0")
	val username="TestGatling@gmail.com"
	val password="TestGatling"
	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

    val uri1 = "http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"

	val scn = scenario("LoginSimulation")
		.exec(http("request_0")
			.get("/login")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/favicon.ico")))
		.pause(26)
		.exec(http("request_2")
			.post("/login")
			.headers(headers_0)
			.formParam("_token", "wTNUh7hBpCniRsSRc2gLPpBBzSpSHDKcxYuUCDPs")
			.formParam("email", {username})
			.formParam("password", {password})
			.check(status.is(s => 200))
			.check(substring(password).exists))
//		.pause(8)
//		.exec(http("request_3")
//			.post("/logout")
//			.headers(headers_0)
//			.formParam("_token", "wTNUh7hBpCniRsSRc2gLPpBBzSpSHDKcxYuUCDPs"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}