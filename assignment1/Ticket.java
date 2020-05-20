package assignment;
import java.util.Scanner;

public class Ticket extends User{
	private String row;
	private String col;
	private int movieNum;
	private static String [] rowList = {"A","B","C","D","E","F"};
	private static String [] seatSplit;
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

	public Ticket(String ID, String PW, String row, String col, int movieNum) {
		super(ID, PW);
		this.row = row;
		this.col = col;
		this.movieNum = movieNum;
	}
	
	public static void MovieTicketingMain() {
		System.out.println("******��ȭ ���� ���α׷�******");
		System.out.println("1. �α���");
		System.out.println("2. ȸ������");
		System.out.println("3. ����");
		System.out.print("�޴��� ������ �ּ��� : ");
		}
	
	public static int checkTicketing(User LoginUser, Ticket[] Ticketlist, Movie[] MovieList) {
		Scanner scan = new Scanner(System.in);
		int ticketnum = 0;
		System.out.println("******���� ���******");
		for(int i = 0; i < Ticketlist.length; i++) {
			if(Ticketlist[i] != null) {
				if(Ticketlist[i].getID().equals(LoginUser.getID()) && Ticketlist[i].getPW().equals(LoginUser.getPW())) {
					System.out.println("Ticket number : " + (i + 1) + " / " + MovieList[Ticketlist[i].movieNum].getTitle() + " / " + MovieList[Ticketlist[i].movieNum].getStartTime() +":00 ~ " + MovieList[Ticketlist[i].movieNum].getEndTime() + ":00 / Seat : " + Ticketlist[i].getRow() + Ticketlist[i].getCol());
					ticketnum++;
				}
			}
			else
				continue;
		}
			if(ticketnum == 0)
				System.out.println("������ ��ȭ�� �������� �ʽ��ϴ�.");
			System.out.print("\nPress enter to go back to User Program");
			while(scan.nextLine() == "\r\n")
				break;
		ticketnum = 0;
		return 4;
	}
	
	public static Ticket[] ticketing(User LoginUser, Ticket[] Ticketlist, Movie[] MovieList) {
		int movieNum;
		int check = 0;
		String seat;
		boolean[][] checkseat = new boolean[6][6];
		Scanner scan = new Scanner(System.in);
		System.out.print("������ ��ȭ�� �������ּ��� : ");
		movieNum = scan.nextInt() - 1;
		scan.nextLine();
		do {
			System.out.println("���� : " + MovieList[movieNum].getTitle() + " / �󿵽ð� : " + MovieList[movieNum].getStartTime() + ":00 ~ " + MovieList[movieNum].getEndTime() + ":00");
			System.out.println("******�¼�******");
			for(int i = 0; i < 6; i++) {
                System.out.print(rowList[i]);
                for(int j = 0; j < 6; j++) {
                    for(int k = 0; k < numTicket; k++) {
                        if (Ticketlist[k] != null) {
                            if (Ticketlist[k].movieNum == movieNum && Ticketlist[k].getRow().equals(rowList[i]) && Ticketlist[k].getCol().equals(String.valueOf(j + 1))) {
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
			System.out.print("�¼��� �������ּ��� (ex.A1) : ");
			seat = scan.nextLine();
			seatSplit = seat.split("");
			for(int i = 0; i <= numTicket; i++) {
				if(Ticketlist[i] != null) {
					if(Ticketlist[i].movieNum == movieNum && Ticketlist[i].getRow().equals(seatSplit[0]) && Ticketlist[i].getCol().equals(seatSplit[1])) {
						System.out.println("�̹� ���ŵǾ� �ִ� �¼��Դϴ�. �ٽ� ���� ���α׷����� ���ư��ϴ�");
						check = 1;
						break;
					}
				}
			}
			if(check == 0) {
				Ticket newTicket = new Ticket(LoginUser.getID(), LoginUser.getPW(), seatSplit[0], seatSplit[1], movieNum);
				Ticketlist[numTicket++] = newTicket;
				check = 0;
			}
			check = 0;
		}while(check == 1);
		
		return Ticketlist;
	}
}