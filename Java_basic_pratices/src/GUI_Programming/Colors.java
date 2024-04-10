package GUI_Programming;

import java.awt.*;
import java.awt.event.*;

public class Colors extends Frame implements ItemListener {
	// Initial
	Choice clrs = new Choice();
	
	public Colors(String title) {
		super(title);
		setLayout(new FlowLayout());
		
		clrs.addItem("White");
		clrs.addItem("Black");
		clrs.addItem("Red");
		clrs.addItem("Yellow");
		clrs.addItem("Pink");
		
		add(clrs);
		
		clrs.addItemListener(this);
		
		this.setBackground(Color.white);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				setVisible(false);
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Colors obj = new Colors("Choice demo");
		obj.setSize(400, 400);
		obj.setVisible(true);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int index = clrs.getSelectedIndex();
		if(index == 0) {
			this.setBackground(Color.white);
		}
		else if(index == 1) {
			this.setBackground(Color.black);
		}
		else if(index == 2) {
			this.setBackground(Color.red);
		}
		else if (index == 3) {
			this.setBackground(Color.yellow);
		}
		else if (index == 4) {
			this.setBackground(Color.pink);
		}
	}

}
