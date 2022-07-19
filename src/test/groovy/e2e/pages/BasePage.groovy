package e2e.pages

import geb.Page
import org.openqa.selenium.By

class BasePage extends Page {

    static content = {
        logo(required: false) { $(By.id('tw-logo')) }
        goToPreview(required: false) { $(By.linkText("Go to overview")) }
    }
}
