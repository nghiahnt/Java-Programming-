package GUI_Programming;

import java.awt.*;
import java.awt.event.*;

public class Quiz extends Frame {
	// Initial
	Checkbox cb1 = new Checkbox("java.awt", false);
	Checkbox cb2 = new Checkbox("java.lang", false);
	Checkbox cb3 = new Checkbox("java.swing", false);
	Checkbox cb4 = new Checkbox("java.util", false);
	
	// Initial function
	public Quiz(String title) {
		super(title);
		
		setLayout(new GridLayout(5, 1));
		add(new Label("Lop Frame thuoc goi nao?"));
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				setVisible(false);
				// Thoat chuong trinh
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quiz objQuiz = new Quiz("Online Quiz");
		objQuiz.setSize(550, 550);
		objQuiz.setVisible(true);
	}

}
