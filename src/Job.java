import java.awt.Color;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;


public class Job {

	private LocalDate start;
	private LocalDate end;
	private String title;
	private Period period;
	private double progress; // 0 to 1
	private Color colour;
	
	public Job(String title, LocalDate start, LocalDate end) {
		this.start = start;
		this.end = end;
		this.title = title;
		this.progress = 0; // no progress by default
		//this.period = Period.between(start, end);
		this.period = start.until(end);
		this.colour = randomColour();
		
		//TODO: have user set this
		this.progress = Math.random();
	}	

	public Period getPeriod(){
		return period;
	}
	
	public double getProgress(){
		return progress;
	}
	
	public LocalDate getStart(){
		return start;
	}
	
	public LocalDate getEnd(){
		return end;
	}
	
	public void setProgress(double progress){
		this.progress = progress;
	}
	
	public String getTitle(){
		return title;
	}
	
	private Color randomColour() {
		Random ran = new Random();
		int maxGreen = 150;
		int maxBlue = 150;
		int r = ran.nextInt(256);
		int g = ran.nextInt(maxGreen);
		int b = ran.nextInt(maxBlue);
		
		return new Color(r,g,b);
	}
	
	public Color getColour(){
		return colour;
	}
	
	public String toString(){
		return "JOB: " + title;
	}
}
