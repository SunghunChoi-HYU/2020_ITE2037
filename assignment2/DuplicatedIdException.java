package assignment;

public class DuplicatedIdException extends Exception {
	private String ID;
	
	public DuplicatedIdException() {
		super(" already exists.");
	}
	
	public DuplicatedIdException(String message) {
		super(message);
	}
	
	public String getID(){
		return ID;
	}
}
