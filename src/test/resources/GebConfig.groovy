import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
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

    chrome {

        driver = {
            ChromeOptions chromeOptions = new ChromeOptions()
            chromeOptions.addArguments("--window-size=${windowWidth},${windowHeight}")
            new ChromeDriver(chromeOptions)
        }
    }

    firefox {

        driver = {
            FirefoxOptions firefoxOptions = new FirefoxOptions()
            firefoxOptions.addArguments("--window-size=${windowWidth},${windowHeight}")
            new FirefoxDriver(firefoxOptions)
        }
    }

    remoteChrome {

        driver = {
            ChromeOptions chromeOptions = new ChromeOptions()
            chromeOptions.addArguments("--window-size=${windowWidth},${windowHeight}")
            new RemoteWebDriver(remoteUrl, chromeOptions)
        }
    }

    remoteFirefox {

        driver = {
            FirefoxOptions firefoxOptions = new FirefoxOptions()
            firefoxOptions.addArguments("--window-size=${windowWidth},${windowHeight}")
            new RemoteWebDriver(remoteUrl, firefoxOptions)
        }
    }
}

reportOnTestFailureOnly = true
atCheckWaiting = true
reportsDir = 'build/reports'
baseUrl = "https://${System.getProperty("test.env")}/"
