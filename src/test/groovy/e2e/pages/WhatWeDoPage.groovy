package e2e.pages

import org.openqa.selenium.By

class WhatWeDoPage extends BasePage {

    static url = "/what-we-do"
    static at = { banner.displayed }
    static content = {
        banner { $(By.xpath("//img[@alt='What we do banner' and @src]")) }
    }
}
