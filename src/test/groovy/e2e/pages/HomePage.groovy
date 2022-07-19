package e2e.pages

import org.openqa.selenium.By

class HomePage extends BasePage {
    static url = "/"
    static at = { logo }

    static content = {
        whatWeDoLink { $(By.xpath("//*[@title='What we do']")) }
        insightaLink { $(By.xpath("//*[@title='Insights']")) }
        careersLink { $(By.xpath("//*[@title='Careers']")) }
        aboutLink { $(By.xpath("//*[@title='About']")) }
    }

    WhatWeDoPage navigateToWhatWeDo() {
        whatWeDoLink.click()
        goToPreview.click()
        browser.at(WhatWeDoPage)
    }
}
