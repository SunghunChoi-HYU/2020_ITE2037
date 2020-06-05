package assignment;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Member {
	private String job; // 1이면 manager, 0이면 user
	private String ID;
	private String PW;
	
	private static Member[] allList = new Member[100];
	private static int numAll = 0;
	
	public Member(String job, String ID, String PW) {
		this.ID = ID;
		this.PW = PW;
		this.job = job;
	}
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}
	
	public Member(String ID, String PW) {
		this.ID = ID;
		this.PW = PW;
	}
	
	public static void newMember(String ID, String PW, String job) {
		Member newMember = new Member(ID, PW, job);
		allList[numAll++] = newMember;
	}
	
	public String toString() {
		return this.getJob() + " " + this.getID() + " " + this.getPW();
	}
	
	public static void MakeAccount() {
		String newID, newPW;
		int manager;
		Member newMember = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("******회원 가입******");
		System.out.print("ID : ");
		newID = (scan.nextLine());
		System.out.print("PW : ");
		newPW = (scan.nextLine());
		System.out.print("Are you manager? : ");
		manager = scan.nextInt();
		System.out.print("\n");
		if(manager == 1) {
			newMember = new Member("1",newID, newPW);
			Manager newManager = new Manager(newID, newPW);
		}
		else if(manager == 0) {
			newMember = new Member("0",newID, newPW);
			User newUser = new User(newID, newPW);
		}
		try {
			if(CheckUser(allList, newMember) != -1) {
				throw new DuplicatedIdException();
			}
			else {
				allList[numAll++] = newMember;
			}
		}
		catch(DuplicatedIdException e) {
			System.out.println(newID + " already exists.");
		}
	}
	
	public static Member Login() {
		String LoginID, LoginPW;
		Scanner scan = new Scanner(System.in);
		System.out.println("******로그인******");
		System.out.print("ID : ");
		LoginID = scan.nextLine();
		System.out.print("Password : ");
		LoginPW = scan.nextLine();
		Member LoginUser = new Member(LoginID, LoginPW);
		if(CheckUser(allList, LoginUser)!=-1)
			return LoginUser;
		else
			return null;
	}
	
	public static int CheckUser(Member[] allList, Member LoginUser) {
		int usernum = -1;
		if(numAll == 0)
			usernum = 0;
		
		else {
			for(int i = 0; i < numAll; i++) {
				if(LoginUser.getID().equals(allList[i].getID())) {
					usernum = i;
					break;
				}
			}
		}
		return usernum;
	}
	
	public static void getMemberList() {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream("MemberList.txt"));
		}
		catch(Exception e) {
			System.exit(0);
		}
		int inputUserNum = inputStream.nextInt();
		if(inputStream.hasNextLine()) {
			inputStream.nextLine();
			for(int i = 0; i < inputUserNum; i++) {
				String oneOfUser = inputStream.nextLine();
				String[] newUser = oneOfUser.split("\\s");
				Member member = new Member(newUser[0], newUser[1], newUser[2]);
				allList[numAll++] = member;
			}
		}
		inputStream.close();
	}
	
	public static void saveMember() {
		PrintWriter outputStream = null;
		
		try {
			outputStream = new PrintWriter(new FileOutputStream ("MemberList.txt"));
		}
		
		catch(FileNotFoundException e) {
			System.exit(0);
		}
		
		outputStream.println(numAll);
		String line = null;
		for(int i = 0; i < numAll; i++) {
			line = allList[i].toString();
			outputStream.println(line);
		}
		outputStream.close();
	}
}
