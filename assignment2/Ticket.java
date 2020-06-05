package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ticket extends User{
	private String row;
	private String col;
	private int movieNum;
	private static String [] rowList = {"A","B","C","D","E","F"};
	private static String [] seatSplit;
	private static Ticket[] allTicket;
	private static int numTicket = 0;
	
	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}
	
	public int getMovieNum() {
		return movieNum;
	}
	
	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}

	public Ticket(String ID, String PW, String row, String col, int movieNum) {
		super(ID, PW);
		this.row = row;
		this.col = col;
		this.movieNum = movieNum;
	}
	
	public String toString() {
		return this.getID() + "/" + this.getPW() + "/" + this.row + "/" + this.col + "/" +  this.movieNum; 
	}
	
	public static void MovieTicketingMain() {
		System.out.println("******영화 예매 프로그램******");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");
		System.out.print("메뉴를 선택해 주세요 : ");
		}
	
	public static int checkTicketing(Member loginUser) {
		Scanner scan = new Scanner(System.in);
		int ticketnum = 0;
		System.out.println("******예매 목록******");
		for(int i = 0; i < allTicket.length; i++) {
			if(allTicket[i] != null) {
				if(allTicket[i].getID().equals(loginUser.getID()) && allTicket[i].getPW().equals(loginUser.getPW())) {
					System.out.println("Ticket number : " + (i + 1) + " / " + Movie.MovieList[allTicket[i].movieNum].getTitle() + " / " + Movie.MovieList[allTicket[i].movieNum].getStartTime() +":00 ~ " + Movie.MovieList[allTicket[i].movieNum].getEndTime() + ":00 / Seat : " + allTicket[i].getRow() + allTicket[i].getCol());
					ticketnum++;
				}
			}
			else
				continue;
		}
			if(ticketnum == 0)
				System.out.println("예매한 영화가 존재하지 않습니다.");
			System.out.print("\nPress enter to go back to User Program");
			while(scan.nextLine() == "\r\n")
				break;
		ticketnum = 0;
		return 4;
	}
	
	public static Ticket[] ticketing(Member LoginUser) {
		int movieNum, check;
		String seat;
		boolean[][] checkseat = new boolean[6][6];
		Scanner scan = new Scanner(System.in);
		do {
			try {
				System.out.print("예매할 영화를 선택해주세요 : ");
				movieNum = scan.nextInt() - 1;
				scan.nextLine();
				if(movieNum < 1 || movieNum >= Movie.getNumOfMovie())
					throw new InvalidMenuException();
			}
			catch(InvalidMenuException e) {
				System.out.println("알맞지 않은 영화 번호입니다.");
				movieNum = Movie.getNumOfMovie()+1;
			}
		}while(movieNum >= Movie.getNumOfMovie() +1 || movieNum <= 0);
		do {
			check = 0;
			System.out.println("제목 : " + Movie.MovieList[movieNum].getTitle() + " / 상영시간 : " + Movie.MovieList[movieNum].getStartTime() + ":00 ~ " + Movie.MovieList[movieNum].getEndTime() + ":00");
			System.out.println("******좌석******");
			for(int i = 0; i < 6; i++) {
                System.out.print(rowList[i]);
                for(int j = 0; j < 6; j++) {
                    for(int k = 0; k < numTicket; k++) {
                        if (allTicket[k] != null) {
                            if (allTicket[k].movieNum == movieNum && allTicket[k].getRow().equals(rowList[i]) && allTicket[k].getCol().equals(String.valueOf(j + 1))) {
                                checkseat[i][j] = true;
                            }
                        }
                    }
                    if(checkseat[i][j] == true){
                        System.out.print("  X");
                    } else {
                        System.out.print("  O");
                    }
                }
                System.out.print("\n");
            }
			
			System.out.println("******");
			System.out.print("좌석을 선택해주세요 (ex.A1) : ");
			seat = scan.nextLine();
			seatSplit = seat.split("");
			try {
				if(!((seatSplit[0].equalsIgnoreCase("A")||seatSplit[0].equalsIgnoreCase("B")||seatSplit[0].equalsIgnoreCase("C")||seatSplit[0].equalsIgnoreCase("D")||seatSplit[0].equalsIgnoreCase("E")||seatSplit[0].equalsIgnoreCase("F"))&& (seatSplit[1].equalsIgnoreCase("1")||seatSplit[1].equalsIgnoreCase("2")||seatSplit[1].equalsIgnoreCase("3")||seatSplit[1].equalsIgnoreCase("4")||seatSplit[1].equalsIgnoreCase("5")||seatSplit[1].equalsIgnoreCase("6"))))
					throw new NotExistSeatException();
				for(int i = 0; i < numTicket; i++) {
					if(allTicket[i] != null) {
						if(allTicket[i].movieNum == movieNum && allTicket[i].getRow().equals(seatSplit[0]) && allTicket[i].getCol().equals(seatSplit[1])) {
							throw new DuplicatedReservationException();
						}
					}
				}
			}
			catch(NotExistSeatException e) {
				System.out.println(seat + " does not exist.");
				check = 1;
			}
			catch(DuplicatedReservationException e) {
				System.out.println(seat + " is already reserved.");
				check = 1;
			}
			if(check == 0) {
				Ticket newTicket = new Ticket(LoginUser.getID(), LoginUser.getPW(), seatSplit[0], seatSplit[1], movieNum);
				allTicket[numTicket++] = newTicket;
				Movie.MovieList[movieNum].setReservationNum(Movie.MovieList[movieNum].getReservationNum()+1);
			}
		}while(check == 1);
		
		return allTicket;
	}
	
	public static void getTicketList() {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream("TicketList.txt"));
		}
		catch(Exception e) {
			System.exit(0);
		}
		int inputTicketNum = inputStream.nextInt(); 
		allTicket = new Ticket[100];
		if(inputStream.hasNextLine()) {
			inputStream.nextLine();
			for(int i = 0; i < inputTicketNum; i++) {
				String oneOfTicket = inputStream.nextLine();
				String[] newTicket = oneOfTicket.split("/");
				Ticket tickets = new Ticket(newTicket[0], newTicket[1], newTicket[2], newTicket[3], Integer.parseInt(newTicket[4]));
				allTicket[numTicket++] = tickets;
				for(int j = 0; j < Movie.MovieList.length; j++) {
					if(j == Integer.parseInt(newTicket[4]))
						Movie.MovieList[j].setReservationNum(Movie.MovieList[j].getReservationNum()+1);
				}
			}
		}
		inputStream.close();
}
	
	public static void saveTicket() {
		PrintWriter outputStream = null;
		
		try {
			outputStream = new PrintWriter(new FileOutputStream("TicketList.txt"));
		}
		catch(FileNotFoundException e) {
			System.exit(0);
		}
		
		outputStream.println(numTicket);
		String line = null;
		for(int i = 0; i < numTicket; i++) {
			line = allTicket[i].toString();
			outputStream.println(line);
		}
		outputStream.close();
	}
	
	public static void FindReservationID(String ID) {
		int numTicketbyUser =0 ;
		for(int i = 0; i < numTicket; i++) {
			if(ID.equals(allTicket[i].getID()))
				numTicketbyUser++;
		}
		System.out.println(ID + "고객님이 발행한 티켓 수 : " + numTicketbyUser);
		System.out.println("_________________________________");
		if(numTicketbyUser != 0) {
			for (int i = 0; i < numTicket; i++) {
				if(ID.equals(allTicket[i].getID()))
						System.out.println("Ticket number : " + (i + 1) + " / " + Movie.MovieList[allTicket[i].movieNum].getTitle() + " / " + Movie.MovieList[allTicket[i].movieNum].getStartTime() +":00 ~ " + Movie.MovieList[allTicket[i].movieNum].getEndTime() + ":00 / Seat : " + allTicket[i].getRow() + allTicket[i].getCol());
			}
		}
		System.out.println("_________________________________");
	}
	
	public static void getInfo() {
		System.out.println("점유된 전체 좌석 수 : " + numTicket);
		System.out.printf("전체좌석 예매 점유율 : %.2f", (double)((numTicket*100)/(36*Movie.MovieList.length)));
		System.out.println("%");
		System.out.println("영화관 총 매출액 : " + numTicket * 10000);
		System.out.print("\n");
		System.out.println("예매율 현황");
		System.out.println("_________________________________");
		for(int i = 0; i < 3; i++) {
			System.out.println(i+1 + "위 : " + Ticket.FindMoive(i+1).getTitle() + "(좌석수 : " + Ticket.FindMoive(i+1).getReservationNum() + ")");
		}
		Ticket.backtoOriginal();
	}
	
	public static Movie FindMoive(int rank) {
		Movie[] MovieRank = Movie.MovieList;
		for(int i =0; i < MovieRank.length-1; i++) {
			int temp = 1;
			for(int j = i+1; j<MovieRank.length; j++) {
				if(MovieRank[temp].getReservationNum() >= Movie.MovieList[j].getReservationNum())
					temp = j;
				else {
					Movie swaptemp = MovieRank[j];
					MovieRank[j] = MovieRank[i];
					MovieRank[i] = swaptemp;
					
			}
		}
	}	
		return MovieRank[rank-1];
	}
	
	public static Movie[] backtoOriginal() {
		Movie[] MovieListOriginal = Movie.MovieList;
		for(int i =0; i < MovieListOriginal.length-1; i++) {
			int temp = 1;
			for(int j = i+1; j<MovieListOriginal.length; j++) {
				if(MovieListOriginal[temp].getReservationNum() >= Movie.MovieList[j].getReservationNum())
					temp = j;
				else {
					Movie swaptemp = MovieListOriginal[j];
					MovieListOriginal[j] = MovieListOriginal[i];
					MovieListOriginal[i] = swaptemp;
					
			}
		}
	}	
		return MovieListOriginal;
	}
}