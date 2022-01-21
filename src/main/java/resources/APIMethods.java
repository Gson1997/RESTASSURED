package resources;

//Enum constants that stores the resource ID of the available APIs
public enum APIMethods {

	CreateBooking("/booking"), GetBooking("/booking"), UpdateBooking("/booking"), DeleteBooking("/booking");

	private String resourceid;

	APIMethods(String resourceid) {
		this.resourceid = resourceid;
	}

	public String getResourceid() {
		return resourceid;
	}

}
