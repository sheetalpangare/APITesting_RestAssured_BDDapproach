package StepDefinition;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserAPI {
	
	public int StatusCode;
	public RequestSpecification httpRequest;
	Response response;
	int ResponseCode;
	
	
	@Given("POST request with BaseURL and valid EndPoint")
	public void post_request_with_base_url_and_valid_end_point() {
		
		RestAssured.baseURI = ("https://userserviceapp-f5a54828541b.herokuapp.com/uap/");
		httpRequest = RestAssured.given().auth().preemptive().basic("Numpy@gmail.com", "userapi@2025");
	}

	@When("User creates POST request with valid details")
	public void user_creates_post_request_with_valid_details() throws IOException {
		
		String requestbody;
		
		requestbody = "{ \"userFirstName\": \"Tommy\", \"userLastName\": Jackson }";
		httpRequest.body(requestbody);
		response = httpRequest.post("createusers");
		response.prettyPrint();
	}

	@Then("User recives the response code as {int}")
	public void user_recives_the_response_code_as(Integer int1) {
		
		ResponseCode = response.getStatusCode();
		System.out.println("Response Code : " + ResponseCode);
		assertEquals(ResponseCode,201); 
	}
	
	@Given("user hit the url of get user API endpoint")
	public void i_hit_the_url_of_get_user_api_endpoint() {
		
		RestAssured.baseURI = ("https://userserviceapp-f5a54828541b.herokuapp.com/uap/");
		httpRequest = RestAssured.given().auth().preemptive().basic("Numpy@gmail.com", "userapi@2025");
	}

	@When("user pass the url of users in the request")
	public void i_pass_the_url_of_users_in_the_request() {
		
		 response = httpRequest.get("users");
		 response.prettyPrint();
	}

	@Then("user recive the response code as {int}")
	public void i_recive_the_response_code_as(Integer int1) {
		
		ResponseCode = response.getStatusCode();
		System.out.println("Response Code : " + ResponseCode);
		assertEquals(ResponseCode,200); 

	}



}
