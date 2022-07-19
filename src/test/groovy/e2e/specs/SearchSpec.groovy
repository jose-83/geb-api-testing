package e2e.specs

import e2e.pages.HomePage
import e2e.utils.categories.E2E
import io.qameta.allure.Story
import org.junit.experimental.categories.Category
import spock.lang.Unroll

@Category(E2E)
class SearchSpec extends AbstractSpec {

    @Story("Story: Simple test")
    @Unroll
    def "Base url should be opened"() {
        given:
        step("GIVEN a user is on the home page")
        HomePage homePage = to(HomePage)

        when:
        step("WHEN the user navigates to what we do page")
        homePage.navigateToWhatWeDo()

        then:
        1 == 1
    }
}
