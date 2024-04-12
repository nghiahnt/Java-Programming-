package StudentManagement_FileSystemData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainLayout extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Initial menu to contain main functions
	private JMenuBar bar;
	private JMenu action;
	
	private JMenuItem input, exit, sort_view, search;
	
	StudentManagement admin;
	
	Container cont;
	
	public MainLayout(String title, StudentManagement admin, Vector<Object> data) {
		super(title);
		cont = this.getContentPane();
		
		setSize(500, 400);
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				admin.saveFile();
				System.exit(0);
			}
		});
		
		this.admin = admin;
		Student_TableData table = new Student_TableData(data);
		
		// Create menu bar
		bar = new JMenuBar();
		setJMenuBar(bar);
		
		// Create menu
		action = new JMenu("Action");
		bar.add(action);
		
		// Children menu
		input = new JMenuItem("Input");
		sort_view = new JMenuItem("Sort and view");
		search = new JMenuItem("Search");
		exit = new JMenuItem("Exit");
		
		action.add(input);
		action.addSeparator();
		action.add(search);
		action.addSeparator();
		action.add(sort_view);
		action.addSeparator();
		action.add(exit);
		
		input.addActionListener(this);
		exit.addActionListener(this);
		search.addActionListener(this);
		sort_view.addActionListener(this);
		
		// Set layout
		cont.setLayout(new BorderLayout());
		cont.add(bar, "North");
		cont.add(table.getTableResult(), "Center");
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Input")) {
			new InputStudent("Input Form", admin);
		}
		if (e.getActionCommand().equals("Exit")) {
			admin.saveFile();
			System.exit(0);
		}
		if (e.getActionCommand().equals("Search")) {
			
		}
		if (e.getActionCommand().equals("Sort and view")) {
			
		}
	}
	
}
