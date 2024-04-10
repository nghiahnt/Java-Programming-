package multiThread_Daily_Exercises;

import java.awt.*;
import java.awt.event.*;

class HighThread extends Thread {
	private TextArea display;
	
	public HighThread(TextArea a) {
		display = a;
		setPriority(Thread.MAX_PRIORITY);
	}
	
	public void run() {
		for (int i=0; i<5; i++) {
			display.append("High Priority Thread!!!\n");
		}
	}
}

class LowThread extends Thread {
	private TextArea display;
	
	public LowThread(TextArea a) {
		display = a;
		setPriority(Thread.MIN_PRIORITY);
	}
	
	public void run() {
		for (int i=0; i<5; i++) {
			display.append("Low Priority Thread!!!\n");
		}
	}
}

public class Thread_Prioritization extends Frame {	
	
	// Initialization
	private TextArea output; // An object of TextArea class
	private HighThread high; // An object
	private LowThread low; // An object
	
	public Thread_Prioritization() {
		// Call the initialize method of Frame class, setup the title
		super("Thread_Prioritization");
		
		// Create a text
		output = new TextArea(10, 20);
		add(output);
		
		// Establish an interface 
		setSize(250, 200);
		setVisible(true);
		
		// Create and start up thread higher
		high = new HighThread(output);
		high.start();
		
		// Start thread lower
		low = new LowThread(output);
		low.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread_Prioritization app = new Thread_Prioritization();
		
		// Run application and listening the action close window (Close icon (X) in window)
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
