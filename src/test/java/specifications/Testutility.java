package specifications;

import java.io.IOException;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Property;

public class Testutility {

	public static RequestSpecification requestdetails;//request details is a templated that will be used across all the APIs
	
	//This mechanism is declared within static block as it is required to perform this operation only once at the start of the test
	static {
		try {
			requestdetails = new RequestSpecBuilder().setBaseUri(new Property().getProperty("baseURI"))
					.setContentType("application/json").build();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public RequestSpecification getRequestSpec() {
		return requestdetails;
	}

	//To set authorisation details for PUT and DELETE APIs
	public RequestSpecification setAuthorisation(RequestSpecification request) {
		return request.header("Cookie", "token=abc123");
	}

	//fetches JSONobject from the response
	public JsonPath getJsonObject(Response response) {
		return (response.jsonPath());
	}
}
