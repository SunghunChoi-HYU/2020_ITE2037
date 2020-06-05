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
		System.out.println("******���� ���α׷�******");
		System.out.println("1. ��ȭ ���");
		System.out.println("2. ���� Ȯ��");
		System.out.println("3. ��ȭ�� ����");
		System.out.println("4. ����");
		System.out.print("�޴��� �������ּ��� : ");
	}
}
