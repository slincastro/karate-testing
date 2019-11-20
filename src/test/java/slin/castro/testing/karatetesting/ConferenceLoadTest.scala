package slin.castro.testing.karatetesting

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._


class ConferenceLoadTest extends Simulation {

  val nbUsers = Integer.parseInt(System.getProperty("users", "1200"))
  val duration = Integer.parseInt(System.getProperty("duration","160"))

  val protocol = karateProtocol(
    "sessions" -> pauseFor("get" -> 25)
  )

  protocol.nameResolver = (req, ctx) => req.getHeader("karate-name")

  val create = scenario("ListSessions").exec(karateFeature("classpath:slin/castro/testing/karatetesting/sample.feature"))

  setUp(
    create.inject(rampUsers(nbUsers) during (duration seconds)).protocols(protocol),
  )
}