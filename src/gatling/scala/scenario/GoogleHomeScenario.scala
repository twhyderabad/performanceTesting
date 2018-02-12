package scenario

import io.gatling.core.Predef._
import query._

object GoogleHomeScenario {
  val googleScenario = scenario("Google Home Page Scenario")
    .exec(GoogleQuery.query)

}