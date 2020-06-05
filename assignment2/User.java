package assignment;
import java.util.Scanner;

public class User extends Member{
	private static User[] userList = new User[100];
	private static int numUser = 0;
	
	public User(String ID, String PW) {
		super("0", ID, PW);
	}
	
	public static void newUser(String ID, String PW) {
		User newUser = new User(ID, PW);
		userList[numUser++] = newUser;
	}
	
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			User otherUser = (User)obj;
			return this.getID().equals(otherUser.getID()) && this.getPW().equals(otherUser.getPW());
		}
	}
	
	public static void userProgram() {
		System.out.println("******유저 프로그램******");
		System.out.println("1. 영화 목록");
		System.out.println("2. 예매 확인");
		System.out.println("3. 영화관 관리");
		System.out.println("4. 종료");
		System.out.print("메뉴를 선택해주세요 : ");
	}
}
