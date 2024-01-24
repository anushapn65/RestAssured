import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GoogleAPIDemo {
	@Test
	void GoogleAPI() {
		RestAssured.baseURI="https://maps.googleapis.com";
		//Create request object
		RequestSpecification httprequest=RestAssured.given();
		//Create response object
		Response response=httprequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4IgTqSTOmHmJ2HoELb4Jy1s");
		//Get string form of response from json
		String res=response.getBody().asString();
		System.out.print("Response body is: "+res);
		
		//Get details of headers
		String contenttype=response.header("Content-type");
		System.out.println("Content type is:"+contenttype);
		Assert.assertEquals(contenttype, "application/xml; charset=UTF-8");
	}

}
