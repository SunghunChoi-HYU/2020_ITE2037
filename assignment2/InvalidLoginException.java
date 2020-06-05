package assignment;

public class InvalidLoginException extends Exception{
	public InvalidLoginException() {
		super("Login failed");
	}
	
	public InvalidLoginException(String message) {
		super(message);
	}
}
