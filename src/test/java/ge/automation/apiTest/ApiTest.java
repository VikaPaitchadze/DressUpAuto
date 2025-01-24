package ge.automation.apiTest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class ApiTest {

    @Test
    public void restApi() {


        RestAssured.baseURI = "https://reqres.in"; //base Url
        given()
                .when()
                .get("/api/users?page=2")
                .then()
                .statusCode(200)
                .log().all();
    }
}
