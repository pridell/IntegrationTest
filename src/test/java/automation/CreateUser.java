package automation;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.*;
import static org.hamcrest.Matchers.*;

public class CreateUser {
	
	@Test
	public void testCreateUser()
	{
		RestAssured.baseURI = "https://apisandbox.openbankproject.com";
		Response response = 
		
		RestAssured.given().
		body("{  \r\n" + 
				"\r\n" + 
				"\"email\":\"String\",  \r\n" + 
				"\"username\":\"String\",  \r\n" + 
				"\"password\":\"String\",  \r\n" + 
				"\"first_name\":\"String\",  \r\n" + 
				"\"last_name\":\"String\"\r\n" + 
				"\r\n" + 
				"}").
		when().post("/obp/v2.0.0/users").
		then().assertThat().statusCode(404).
		extract().response();
		System.out.println(response.asString());
		
	}

}
