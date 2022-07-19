package api.httpcalls

import io.restassured.response.Response

class ProductCall extends BaseCall {

    private static final String PRODUCTS_ENDPOINT = Endpoint.PRODUCTS.name().toLowerCase()

    static Response getProductById(Long id) {
        return getRequest("/$PRODUCTS_ENDPOINT?\$limit=1&id=$id")
    }

    static Response getProductsByCategoryName(String category) {
        return getRequest("/$PRODUCTS_ENDPOINT?category.name=$category")
    }

    static List<Integer> getAllProductIDs(Response response) {
        response.jsonPath().getList("data.id")
    }

    static List<String> getAllCategoryNames(Response response) {
        response.jsonPath().getList("data.categories.name")
    }
}
