package multiThread_Daily_Exercises;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class MultiClock extends JFrame implements ActionListener, Runnable {
	
	// Button
	JButton createClock = new JButton("New Clock");
	
	// Label
	JLabel clock;
	
	public MultiClock() {
		// Get containPane of JFrame
		Container cont = this.getContentPane();
		
		// Get time
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		// Time to label
		clock = new JLabel(sdf.format(cal.getTime()), JLabel.CENTER);
		
		// Attributes
		clock.setForeground(Color.RED);
		clock.setFont(new Font(clock.getFont().getName(), Font.PLAIN, 40));
//		clock.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		// Set position
		cont.add(createClock, "North");
		
		// Put JLabel
		cont.add(clock);
		this.pack();
		this.setVisible(true);
		
		// Add listener
		createClock.addActionListener(this);
		
		// Create thread
		Thread t = new Thread(this);
		t.start();
	}
	
	public void tick() {
		try {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			
			clock.setText(sdf.format(cal.getTime()));
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiClock();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			tick();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new MultiClock());
		t.start();
	}

}
