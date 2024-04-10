package GUI_Programming;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleCaculator_ver2 extends JFrame implements ActionListener {
	private Container cont;
	private JPanel panel1, panel2;
	
	private JTextField display;
	private JTextField result;
	private JButton btn;
	String buttons[] = {"7", "8", "9", "/",
						"4", "5", "6", "*",
						"1", "2", "3", "-",
						"0", ".", "=", "+"};
	
	private boolean start = true;
	private String op = "=";
	
	public SimpleCaculator_ver2(String title) {
		super(title);
		cont = this.getContentPane();
		
		// Components
		display = new JTextField("");
		display.setPreferredSize(new Dimension(300, 50));
		display.setEditable(false);
		
		result = new JTextField("");
		result.setPreferredSize(new Dimension(50, 50));
		result.setEditable(false);
		
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 2));
		panel1.add(display);
		panel1.add(result);
		
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4, 4));
		// Buttons
		for (int i=0; i<buttons.length; i++) {
			btn = new JButton(buttons[i]);
			panel2.add(btn);
			btn.addActionListener(this);
		}
		
		cont.add(panel1, "North");	
		cont.add(panel2, "Center");
	}
	
	public void actionPerformed(ActionEvent event) {
		String s = event.getActionCommand();
		if ('0' <= s.charAt(0) && s.charAt(0) <= '9' || s.equals(".")) {
			if (start) {
				display.setText(s);
			}
			else {
				display.setText(display.getText() + s);
			}
			start = false;
		} else {
			if (start) {
				if (s.equals("-")) {
					display.setText(s);
				} else {
					op = s;
				}
			} else {
				
			}
		}
	}
	
	public void caculate(double n) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleCaculator_ver2 obj = new SimpleCaculator_ver2("Simple caculator_v2");
		obj.setSize(500, 500);
		obj.setVisible(true);
	}

}
