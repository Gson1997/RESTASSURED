package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import pojoclasses.Booking;
import pojoclasses.Bookingdate;

public class Reusables {

	//creating payload for POST call
	public Booking createBookingPayload(String firstname, String lastname, String totalprice, String depositpaid,
			String checkin, String checkout, String additionalneeds) throws ParseException {
		Booking booking = new Booking();
		booking.setFirstname(firstname);
		booking.setLastname(lastname);
		booking.setTotalprice(Integer.parseInt(totalprice));
		booking.setDepositpaid(Boolean.parseBoolean(depositpaid));
		booking.setBookingdates(createBookingDate(checkin, checkout));
		booking.setAdditionalneeds(additionalneeds);
		return booking;
	}

	public Bookingdate createBookingDate(String checkin, String checkout) throws ParseException {
		Bookingdate date = new Bookingdate();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
		date.setCheckin(formatter.parse(checkin));
		date.setCheckout(formatter.parse(checkout));
		return date;
	}
}
