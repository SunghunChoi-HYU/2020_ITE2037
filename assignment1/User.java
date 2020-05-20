package assignment;
import java.util.Scanner;

public class User {
	private String ID, PW;
	private static User[] userList = new User[100];
	private static int numUser = 0;
	
	public User(String ID, String PW) {
		this.ID = ID;
		this.PW = PW;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String PW) {
		this.PW = PW;
	}
	
	public static User Login() {
		String LoginID, LoginPW;
		Scanner scan = new Scanner(System.in);
		System.out.println("******로그인******");
		System.out.print("ID : ");
		LoginID = scan.nextLine();
		System.out.print("Password : ");
		LoginPW = scan.nextLine();
		User LoginUser = new User(LoginID, LoginPW);
		if(CheckUser(userList, LoginUser)!=-1)
			return LoginUser;
		else
			return null;
	}
	
	public static void MakeAccount() {
		String newID, newPW;
		Scanner scan = new Scanner(System.in);
		System.out.println("******회원 가입******");
		System.out.print("ID : ");
		newID = (scan.nextLine());
		System.out.print("PW : ");
		newPW = (scan.nextLine());
		userList[numUser++] = new User(newID, newPW);
	}
	
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else {
			User otherUser = (User)obj;
			return this.ID.equals(otherUser.ID) && this.PW.equals(otherUser.PW);
		}
	}
	
	public static int CheckUser(User[] userList, User LoginUser) {
		int usernum = -1;
		for(int i = 0; i < userList.length; i++) {
			if(LoginUser.equals(userList[i]))
				usernum = i;
		}
		return usernum;
	}
	
	public static void userProgram() {
		System.out.println("******유저 프로그램******");
		System.out.println("1. 영화 목록");
		System.out.println("2. 예매 확인");
		System.out.println("3. 종료");
		System.out.print("메뉴를 선택해주세요 : ");
	}
}
