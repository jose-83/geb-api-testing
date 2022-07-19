package api.httpcalls

import io.restassured.response.Response

class CategoryCall extends BaseCall {

    private static final String CATEGORIES_ENDPOINT = Endpoint.CATEGORIES.name().toLowerCase()

    static Response getCategoryById(String id) {
        return getRequest("/$CATEGORIES_ENDPOINT?\$limit=1&id=$id")
    }

    static List<Integer> getAllCategoryIDs(Response response) {
        response.jsonPath().getList("data.id")
    }
}
