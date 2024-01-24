import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidatingJsonResponse {
	@Test
	void ValidateResponse() {
				//Get URI
				RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
				//Create request object
				RequestSpecification httprequest=RestAssured.given();
				//Create response object
				Response response=httprequest.request(Method.GET,"/Delhi");
				//Get string form of response from json
				String res=response.getBody().asString();
				System.out.print("Response body is: "+res);
				
				//validate json response
				Assert.assertEquals(res.contains("Delhi"), true);
		
	}

}
