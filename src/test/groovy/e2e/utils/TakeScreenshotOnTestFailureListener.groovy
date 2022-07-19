package e2e.utils

import geb.Browser
import groovy.util.logging.Slf4j
import io.qameta.allure.Attachment
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.model.ErrorInfo

@Slf4j
class TakeScreenshotOnTestFailureListener extends AbstractRunListener {

    void error(ErrorInfo error) {
        screenShot()
        log.error("Error in method: " + error.method.name)
    }

    @Attachment(value = "Entire page Screenshot", type = "image/png")
    byte[] screenShot() {
        ((TakesScreenshot) new Browser().driver).getScreenshotAs(OutputType.BYTES)
    }
}
