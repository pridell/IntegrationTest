package automation;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.*;
import static org.hamcrest.Matchers.*;





public class GetBankBranches {
	@Test
	public void testgetBranches() {
	
	RestAssured.baseURI = "https://apisandbox.openbankproject.com";
	Response s=
	RestAssured.given().
	when().
	      get("/obp/v2.0.0/banks/bb.01.de/branches").
	then().
	assertThat().statusCode(200).and().statusLine("HTTP/1.1 200 OK").extract().response();
	System.out.println(s.asString());
	} 
	  

}


