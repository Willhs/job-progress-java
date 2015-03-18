import java.awt.Graphics;
import java.time.LocalDate;
import java.time.Month;


/**
 * @author will
 * A graph to represent jobs over time
 * Displays time on x axis, jobs on y axis 
 */
public class JobTimeLine {
	
	private static final int WIDTH = 800;
	private static final int VERT_PADDING = 10;
	private static final int HOR_PADDING = 15;
	
	// start and end date currently visible
	private LocalDate 	start,
						end;
	
	
	public void scale(LocalDate start, LocalDate end){
		this.start = start;
		this.end = end;
	}
	
	public void draw(Job[] jobs, Graphics g){
		drawAxis(g);
	}

	private void drawAxis(Graphics g) {
		// line
		g.drawLine(HOR_PADDING, VERT_PADDING, HOR_PADDING + WIDTH, VERT_PADDING);
		
		// month ticks and text
		int monthVal = start.getMonthValue();
		
		// week ticks
		
	}
}
