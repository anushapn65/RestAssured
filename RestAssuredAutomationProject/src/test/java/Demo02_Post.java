import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Demo02_Post {
		@Test
		void AddEmployee() {
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
			Response response=httprequest.request(Method.POST,"/create");
			//Capture response
			String res=response.getBody().asString();
			System.out.println("Response is: "+res);
			Assert.assertEquals(res.contains("John Grey"), true);
			Assert.assertEquals(res.contains("50000"), true);
			Assert.assertEquals(res.contains("60"), true);
			
			//Get status code
			int sc=response.getStatusCode();
			System.out.println("Status code is: "+sc);
		
	}

}
