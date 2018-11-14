package register;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OMDbApi2 {
	@Test
	public void GetOMDbDetails()
	 {
		 RestAssured.baseURI = "http://www.omdbapi.com/?t=top&plot=short&apikey=26217a88";
		 RequestSpecification httpRequest = RestAssured.given();

		 RestAssured.given()
		 .when()
		 .get()
		 .then()
		 .assertThat()
		 .statusCode(200);
		 
		 Response response = httpRequest.request(Method.GET, "/?t=top&plot=short&apikey=26217a88");
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);
			Assert.assertEquals(responseBody.contains("Top Gun"), true , "Response body contains Top Gun");


	 }
}
