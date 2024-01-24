import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredAuthentication {
	@Test
	void Authentication() {
		RestAssured .baseURI="https://postman-echo.com/basic-auth";
		
		//Basic Authentication
		PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
		authscheme.setUserName("postman");
		authscheme.setPassword("password");
		
		RestAssured.authentication=authscheme;
		
		RequestSpecification httpurl=RestAssured.given(); //Request object
		Response response=httpurl.request(Method.GET,"/"); //Response object
		
		//print response
		String res=response.getBody().asString();
		System.out.println("Response is: "+res);
	}

}
