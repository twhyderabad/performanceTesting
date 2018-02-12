package query

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import jodd.util.URLDecoder

object LoginQuery {

  val username="TestGatling@gmail.com"
  val password="TestGatling"
  val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

  val getLoginQuery = http("getlogin")
    .get("/login")
    .headers(headers_0)
    .check(status.is(s => 200))

  val query = http("loginoneuser")
    .post("/login")
    .headers(headers_0)
//    .formParam("_token", "wTNUh7hBpCniRsSRc2gLPpBBzSpSHDKcxYuUCDPs")
    .formParam("email", username)
    .formParam("password", password)
    .check(headerRegex("Set-Cookie", "XSRF-TOKEN=(.*)").saveAs("xsrf_token"))
//    .check(headerRegex("Set-Cookie", """XSRF-TOKEN=(.*)\s""").transform(token => URLDecoder.decode(token, "UTF-8").dropRight(1)).saveAs("xsrfToken"))
    .check(status.is(s => 200))
    .check(substring(password).exists)
    .check(substring("You are logged in!").exists)

  val queryLogin = http("loginmultiuser")
    .post("/login")
    .headers(headers_0)
//    .formParam("_token", "wTNUh7hBpCniRsSRc2gLPpBBzSpSHDKcxYuUCDPs")
    .formParam("email", "${username}")
    .formParam("password", "${password}")
    .check(status.is(s => 200))
    .check(substring("${displayname}").exists)
    .check(substring("You are logged in!").exists)

  val home=http("home")
    .get("/home")
    .headers(headers_0)
    .formParam("Cookie","XSRF-TOKEN=\"${xsrfToken}\"")
}
