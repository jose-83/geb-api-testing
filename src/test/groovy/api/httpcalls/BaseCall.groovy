package api.httpcalls

import io.restassured.RestAssured
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification

abstract class BaseCall {
    private static final String BASE_API_URL = System.getProperty("api.env")

    protected static enum Endpoint {
        PRODUCTS, CATEGORIES
    }

    protected static RequestSpecification getDefaults() {
        RestAssured.baseURI = BASE_API_URL
        RequestSpecification request = RestAssured.given()
        return request
    }

    static Response getRequest(String path) {
        Response response = getDefaults().get(path)
        return response
    }
}
