package assignment;

public class Manager extends Member {
	private static Manager[] managerList = new Manager[100];
	private static int numManager = 0;
	
	public Manager(String ID, String PW) {
		super("1", ID, PW);
	}
	
	public static void managing() {
		System.out.println("********��ȭ�� ����********");
		System.out.println("1. ��ȭ�� ����");
		System.out.println("2. ���� ����");
		System.out.println("3. ����");
		System.out.print("�޴��� �������ּ��� : ");
	}
	
	public static void newManager(String ID, String PW) {
		Manager newManager = new Manager(ID, PW);
		managerList[numManager++] = newManager;
	}
}
