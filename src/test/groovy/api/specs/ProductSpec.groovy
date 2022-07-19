package api.specs

import api.httpcalls.ProductCall
import e2e.utils.categories.API
import io.qameta.allure.Story
import io.restassured.response.Response
import org.junit.experimental.categories.Category

@Category(API)
class ProductSpec extends AbstractAPISpec {

    private static final Long ID = 9132294
    private static final String  CATEGORY_NAME = "Coffee Pods"

    @Story("Story: As a system, I want to retrieve a product by using product ID")
    def "Retrieve a product from BestBuy API playground by id"() {
        when:
        step("WHEN a system requests a product with this ID:$ID")
        Response response = ProductCall.getProductById(ID)
        List productIds = ProductCall.getAllProductIDs(response)

        then:
        step("THEN the system receives only one product with the desired id")
        response.statusCode() == 200
        productIds.size() == 1
        productIds[0] == ID
    }

    @Story("Story: As a system, I want to retrieve products with a category name")
    def "Retrieve products from BestBuy API playground by category names"() {
        when:
        step("WHEN a system requests products with this category name:$CATEGORY_NAME")
        Response response = ProductCall.getProductsByCategoryName(CATEGORY_NAME)
        List categoryNames = ProductCall.getAllCategoryNames(response)

        then:
        step("THEN each received product contains desired category name")
        response.statusCode() == 200
        categoryNames.every { it.contains(CATEGORY_NAME) }
    }
}
