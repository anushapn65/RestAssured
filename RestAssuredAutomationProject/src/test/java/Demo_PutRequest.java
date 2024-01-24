import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo_PutRequest {
	@Test
	void UpdateEmployeeDetails() {
		//open uri
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		//Create request object
		RequestSpecification httprequest=RestAssured.given();
		//Creating data which we can send along with post request
		JSONObject requestParams=new JSONObject();
		requestParams.put("name", "John Grey");
		requestParams.put("salary", "50000");
		requestParams.put("age", "60");
		//Adding header stating that request body is json
		httprequest.header("Content-Type","application/json");
		//Add json to body of the request
		httprequest.body(requestParams.toJSONString());
		//Post request
		Response response=httprequest.request(Method.PUT,"/update/7430");
		//Capture response
		String res=response.getBody().asString();
		System.out.println("Response is: "+res);
		
		
		//Get status code
		int sc=response.getStatusCode();
		System.out.println("Status code is: "+sc);
	}

}
