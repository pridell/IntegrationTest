package automation;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestPostOperation {
  @SuppressWarnings("unchecked")
@Test
  public void testpost() {
	  
	  // Testing post method
	  
	  RestAssured.baseURI = "http://restapi.demoqa.com/customer"; 
	  RequestSpecification request = RestAssured.given();
	  
	  JSONObject requestParams = new JSONObject();
	  
	  requestParams.put("FirstName", "Priyam"); // Cast
	  requestParams.put("LastName", "Garg");
	   
	  requestParams.put("UserName", "simpleuser001");
	  requestParams.put("Password", "password1");
	  requestParams.put("Email",  "someuser@gmail.com");
	  
	 request.header("Content-Type", "application/json");
	 request.body(requestParams.toJSONString());
	 
	 Response response = request.post("/register");
	 
	 int status = response.getStatusCode();
	 System.out.println("HTTP Status Code : " + status );
	 System.out.println("HTTP Status Text:  " + response.getStatusLine() );
	  
  }
}
