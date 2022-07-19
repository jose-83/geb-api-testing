package api.specs

import groovy.util.logging.Slf4j
import io.qameta.allure.Step
import spock.lang.Specification

@Slf4j
class AbstractAPISpec extends Specification {

    @Step("Step: \"{stepName}\"")
    void step(String stepName) {
        log.info(stepName)
    }
}
