import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

import static java.lang.String.format

waiting {
    timeout = 15
    retryInterval = 0.4
}

environments {

    String url = format(System.getProperty("remote.url"), System.getProperty("host"))
    URL remoteUrl = new URL(url)
    Integer windowWidth = 1680
    Integer windowHeight = 1050
    Dimension dimension = new Dimension(windowWidth, windowHeight)

    chrome {

        driver = {
            ChromeOptions chromeOptions = new ChromeOptions()
            chromeOptions.addArguments("--window-size=${windowWidth},${windowHeight}")
            new ChromeDriver(chromeOptions)
        }
    }

    firefox {

        driver = {
            WebDriver webDriver = new FirefoxDriver()
            webDriver.manage().window().setSize(dimension)
            return webDriver
        }
    }

    remoteChrome {

        driver = {
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome()
            ChromeOptions chromeOptions = new ChromeOptions()
            chromeOptions.addArguments("--window-size=${windowWidth},${windowHeight}")
            desiredCapabilities.setCapability("idleTimeout", 720000)
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions)
            new RemoteWebDriver(remoteUrl, desiredCapabilities)
        }
    }

    remoteFirefox {

        driver = {
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox()
            desiredCapabilities.setCapability("idleTimeout", 720000)
            WebDriver webDriver = new RemoteWebDriver(remoteUrl, desiredCapabilities)
            webDriver.manage().window().setSize(dimension)
            return webDriver
        }
    }
}

reportOnTestFailureOnly = true
atCheckWaiting = true
reportsDir = 'build/reports'
baseUrl = "https://${System.getProperty("test.env")}/"
