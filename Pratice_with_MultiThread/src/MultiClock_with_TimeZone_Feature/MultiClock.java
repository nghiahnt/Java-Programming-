package MultiClock_with_TimeZone_Feature;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class MultiClock extends JFrame implements ActionListener, Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiClock();
	}
	
	// Create button object, clock label and thread t
	JButton createClock = new JButton("New Clock");
	JLabel clock = new JLabel();
	Thread t;
	
	// MultiClock functions - hàm khởi tạo của class MultiClock
	public MultiClock() {
		// Create pane - window
		Container cont = this.getContentPane();
		
		// Get current time
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		// Create clock
		clock = new JLabel(sdf.format(cal.getTime()), JLabel.CENTER);
		
		// Init size and color
		clock.setFont(new Font(clock.getFont().getName(), Font.PLAIN, 40));
    	clock.setForeground(Color.RED);
    	
    	cont.add(createClock,"North");
    	cont.add(clock);
    	this.pack(); // Set size for JFrame
    	this.setVisible(true); // Set display for JFrame
    	
    	createClock.addActionListener(this);
    	
   	 	/*Tao mot tuyen de hien thi dong ho*/
    	Thread t = new Thread(this);
    	t.start();
	}
	
	/*Cap nhat lai thoi gian sau 1 giay*/
	public void tick()
	{
		try{
			
	        Calendar cal = Calendar.getInstance();
	    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	    	clock.setText(sdf.format(cal.getTime()));
	
			Thread.sleep(1000);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
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
