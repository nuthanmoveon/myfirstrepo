package Steps;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetPostSteps {

	Response response;

	@Given("I perform GET operation for {string}")
	public void i_perform_GET_operation_for(String url) {
		given().contentType(ContentType.JSON);
	}

	@And("I perform GET for the post number {int}")
	public void i_perform_GET_for_the_post_number(Integer postNumber) {
		response=when().get(String.format("http://localhost:3000/posts/%s", postNumber));

	}

	@Then("I should see the author name as {string}")
	public void i_should_see_the_author_name_as(String authorName) {
		 
		//assertions
	
		org.junit.Assert.assertEquals(200, response.getStatusCode());
		org.junit.Assert.assertEquals(authorName, response.jsonPath().get("author"));
	}
}