package StepDefinition;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete {
	
	public int StatusCode;
	public RequestSpecification httpRequest;
	Response response;
	int ResponseCode;
	
	@Given("user hit the url of delete user API endpoint")
	public void user_hit_the_url_of_delete_user_api_endpoint() {
		
		RestAssured.baseURI = ("https://userserviceapp-f5a54828541b.herokuapp.com/uap/");
		httpRequest = RestAssured.given().auth().preemptive().basic("Numpy@gmail.com", "userapi@2025");
	   
	}

	@When("user pass the url with UserId in the request")
	public void user_pass_the_url_with_user_id_in_the_request() {
		
		JSONObject requestParams=new JSONObject();
        
		requestParams.put("userid",24394);
		                         
		httpRequest.header("Content-Type","application/json");
		                  
		httpRequest.body(requestParams.toString());                       
		
		Response response=httpRequest.delete("deleteuser");
		String responseBody=response.getBody().asString();
		
		System.out.println("Response Body is:"+responseBody);
	
	}

	@Then("user recive the response code as {int} for delete operation")
	public void user_recive_the_response_code_as_for_delete_operation(Integer int1) {
		
		ResponseCode = response.getStatusCode();
		System.out.println("Response Code : " + ResponseCode);
		assertEquals(ResponseCode,200); 
	 
	}

}
