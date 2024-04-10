package GUI_Programming;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IncreaseNumber_SW extends JFrame implements ActionListener {
	// Components
	JButton bt;
	JTextField tf;
	int counter = 0;
	
	public IncreaseNumber_SW() {
		// Initial
		bt = new JButton("Increase");
		tf = new JTextField("0");
		
		bt.addActionListener(this);
		
		Container cont = this.getContentPane();
		cont.setLayout(new FlowLayout());
		
		// Add components
		cont.add(bt);
		cont.add(tf);
		
		// Display
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IncreaseNumber_SW();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		counter++;
		tf.setText(String.valueOf(counter));
	}

}
