package config

/**
  * Created by biswajip on 11/25/17.
  */

import com.typesafe.config.ConfigFactory

object Config {

  val config = ConfigFactory.load("bookFlight-test").getConfig("local")

  val baseUrl = config.getString("baseUrl")

}
