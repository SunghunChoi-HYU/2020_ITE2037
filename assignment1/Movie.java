package assignment;

public class Movie {
	private String Title;
	private int startTime;
	private int endTime;
	
	public Movie(String Title, int startTime, int endTime) {
		this.Title = Title;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getTitle() {
		return Title;
	}

	public void setMoiveName(String moiveName) {
		this.Title = moiveName;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public static void printMovieList(Movie[] movieList) {
		for(int i = 0; i < movieList.length; i++)
			System.out.println("제목 : " + movieList[i].getTitle() + " / 상영시간 : " + movieList[i].startTime + ":00 ~ " + movieList[i].endTime + ":00");
	}
}
