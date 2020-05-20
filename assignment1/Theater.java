package assignment;

import java.util.Scanner;

public class Theater {
	
	public static void main(String args[]) {
		Movie[] MovieList = new Movie[8];
		MovieList[0] = new Movie("기생충", 0, 3);
		MovieList[1] = new Movie("감기", 3, 6);
		MovieList[2] = new Movie("해리포터", 6, 9);
		MovieList[3] = new Movie("라라랜드", 9, 12);
		MovieList[4] = new Movie("겨울왕국", 12, 15);
		MovieList[5] = new Movie("명탐정 코난", 15, 18);
		MovieList[6] = new Movie("어벤져스", 18, 21);
		MovieList[7] = new Movie("국제시장", 21, 24);
		
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
				System.out.println("회원가입이 되어 있지 않거나, 아이디 또는 비밀번호가 틀립니다.");
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
						System.out.println("\n1. 예매");
						System.out.println("2. 종료");
						System.out.print("메뉴를 선택해주세요 : ");
						choice3 = scan.nextInt();
						
						if(choice3 == 1) { //예매
							Ticket.ticketing(LoginUser, ticketList, MovieList);
							choice2 = 4;
						}
						else if(choice3 == 2) {
							choice2 = 4;
							continue;
						}
						}while(choice3 > 2);
					}
					
					else if(choice2 == 2) // 예매확인
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
			System.out.println("영화 예매 프로그램을 종료합니다.");
	}
}
