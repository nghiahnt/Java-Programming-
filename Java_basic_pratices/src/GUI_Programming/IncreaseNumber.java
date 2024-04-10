package GUI_Programming;

import java.awt.*;
import java.awt.event.*;

public class IncreaseNumber extends Frame implements ActionListener {
	// Identify components in the interface
	Button bt;
	TextField tf;
	int counter = 0;
	
	// Method to initial interface
	public IncreaseNumber() {
		// Initial component
		bt = new Button("Increase");
		bt.addActionListener(this);
		
		tf = new TextField("0");
		
		// Set Layout for container
		setLayout(new FlowLayout());
		
		add(bt);
		add(tf);
		
		// Pack function to set Frame size just enough
		pack();
		// Display frame
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		counter++;
		tf.setText(String.valueOf(counter));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IncreaseNumber();
	}

}
