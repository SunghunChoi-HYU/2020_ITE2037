package assignment;

import java.util.Scanner;

public class Theater {
	
	public static void main(String args[]) {
		Movie[] MovieList = new Movie[8];
		MovieList[0] = new Movie("�����", 0, 3);
		MovieList[1] = new Movie("����", 3, 6);
		MovieList[2] = new Movie("�ظ�����", 6, 9);
		MovieList[3] = new Movie("��󷣵�", 9, 12);
		MovieList[4] = new Movie("�ܿ�ձ�", 12, 15);
		MovieList[5] = new Movie("��Ž�� �ڳ�", 15, 18);
		MovieList[6] = new Movie("�����", 18, 21);
		MovieList[7] = new Movie("��������", 21, 24);
		
		Ticket[] ticketList = new Ticket[300];
		User LoginUser;
		
		Scanner scan = new Scanner(System.in);
		int choice1, choice2, choice3;
		do {
		Ticket.MovieTicketingMain();
		choice1 = scan.nextInt();
		if(choice1 == 1) {
			LoginUser = User.Login();
			if(LoginUser == null) {
				System.out.println("ȸ�������� �Ǿ� ���� �ʰų�, ���̵� �Ǵ� ��й�ȣ�� Ʋ���ϴ�.");
				choice1 = 4;
				continue;
			}
			else
				do {
					User.userProgram();
					choice2 = scan.nextInt();
					if(choice2 == 1) {
						do {
						Movie.printMovieList(MovieList);
						System.out.println("\n1. ����");
						System.out.println("2. ����");
						System.out.print("�޴��� �������ּ��� : ");
						choice3 = scan.nextInt();
						
						if(choice3 == 1) { //����
							Ticket.ticketing(LoginUser, ticketList, MovieList);
							choice2 = 4;
						}
						else if(choice3 == 2) {
							choice2 = 4;
							continue;
						}
						}while(choice3 > 2);
					}
					
					else if(choice2 == 2) // ����Ȯ��
						choice2 = Ticket.checkTicketing(LoginUser, ticketList, MovieList);
				}while(choice2 > 3);
			if(choice2 == 3)
				choice1 = 4;
				continue;
		}
		else if(choice1 == 2) {
			User.MakeAccount();
			choice1 = 4;
			}
		continue;
		}while(choice1 > 3);
		
		if(choice1 == 3)
			System.out.println("��ȭ ���� ���α׷��� �����մϴ�.");
	}
}
