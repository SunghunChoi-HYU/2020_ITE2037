package assignment;

public class Manager extends Member {
	private static Manager[] managerList = new Manager[100];
	private static int numManager = 0;
	
	public Manager(String ID, String PW) {
		super("1", ID, PW);
	}
	
	public static void managing() {
		System.out.println("********영화관 관리********");
		System.out.println("1. 영화관 정보");
		System.out.println("2. 유저 정보");
		System.out.println("3. 종료");
		System.out.print("메뉴를 선택해주세요 : ");
	}
	
	public static void newManager(String ID, String PW) {
		Manager newManager = new Manager(ID, PW);
		managerList[numManager++] = newManager;
	}
}
