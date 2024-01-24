package datadriventesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Datadriven_AddEmployee {
	@Test(dataProvider="empdataprovider")
	void AddEmployee(String ename, String esal, String eage) {
		//open uri
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		//Create request object
		RequestSpecification httprequest=RestAssured.given();
		//Creating data which we can send along with post request
		JSONObject requestParams=new JSONObject();
		requestParams.put("name", "ename");
		requestParams.put("salary", "esal");
		requestParams.put("age", "eage");
		//Adding header stating that request body is json
		httprequest.header("Content-Type","application/json");
		//Add json to body of the request
		httprequest.body(requestParams.toJSONString());
		//Post request
		Response response=httprequest.request(Method.POST,"/create");
		//Capture response
		String res=response.getBody().asString();
		System.out.println("Response is: "+res);
		//Assert.assertEquals(res.contains("ename"), true);
		//Assert.assertEquals(res.contains("esal"), true);
		//Assert.assertEquals(res.contains("eage"), true);
		
		//Get status code
		int sc=response.getStatusCode();
		System.out.println("Status code is: "+sc);
		
		
		
	}
	//Get data from data provider method
	@DataProvider(name="empdataprovider")
	String[][] getempdata(){
		String empdata[][]= {{"Ginny","50000","54"},{"Kevin","60000","55"},{"Charlie","70000","59"}};
		return(empdata);
	}
}
