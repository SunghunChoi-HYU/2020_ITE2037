package assignment;

public class NotExistSeatException extends Exception{
	private String seat;
	
	public NotExistSeatException() {
		super(" does not exist.");
	}
	
	public NotExistSeatException(String message) {
		super(message);
	}
	
	public String getSeat() {
		return seat;
	}
}
