package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import resources.APIMethods;
import specifications.Testutility;
import utilities.Reusables;

import static io.restassured.RestAssured.*;

import java.text.ParseException;

public class Restfulbooker extends Testutility {

	RequestSpecification request;
	Response response;
	public static int bookingid;
	JsonPath js;

	@Given("I create the request body with {string} {string} {string} {string} {string} {string} {string}")
	public void i_create_the_request_body_with(String firstname, String lastname, String totalprice, String depositpaid,
			String checkin, String checkout, String additionalneeds) throws ParseException {

		request = given().spec(getRequestSpec()).body(new Reusables().createBookingPayload(firstname, lastname,
				totalprice, depositpaid, checkin, checkout, additionalneeds));

	}

	@When("I hit {string} API using {string} method")
	public void i_hit_api_using_method(String resourceid, String method) {
		APIMethods resource = APIMethods.valueOf(resourceid);
		if (method.equals("POST")) {
			response = request.when().post(resource.getResourceid());
			js = getJsonObject(response);
			bookingid = js.getInt("bookingid");
		} else if (method.equals("GET")) {
			response = request.when().get(resource.getResourceid() + "/{id}");
		} else if (method.equals("PUT")) {
			response = request.when().put(resource.getResourceid() + "/{id}");
		} else {
			response=request.when().delete(resource.getResourceid() + "/{id}");
		}

	}

	@Then("I validate the status code with {string}")
	public void i_validate_the_status_code_with(String statuscode) {
		Assert.assertEquals(response.getStatusCode(), Integer.parseInt(statuscode));
	}

	@Then("validate whether {string} in the response is the same as {string}")
	public void validate_whether_in_the_response_is_the_same_as(String expectedkey, String Actual) {
		js = getJsonObject(response);
		Assert.assertEquals(js.get("booking." + expectedkey), Actual);
	}

	@Given("I create {string} request with placeID")
	public void i_create_request_with_place_id(String method) {
		if (method.equals("GET")) {
			request = given().spec(getRequestSpec()).pathParam("id", bookingid);
			request.log().all();
		}
		else if (method.equals("PUT")) {
			request = request.pathParam("id", bookingid);
		    request = new Testutility().setAuthorisation(request);
		    request.log().all();
	}
		else {
			request = given().spec(getRequestSpec()).pathParam("id", bookingid);
		    request = new Testutility().setAuthorisation(request);
		    request.log().all();
		}
	}
}
