package StepDefinition;

import static org.testng.Assert.assertEquals;
import org.json.JSONObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {
	
	public int StatusCode;
	public RequestSpecification httpRequest;
	Response response;
	int ResponseCode;
	
	@Given("user hit the url of put user API endpoint")
	public void user_hit_the_url_of_put_user_api_endpoint() {
		
		RestAssured.baseURI = ("https://userserviceapp-f5a54828541b.herokuapp.com/uap/");
		httpRequest = RestAssured.given().auth().preemptive().basic("Numpy@gmail.com", "userapi@2025");
	    
	}

	@When("user pass the url with new values for all fiels of users with UserId in the request")
	public void user_pass_the_url_with_new_values_for_all_fiels_of_users_with_user_id_in_the_request() {
		
		JSONObject requestParams=new JSONObject();
        
		 requestParams.put("userFirstName","David");
		 requestParams.put("userLastName","Jackson1");
		 requestParams.put("userContactNumber","9910019544");
		 requestParams.put("userEmailId","team09P@gmail.com");                        
		                  
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toString());                       
		
		Response response=httpRequest.put("updateuser");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:"+responseBody);
	   
	}

	@Then("user recive the response code as {int} for put operation")
	public void user_recive_the_response_code_as_for_put_operation(Integer int1) {
		
		ResponseCode = response.getStatusCode();
		System.out.println("Response Code : " + ResponseCode);
		assertEquals(ResponseCode,200); 
	   
	}


}
