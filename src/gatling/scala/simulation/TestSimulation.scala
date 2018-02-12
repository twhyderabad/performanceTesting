package simulation



import io.gatling.core.Predef._
import io.gatling.http.Predef._

class TestSimulation extends Simulation {

  val httpProtocol = http
    .baseURL("http://blazedemo.com")
    .inferHtmlResources()
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-GB,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:57.0) Gecko/20100101 Firefox/57.0")
    .header("Upgrade-Insecure-Requests", "1")

  val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

  val uri1 = "http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"

  val scn = scenario("DemoSimulation")
    .exec(http("request_0")
      .get("/")
      .headers(headers_0))
    .pause(178)
    .exec(http("request_1")
      .post("/reserve.php")
      .headers(headers_0)
      .formParam("fromPort", "Boston")
      .formParam("toPort", "Berlin"))
    .pause(74)
    .exec(http("request_2")
      .post("/purchase.php")
      .headers(headers_0)
      .formParam("flight", "43")
      .formParam("price", "472.56")
      .formParam("airline", "Virgin America")
      .formParam("fromPort", "Boston")
      .formParam("toPort", "Berlin"))
    .pause(64)
    .exec(http("request_3")
      .post("/confirmation.php")
      .headers(headers_0)
      .formParam("_token", "")
      .formParam("inputName", "Test")
      .formParam("address", "Test st")
      .formParam("city", "Demo")
      .formParam("state", "Atlanta")
      .formParam("zipCode", "54321")
      .formParam("cardType", "visa")
      .formParam("creditCardNumber", "986789873764")
      .formParam("creditCardMonth", "11")
      .formParam("creditCardYear", "2017")
      .formParam("nameOnCard", "Null")
      .formParam("rememberMe", "on"))

  setUp(scn.inject(atOnceUsers(3))).protocols(httpProtocol)
}