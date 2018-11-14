package register;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class BankApi {
	@Test
	 public void BankAPIDetails() throws IOException
	 {
		 RestAssured.baseURI = "https://partnerapi.fractal-dev.co.uk/banking/v1/accounts/10";
		 RestAssured.given().auth().preemptive().basic("AKIAIOHB7FZM5QMB3YEQ", "97b0QGr8g/GWTWumXJi7SIGYj1kHGzixmSGAAc4F")
	        .get()
	        .then()
	        .assertThat().statusCode(200);

}
}