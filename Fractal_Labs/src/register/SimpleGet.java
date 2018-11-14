package register;

import java.util.Map;
import java.util.TreeMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleGet {
	 private String empty;

	@Test
	 public void GetWeatherDetails()
	 {   
	 // Specify the base URL to the RESTful web service
	 RestAssured.baseURI = "https://partnerapi.fractal-dev.co.uk/banking/v1/accounts/10";
	 
	 // Get the RequestSpecification of the request that you want to sent
	 // to the server. The server is specified by the BaseURI that we have
	 // specified in the above step.
	 RequestSpecification httpRequest = RestAssured.given();
	 
	 TreeMap<String, String> awsHeaders = new TreeMap<String, String>();
     awsHeaders.put("host", "https://partnerapi.fractal-dev.co.uk");
     
     
	
     
     AWSV4Auth aWSV4Auth = new AWSV4Auth.Builder("AKIAIOHB7FZM5QMB3YEQ", "97b0QGr8g/GWTWumXJi7SIGYj1kHGzixmSGAAc4F")
                                        .regionName("eu-west-1")
                                        .serviceName("execute-api") // es - elastic search. use your service name
                                        .httpMethodName("GET") //GET, PUT, POST, DELETE, etc...
                                        .canonicalURI("/banking/v1/accounts/10") //end point
                                        .queryParametes(null) //query parameters if any
                                        .awsHeaders(awsHeaders) //aws header parameters
                                        .payload(null) // payload if any
                                        .debug() // turn on the debug mode
                                        .build();																										
     
     /* Get headers calculated for request */

     Map<String, String> header = aWSV4Auth.getHeaders();
     for (Map.Entry<String, String> entrySet : header.entrySet()) {
         String key = entrySet.getKey();
         String value = entrySet.getValue();

         httpRequest.header(key, value);
     }
	 // Make a request to the server by specifying the method Type and the method URL.
	 // This will return the Response from the server. Store the response in a variable.
	 Response response = httpRequest.request(Method.GET, "/banking/v1/accounts/10");
	 
	 // Now let us print the body of the message to see what response
	 // we have recieved from the server
	 String responseBody = response.getBody().asString();
	 System.out.println("Response Body is =>  " + responseBody);
	 
	//  AWS4-HMAC-SHA256 Credential=AKIAIOHB7FZM5QMB3YEQ/20181114/eu-west-1/execute-api/aws4_request, SignedHeaders=cache-control;content-type;host;postman-token;x-amz-date, Signature=d0e39db55806a47bcef9073617f92a73766414753dcd69a3557397232360641a
 
	 
	 }

}
