package Ex1;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest {

	@Test
	 public void retrieveSpecificEmployee() {

	  String id = "16914";
	  RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee/" + id;

	  Response response = null;

	  try {
	   response = RestAssured.given()
	    .when()
	    .get();
	  } catch (Exception e) {
	   e.printStackTrace();
	  }

	  System.out.println("Response :" + response.asString());
	  System.out.println("Status Code :" + response.getStatusCode());
	  System.out.println("Does Reponse contains 'employee_salary'? :" + response.asString().contains("employee_salary"));


	  assertEquals(200, response.getStatusCode());
	 }

}
