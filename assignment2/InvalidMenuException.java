package assignment;

public class InvalidMenuException extends Exception {
	private int choiceNum;
	
	public InvalidMenuException(int num) {
		super(" is an invalid menu number.");
		choiceNum = num;
	}
	
	public InvalidMenuException() {
		super(" is an ivalid menu number.");
	}
	
	public InvalidMenuException(String message) {
		super(message);
	}
	
	public int getChoiceNum() {
		return choiceNum;
	}
}
