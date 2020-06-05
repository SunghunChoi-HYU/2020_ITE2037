package assignment;

public class DuplicatedReservationException extends Exception{
	private String seat;
	
	public DuplicatedReservationException() {
		super(" is already reserved.");
	}
	
	public DuplicatedReservationException(String message) {
		super(message);
	}
	
	public String getSeat() {
		return seat;
	}
}
