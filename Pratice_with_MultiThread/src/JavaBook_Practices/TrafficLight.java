package JavaBook_Practices;

import java.awt.*;
import javax.swing.*;

public class TrafficLight extends JApplet implements Runnable {
	String light = "green";
	
	public void init() {
		Thread one = new Thread(this);
		Thread two = new Thread(this);
		Thread three = new Thread(this);
		
		one.setName("red");
		two.setName("yellow");
		three.setName("green");
		
		one.start();
		two.start();
		three.start();
	}
	
	public void paint(Graphics g) {
		if (light.equals("green")) g.setColor(Color.green);
		if (light.equals("yellow")) g.setColor(Color.YELLOW);
		if (light.equals("red")) g.setColor(Color.red);
		
		g.fillOval(100, 100, 50, 50);
	}
	
	public void showLight() {
		light = Thread.currentThread().getName();
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
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TrafficLight();
	}

}
