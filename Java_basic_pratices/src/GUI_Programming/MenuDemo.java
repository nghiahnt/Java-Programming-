package GUI_Programming;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MenuDemo extends Frame implements ActionListener {
	private MenuBar bar;
	private Menu view, help;
	
	// Child
	private MenuItem exit, copy, paste, viewhelp, about;
	
	public MenuDemo(String title) {
		super(title);
		
		bar = new MenuBar();
		// Put menu to the interface
		setMenuBar(bar);
		
		view = new Menu("View");
		bar.add(view);
		view.addActionListener(this);
		
		copy = new MenuItem("Copy");
		view.add(copy);		
		copy.addActionListener(this);
		
		paste = new MenuItem("Paste");
		view.add(paste);
		paste.addActionListener(this);
		
		view.addSeparator(); // Them duong phan cach
		
		exit = new MenuItem("Exit");
		view.add(exit);
		exit.addActionListener(this);
		
		// help
		help = new Menu("Help");
		bar.add(help);
		help.addActionListener(this);
		
		viewhelp = new MenuItem("Help view");
		viewhelp.addActionListener(this);
		help.add(viewhelp);
		
		about = new MenuItem("About");
		about.addActionListener(this);
		help.add(about);
		
		setSize(400, 300);
		setVisible(true);
		setResizable(false);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
		if (e.getActionCommand().equals("About")) {
			new About().setVisible(true);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuDemo("My menu");
	}

}

class About extends Frame implements ActionListener {
	private Button closeBtn;
	private Label ltext1, ltext2, ltext3, ltext4;
	
	public About() {
		super("About");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		closeBtn = new Button("Close");
		closeBtn.setFont(new Font("Arial", Font.PLAIN, 18));
		closeBtn.setForeground(Color.lightGray);
		closeBtn.addActionListener(this);
		
		ltext1 = new Label("Menu demo maked during very sleepy"	);
		ltext1.setFont(new Font("Arial", Font.PLAIN, 12));
		ltext2 = new Label("Author: trongnghia");
		ltext2.setFont(new Font("Arial", Font.PLAIN, 12));
		ltext3 = new Label("Email: trongnghia.25602");
		ltext3.setFont(new Font("Arial", Font.PLAIN, 12));
		
		add(ltext1);
		add(ltext2);
		add(ltext3);
		add(closeBtn);
		
		setSize(200, 190);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == closeBtn) {
			this.setVisible(false);
		}
	}
}
