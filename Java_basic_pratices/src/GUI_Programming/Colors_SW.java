package GUI_Programming;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Colors_SW extends JFrame implements ItemListener {
	JComboBox clrs = new JComboBox();
	
	Container con;
	
	public Colors_SW(String title) {
		super(title);
		
		con = this.getContentPane();
		con.setLayout(new FlowLayout());
		
		clrs.addItem("White");
		clrs.addItem("Black");
		clrs.addItem("Red");
		clrs.addItem("Yellow");
		clrs.addItem("Pink");
		
		con.add(clrs);
		clrs.addItemListener(this);
		
		con.setBackground(Color.white);
	}
	
	public void itemStateChanged(ItemEvent e) {
		int index = clrs.getSelectedIndex();
		if(index == 0) {
			con.setBackground(Color.white);
		}
		else if(index == 1) {
			con.setBackground(Color.BLACK);
		}
		else if(index == 2) {
			con.setBackground(Color.red);
		}
		else if(index == 3) {
			con.setBackground(Color.yellow);
		}
		else if(index == 4) {
			con.setBackground(Color.pink);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Colors_SW obj = new Colors_SW("Choice Demo");
		obj.setSize(400, 400);
		obj.setVisible(true);
	}
}
