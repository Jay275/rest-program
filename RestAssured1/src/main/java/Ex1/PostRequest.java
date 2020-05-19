package Ex1;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// An example of a POST request with JSON formatted data.
public class PostRequest {

    @Test
    public void createEmployee() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        String requestBody = "{\n" +
            "  \"name\": \"xyz\",\n" +
            "  \"salary\": \"5000\",\n" +
            "  \"age\": \"25\"\n" +
            "}";


        Response response = null;

        try {
            response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/create");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
        System.out.println("Does Reponse contains 'xyz'? :" + response.asString().contains("xyz"));


        assertEquals(200, response.getStatusCode());
    }
}