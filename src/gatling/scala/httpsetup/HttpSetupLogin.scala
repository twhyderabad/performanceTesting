package httpsetup

import io.gatling.http.Predef._
import io.gatling.core.Predef._

object HttpSetupLogin {

  val httpProtocolLogin = http
    .baseURL("http://blazedemo.com")
//    .inferHtmlResources()
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-GB,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:57.0) Gecko/20100101 Firefox/57.0")

}
