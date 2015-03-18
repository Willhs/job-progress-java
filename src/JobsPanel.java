import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;
import java.time.Period;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class JobsPanel extends JPanel{

	private static final int BAR_HEIGHT = 50;
	private static final int OUTER_PADDING = 30;
	private static final int BETWEEN_BAR_PADDING = 0;

	private List<? extends Job> jobs;

	
	public JobsPanel(List<Job> jobs) {
		this.jobs = jobs;
		//this.setLayout(new BorderLayout());
		//this.add(new JScrollBar(JScrollBar.HORIZONTAL)); //BorderLayout.SOUTH);
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (jobs == null) return;
		
		// if no jobs
		if (jobs.isEmpty()){
			Rectangle frameRect = SwingUtilities.getAncestorOfClass(Window.class, this).getBounds();
			int messageWidth = 50;
			g.drawString("No jobs!", frameRect.width/2 - messageWidth/2, frameRect.height/2);
		}
		// draw all job bars 
		else { 
			drawBars(g);
		}		
	}
	
	private void drawBars(Graphics g) {
		// calibrate x axis
		// find longest job to scale
		Period longest = Period.ZERO;
		for (Job job : jobs){
			Period period = job.getPeriod();
			if (!period.minus(longest).isNegative())
				longest = period;
		}
		
		// draw x axis
		
		// draw bars 
		for (Job job : jobs){
			drawJob(job, jobs.indexOf(job), g);
		}
	}

	public void drawJob(Job job, int i, Graphics g){
		int top = OUTER_PADDING + (i * (BAR_HEIGHT+BETWEEN_BAR_PADDING));
		int left = OUTER_PADDING;
		int width = (int) job.getPeriod().getDays() * 50;
		int height = BAR_HEIGHT;
		
		// draw bar
		g.setColor(job.getColour());
		g.fillRect(left, top, width, height);
		
		// draw progress
		Graphics2D g2 = (Graphics2D) g;
				
		Color[] colours = new Color[]{ new Color(0,0,180, 200), new Color(0,180,0, 200) };
		float[] fractions = new float[]{ 0, 1 };
		double progress = job.getProgress(); 
		
		g2.setPaint(new RadialGradientPaint(left, top + (float)height/2, width, fractions, colours));
		g2.fillRect(left, top, (int)(width * progress), height);
		
		// draw text
		g.setColor(Color.BLACK);
		g.drawString(job.getTitle(), left + width/2 - 10, top + height/2);
	}
	
	public void drawJobs(List<? extends Job> jobs){
		this.jobs = jobs;
		repaint();
	}

}
