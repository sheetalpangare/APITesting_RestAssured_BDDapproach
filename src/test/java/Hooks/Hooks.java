package Hooks;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Hooks {
	
	 public static RequestSpecification hooks_httpRequest;
	 
	 @Before
	    public void setup() {
	    			hooks_httpRequest = new RequestSpecBuilder()
	                .setBaseUri("https://userserviceapp-f5a54828541b.herokuapp.com/uap/")
	                .setAuth(RestAssured.basic("Numpy@gmail.com", "userapi@2025")) 
	                .setContentType("application/json")
	                .build();
	    }
}
