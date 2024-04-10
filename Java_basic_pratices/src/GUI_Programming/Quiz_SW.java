package GUI_Programming;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Quiz_SW extends JFrame {
	JCheckBox cb1 = new JCheckBox("java.awt", false);
	JCheckBox cb2 = new JCheckBox("java.lang", false);
	JCheckBox cb3 = new JCheckBox("java.swing", false);
	JCheckBox cb4 = new JCheckBox("java.util", false);
	
	public Quiz_SW(String title) {
		super(title);
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(5, 1));
		
		con.add(new Label("Lop JFrame thuoc lop nao?"));
		con.add(cb1);
		con.add(cb2);
		con.add(cb3);
		con.add(cb4);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quiz_SW obj = new Quiz_SW("Online Quiz");
		obj.setSize(550, 550);
		obj.setVisible(true);
	}

}
