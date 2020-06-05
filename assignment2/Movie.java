package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Movie {
	private String Title;
	private String startTime;
	private String endTime;
	private int reservationNum;
	
	protected static Movie[] MovieList;
	private static int numOfMovie = 0;
	
	public Movie(String Title, String startTime, String endTime) {
		this.Title = Title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.reservationNum = 0;
	}

	public String getTitle() {
		return Title;
	}

	public void setMoiveName(String moiveName) {
		this.Title = moiveName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	

	public int getReservationNum() {
		return reservationNum;
	}

	public void setReservationNum(int reservationNum) {
		this.reservationNum = reservationNum;
	}
	
	public static int getNumOfMovie() {
		return numOfMovie;
	}

	public static void printMovieList() {
		for(int i = 0; i < MovieList.length; i++)
			System.out.println("제목 : " + MovieList[i].getTitle() + " / 상영시간 : " + MovieList[i].startTime + ":00 ~ " + MovieList[i].endTime + ":00");

	}
	
	public static void getMovieList() {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream("MovieList.txt"));
		}
		catch(Exception e) {
			System.exit(0);
		}
		int inputMovieNum = inputStream.nextInt(); 
		Movie.MovieList = new Movie[inputMovieNum];
		if(inputStream.hasNextLine()) {
			inputStream.nextLine();
			for(int i = 0; i < inputMovieNum; i++) {
				String oneOfMovie = inputStream.nextLine();
				String[] newmovie = oneOfMovie.split("/");
				Movie movies = new Movie(newmovie[0], newmovie[1], newmovie[2]);
				Movie.MovieList[numOfMovie++] = movies;
			}
		}
		inputStream.close();
	}
}
