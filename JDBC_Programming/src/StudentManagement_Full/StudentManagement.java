package StudentManagement_Full;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentManagement extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Initials
	Controller controller;
	
	@SuppressWarnings("rawtypes")
	Vector vData;
	@SuppressWarnings("rawtypes")
	Vector vTitle;
	
	JScrollPane tableResult;
	JTable table;
	DefaultTableModel model;
	
	// Buttons
	JButton editBtn, deleteBtn, insertBtn;
	
	int selectedRow = 0;
	
	@SuppressWarnings("unchecked")
	public StudentManagement(String title) {
		super(title);
		Container conn = this.getContentPane();
		
		// Connect to data base
		Controller.connection();
		Vector<Object> allStudentData = Controller.getAllStudents(); // A vector has two children vectors
		vData = (Vector<Object>) allStudentData.get(0);
		vTitle = (Vector<Object>) allStudentData.get(1);
				
		// Main layout
		// Buttons
		editBtn = new JButton("Edit");
		deleteBtn = new JButton("Delete");
		insertBtn = new JButton("Insert");
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(editBtn);
		btnPanel.add(deleteBtn);
		btnPanel.add(insertBtn);
		
		// Table
		model = new DefaultTableModel(vData, vTitle);
		table = new JTable(model);
		tableResult = new JScrollPane(table);
		
		// Add actionListener
		table.addMouseListener(this);
		editBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		insertBtn.addActionListener(this);
		
		conn.add(btnPanel, "South");
		conn.add(tableResult, "North");
		this.setSize(400, 300);
		this.setLocation(200, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Edit")) {
			@SuppressWarnings("unchecked")
			Vector<Object> selectedData = (Vector<Object>) vData.elementAt(selectedRow);
//			System.out.println(selectedData);
//			Vector<Object> data = new Vector<Object>(4);
//			data.add("Nghia");
//			data.add("10");
//			data.add("10");
//			data.add("10");
			new UpdateForm("Update Form", selectedData);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		selectedRow = table.getSelectedRow();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentManagement("Student Management");
	}

}

class UpdateForm extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Initial
	JLabel nameLabel, mathLabel, physLabel, chemLabel, errorLabel, errorDetaiLabel;
	JTextField nameTextField, mathTextField, physTextField, chemTextField;
	
	JButton okBtn, cancleBtn;
	
	public UpdateForm(String title, Vector<Object> studentData) {
		super(title);
		Container cont = this.getContentPane();
		cont.setLayout(new GridLayout(6, 2));
		
		nameLabel = new JLabel("Name");
		nameTextField = new JTextField((String) studentData.get(1));
		mathLabel = new JLabel("Math");
		mathTextField = new JTextField((String) studentData.get(2));
		physLabel = new JLabel("Physical");
		physTextField = new JTextField((String) studentData.get(3));
		chemLabel = new JLabel("Chemistry");
		chemTextField = new JTextField((String) studentData.get(4));
		
		// Error labels
		errorLabel = new JLabel("");
		errorDetaiLabel = new JLabel("");
		errorLabel.setVisible(false);
		errorDetaiLabel.setVisible(false);
		
		// Buttons
		okBtn = new JButton("OK");
		cancleBtn = new JButton("Cancle");
		
		// Add to container
		cont.add(nameLabel);
		cont.add(nameTextField);
		cont.add(mathLabel);
		cont.add(mathTextField);
		cont.add(physLabel);
		cont.add(physTextField);
		cont.add(chemLabel);
		cont.add(chemTextField);
		
		cont.add(errorLabel);
		cont.add(errorDetaiLabel);
		
		cont.add(okBtn);
		cont.add(cancleBtn);
		
		// Add actionListener
		
		// Container setting
		this.setSize(230, 200);
		this.setLocation(250, 100);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("OK")) {
			// Update to database
			// Update in screen 
			
		} 
		else if(e.getActionCommand().equals("Cancle")) {
			
		}
	}
	
}
