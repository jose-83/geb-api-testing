package e2e.specs

import geb.spock.GebReportingSpec
import groovy.util.logging.Slf4j
import io.qameta.allure.Step

@Slf4j
class AbstractSpec extends GebReportingSpec {

    @Step("Step: \"{stepName}\"")
    void step(String stepName) {
        log.info(stepName)
    }
}
