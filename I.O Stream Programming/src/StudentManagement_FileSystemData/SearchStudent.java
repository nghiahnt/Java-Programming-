package StudentManagement_FileSystemData;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class SearchStudent extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Initial
	Container cont;
	
	JPanel panel1, panel2;
	JTextField searchInput;
	JButton searchBtn, cancelBtn;
	
	StudentManagement manager;
	Student_TableData result;
	
	public SearchStudent(String title, Vector<Object> data, StudentManagement admin) {
		super(title);
		setResizable(false);
		
		result = new Student_TableData(data);
		manager = admin;
		
		cont = this.getContentPane();
		panel1 = new JPanel();
		panel2 =  new JPanel();
		
		searchInput = new JTextField(20); // Search by name
		searchBtn = new JButton("Search");
		panel1.add(searchInput);
		panel1.add(searchBtn);
		searchBtn.addActionListener(this);
		
		cont.add(panel1, "North");
		
		// Panel 2
		panel2.add(result.getTableResult());
		cont.add(panel2, "Center");
		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Search")) {
			manager.searchStudent(searchInput.getText().toString());
			Student_TableData.getModel().fireTableDataChanged();
		}
	}
}
