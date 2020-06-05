package assignment;

import java.util.Scanner;

public class Theater {
	
	public static void main(String args[]) {
		Movie.getMovieList();
		Member.getMemberList();
		Ticket.getTicketList();
		Member LoginUser;
		
		Scanner scan = new Scanner(System.in);
		int choice1, choice2, choice3, choice4;
		do {
			try {
				Ticket.MovieTicketingMain();
				choice1 = scan.nextInt();
				if(choice1 >= 4 || choice1 <= 0) {
					throw new InvalidMenuException(choice1);
				}
				
				else if(choice1 == 1) { //�α���
					try{
						LoginUser = Member.Login();
						if(LoginUser == null)
							throw new InvalidLoginException();
						else {
							do{
								try {
									User.userProgram();
									choice2 = scan.nextInt();
									if(choice2 >=5 || choice2 <=0)
										throw new InvalidMenuException(choice2);
									else if(choice2 == 1) { // ��ȭ���
										Movie.printMovieList();
										do {
											System.out.println("1. ����");
											System.out.println("2. ����");
											try {
												choice3 = scan.nextInt();
												if(choice3 >=3 || choice3 <= 0)
													throw new InvalidMenuException(choice3);
												else if(choice3 ==1) { //����
													Ticket.ticketing(LoginUser);
													choice2 = 5;
												}
												else if(choice3 ==2) { // ����
													choice2 = 5;
												}
											}
											catch(InvalidMenuException e) {
												System.out.println(e.getChoiceNum() + " is an invalid menu number.");
												choice3 = 3;
											}
										}while(choice3 >= 3 || choice3 <= 0);
									}
									else if(choice2 == 2) { // ���� Ȯ��
										choice2 = Ticket.checkTicketing(LoginUser);
										choice2 = 5;
									}
									else if(choice2 == 3) { // ��ȭ�� ����
										try {
											if(LoginUser.getJob() == "0")
												throw new InvalidMenuException();
											else {
												do {
													Manager.managing();
													choice4 = scan.nextInt();
													try {
														if(choice4 >=4 || choice4 <=0)
															throw new InvalidMenuException();
														else if(choice4 == 1) {
															Ticket.getInfo();
															choice4 =4;
														}
														else if(choice4 == 2) {
															System.out.print("ã������ �ϴ� ID : ");
															String skip = scan.nextLine();
															String reservationID = scan.nextLine();
															Ticket.FindReservationID(reservationID);
															choice4 = 4;
														}
														else if(choice4 == 3)
															choice2 = 5;
													}
													catch(InvalidMenuException e){
														System.out.println(choice4 + " is an invalid menu number.");
													}
												}while(choice4 >=4 || choice4 <=0);
											}
										}
										catch(InvalidMenuException e) {
											System.out.println("Invalid Access");
											choice2 = 5;
										}
									}
									}
								catch(InvalidMenuException e) {
									System.out.println(e.getChoiceNum() + " is an invalid menu number.");
									choice2 = 5;
								}
								
							}while(choice2 >=5 || choice2 <=0);
						}
					}
					catch(InvalidLoginException e){
						System.out.println("Login failed.");
					}
					choice1 = 4;
				}
				else if(choice1 == 2) { //ȸ������
					Member.MakeAccount();
					choice1 = 4;
				}
			}
			catch(InvalidMenuException e) {
				System.out.println(e.getChoiceNum() + " is an invalid menu number.");
				choice1 = 5;
			}
		}while(choice1 >=4 || choice1 <=0);
		
		Member.saveMember();
		Ticket.saveTicket();
	}
}
