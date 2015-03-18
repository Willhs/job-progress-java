import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	
	private JPanel currentPanel;
	public static final Dimension frameDim = new Dimension(1000, 800);
	
	public Window(){
		this.setSize(frameDim); // for mobile style
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		showJobs();
	}
	
	public static void main(String[] args){
		new Window();
	}
	
	/**
	 * displays the job maker
	 */
	public void showJobMaker(){
		this.getContentPane().removeAll();
		currentPanel = new JobMakerPanel();
		this.add(currentPanel, BorderLayout.CENTER);
	}
	
	/**
	 * displays all jobs
	 */
	public void showJobs(){
		this.getContentPane().removeAll();
		List<Job> jobs = readJobs();
		System.out.println("Jobs:");
		System.out.println(Arrays.toString(jobs.toArray()));
		
		// add to frame
		currentPanel = new JobsPanel(jobs);
		this.add(currentPanel, BorderLayout.CENTER);
		currentPanel.repaint();
	}

	private List<Job> readJobs() {
		/*try {
			List<Job> jobs = new ArrayList<Job>();
			Scanner fileScan = new Scanner(new File("jobs.txt"));
			
			while (fileScan.hasNext()){
				String line = fileScan.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		List<Job> jobs = new ArrayList<Job>();
		jobs.add(new Job("SWEN301", LocalDate.of(2015, 3, 10), LocalDate.of(2015, 3, 20)));
		jobs.add(new Job("ENGR301 assignment", LocalDate.of(2015, 3, 10), LocalDate.of(2015, 4, 15)));
		return jobs; 
	}
}
