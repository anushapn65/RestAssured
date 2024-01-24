import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateAllResponse {
	@Test
	void ValidateAllResponse() {
		//Get URI
		RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
		//Create request object
		RequestSpecification httprequest=RestAssured.given();
		//Create response object
		Response response=httprequest.request(Method.GET,"/Delhi");
		//Get string form of response from json
		String res=response.getBody().asString();
		System.out.println("Response body is: "+res);
		
		//get all the responses
		JsonPath jsonpath=response.jsonPath();
		String city=jsonpath.get("City");
		System.out.println(city);
		String temp=jsonpath.get("Temperature");
		System.out.println(temp);
		String humidity=jsonpath.get("Humidity");
		System.out.println(humidity);
		String wd=jsonpath.get("WeatherDescription");
		System.out.println(wd);
		String ws=jsonpath.get("WindSpeed");
		System.out.println(ws);
		String wdd=jsonpath.get("WindDirectionDegree");
		System.out.println(wdd);
		
	}

}
