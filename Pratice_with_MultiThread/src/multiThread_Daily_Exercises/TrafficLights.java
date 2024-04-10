package multiThread_Daily_Exercises;

import java.awt.*;
import javax.swing.*;

public class TrafficLights extends JApplet implements Runnable {
	
	String light = "green";
	
	public void init() {
		Thread t1 = new Thread(this);
		Thread t2 = new Thread(this);
		Thread t3 = new Thread(this);
		
		// Name
		t1.setName("red");
		t2.setName("yellow");
		t3.setName("green");
		
		// Start
		t1.start();
		t2.start();
		t3.start();
	}
	
	public void paint(Graphics g) {
		if (light.equals("green")) g.setColor(Color.green);
		if (light.equals("yellow")) g.setColor(Color.yellow);
		if (light.equals("red")) g.setColor(Color.red);
		
		// Draw
		g.fillOval(100, 100, 50, 50);
	}
	
	public void showLight() {
		light = Thread.currentThread().getName();
		
		// Clean screen and re-call paint function
		repaint();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			showLight();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
