import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo01_GetRequest {
	@Test
	void getWeatherDetails() {
		//Get URI
		RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
		//Create request object
		RequestSpecification httprequest=RestAssured.given();
		//Create response object
		Response response=httprequest.request(Method.GET,"/delhi");
		//Get string form of response from json
		String res=response.getBody().asString();
		System.out.print("Response body is: "+res);
		//Get status code
		int statuscode=response.getStatusCode();
		System.out.print("Status code is: "+statuscode);
		Assert.assertEquals(statuscode, 200);
		//Get status line
		String statusLine=response.getStatusLine();
		//System.out.println("Status line is: ",+statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
	}

}
