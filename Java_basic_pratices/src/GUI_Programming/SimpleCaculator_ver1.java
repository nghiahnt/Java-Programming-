package GUI_Programming;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimpleCaculator_ver1 extends JFrame implements ActionListener {
	// Initial layout
	private Container cont;
	private JPanel panel1, panel2;
	
	// Initial components
	private JTextField tf1, tf2, tf3;
	private JButton bt1, bt2, bt3, bt4;
	
	private double result;
	
	public SimpleCaculator_ver1(String s) {
		super(s);
		cont = this.getContentPane();
		
		// Components
		JLabel num1lb = new JLabel("Num 1");
		tf1 = new JTextField("");
		
		JLabel num2lb = new JLabel("Num 2");
		tf2 = new JTextField("");
		
		JLabel resultlb = new JLabel("Result: ");
		tf3 = new JTextField();
		tf3.setEditable(false);
		
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3, 2));
		
		// Add components to panel1
		panel1.add(num1lb);
		panel1.add(tf1);
		panel1.add(num2lb);
		panel1.add(tf2);
		panel1.add(resultlb);
		panel1.add(tf3);
		
		// Buttons
		bt1 = new JButton("+");
		bt2 = new JButton("-");
		bt3 = new JButton("*");
		bt4 = new JButton("/");
		
		panel2 = new JPanel();
		panel2.add(bt1);
		panel2.add(bt2);
		panel2.add(bt3);
		panel2.add(bt4);
		
		cont.add(panel1);
		cont.add(panel2, "South");
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		
		this.pack();
		this.setVisible(true);
	}
	
	public void doPlus() {
		result = Double.parseDouble(tf1.getText()) + 
				Double.parseDouble(tf2.getText());
		tf3.setText(String.valueOf(result));
	}
	
	public void doMult() {
		result = Double.parseDouble(tf1.getText()) *
				Double.parseDouble(tf2.getText());
		tf3.setText(String.valueOf(result));
	}
	
	public void doDiv() {
		result = Double.parseDouble(tf1.getText()) /
				Double.parseDouble(tf2.getText());
		tf3.setText(String.valueOf(result));
	}
	
	public void doMinus() {
		result = Double.parseDouble(tf1.getText()) -
				Double.parseDouble(tf2.getText());
		tf3.setText(String.valueOf(result));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "+") {
			doPlus();
		}
		if (e.getActionCommand() == "-") {
			doMinus();
		}
		if (e.getActionCommand() == "*") {
			doMult();
		}
		if (e.getActionCommand() == "/") {
			doDiv();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SimpleCaculator_ver1("Simple Caculator");
	}

}
