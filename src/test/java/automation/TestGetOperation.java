package automation;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.GoogleApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TestGetOperation {
  @Test
  public void testget() {
	  
	  RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
	  
	  RequestSpecification request = RestAssured.given();
	  
	  Response response = request.get("/Hyderabad");
	  
	  //Printing the response on the console
	   System.out.println("Response " + response.getBody().asString());
	   
	   // getting all the Headers
	   
	   Headers headers = response.headers();
	   
	   for(Header allheadrer : headers )
	   {
		   System.out.println("Key: " + allheadrer.getName() + "Value: " + allheadrer.getValue());
	   }
	  
	  //  Evaluating element value using JSON path 
	   
	   JsonPath jsonPathEvaluator = response.jsonPath();
	   String city = jsonPathEvaluator.get("City");
	   System.out.println("City in Response Body : " + city );
	   Assert.assertEquals("Hyderabad", city);
	 //--------------------------------------
	 
	  
  }
}
