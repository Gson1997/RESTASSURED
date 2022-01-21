package hooks;

import java.text.ParseException;

import io.cucumber.java.Before;
import stepdefinitions.Restfulbooker;

//To test GET/PUT/DELETE API independently without executing POST API
public class Hooks {

	@Before("@GET or @PUT or @DELETE")

	public void createBooking() throws ParseException {
		if (Restfulbooker.bookingid == 0) {
			Restfulbooker booking = new Restfulbooker();
			booking.i_create_the_request_body_with("Murali", "Murali", "100", "true", "2020-01-01", "2019-01-01",
					"yes");
			booking.i_hit_api_using_method("CreateBooking", "POST");
		}
	}

}
