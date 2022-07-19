package api.specs

import api.httpcalls.CategoryCall
import e2e.utils.categories.API
import io.qameta.allure.Story
import io.restassured.response.Response
import org.junit.experimental.categories.Category

@Category(API)
class CategorySpec extends AbstractAPISpec {

    private static final String ID = "abcat0010000"

    @Story("Story: As a system, I want to retrieve a category by using category ID")
    def "Retrieve a category from BestBuy API playground by id"() {
        when:
        step("WHEN a system requests a category with this ID:$ID")
        Response response = CategoryCall.getCategoryById(ID)
        List categoryIds = CategoryCall.getAllCategoryIDs(response)

        then:
        step("THEN the system receives only one category with the desired id")
        response.statusCode() == 200
        categoryIds.size() == 1
        categoryIds[0] == ID
    }
}
