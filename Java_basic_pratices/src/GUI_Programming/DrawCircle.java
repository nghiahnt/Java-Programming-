package GUI_Programming;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DrawCircle extends Frame implements MouseListener {
	// Save the position already on the screen
	private Vector<MyPoint> vec;
	private MyPoint currentPoint;
	
	public DrawCircle() {
		setTitle("Draw circle");
		setSize(300, 400);
		this.setVisible(true);
		
		vec = new Vector<MyPoint>();
		this.addMouseListener(this);
		
		// Accept use mouse to close the window
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("Clicked!");
		System.out.println(e.getX() + "\n" + e.getY());
		vec.add(new MyPoint(e.getX(), e.getY()));
		// Clear screen and repaint
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// Automatic called function
	public void paint(Graphics g) {
		for (int i=0; i<vec.size(); i++) {
			currentPoint = (MyPoint)vec.get(i);
			g.drawOval(currentPoint.getX(), currentPoint.getY(), 20, 20);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DrawCircle();
	}

}

class MyPoint {
	private int x, y;
	
	MyPoint(int xVal, int yVal) {
		x = xVal;
		y = yVal;
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
	}
}
