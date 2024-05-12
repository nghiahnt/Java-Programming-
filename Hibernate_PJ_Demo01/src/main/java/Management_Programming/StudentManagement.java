package Management_Programming;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.xml.sax.SAXException;

public class StudentManagement extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Initials
	Controller controller;

	@SuppressWarnings("rawtypes")
	public static Vector vData;
	@SuppressWarnings("rawtypes")
	Vector vTitle;

	JScrollPane tableResult;
	JTable table;
	public static DefaultTableModel model;

	// Buttons
	JButton editBtn, deleteBtn, insertBtn, cancleBtn, saveToXML, showToXML;

	int selectedRow = 0;

	public static Vector<Object> allStudentData;

	@SuppressWarnings("unchecked")
	public StudentManagement(String title, Vector vData, Vector vTitle) {
		super(title);
		Container conn = this.getContentPane();

		// Connect to data base
		Controller.connection();
//		allStudentData = Controller.getAllStudents(); // A vector has two children vectors
//		vData = (Vector<Object>) allStudentData.get(0);
//		vTitle = (Vector<Object>) allStudentData.get(1);

		// Main layout
		// Buttons
		editBtn = new JButton("Edit");
		deleteBtn = new JButton("Delete");
		insertBtn = new JButton("Insert");
		cancleBtn = new JButton("Cancle");
		// XML Buttons
		saveToXML = new JButton("Save XML File");
		showToXML = new JButton("Show XML File");

		JPanel btnPanel = new JPanel();
		btnPanel.add(editBtn);
		btnPanel.add(deleteBtn);
		btnPanel.add(insertBtn);
		btnPanel.add(cancleBtn);
		btnPanel.add(saveToXML);
		btnPanel.add(showToXML);

		// Table
		model = new DefaultTableModel(vData, vTitle);
		table = new JTable(model);
		tableResult = new JScrollPane(table);

		// Add actionListener
		table.addMouseListener(this);
		editBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		insertBtn.addActionListener(this);
		cancleBtn.addActionListener(this);
		saveToXML.addActionListener(this);
		showToXML.addActionListener(this);

		conn.add(btnPanel, "South");
		conn.add(tableResult, "North");
		this.setSize(700, 350);
		this.setLocation(200, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@SuppressWarnings("unchecked")
//	public void actionPerformed(ActionEvent e) {
//		if (e.getActionCommand().equals("Edit")) {
//			@SuppressWarnings("unchecked")
//			Vector<Object> selectedData = (Vector<Object>) vData.elementAt(selectedRow);
//			new UpdateForm("Update Form", selectedData, selectedRow);
//		}
//		if (e.getActionCommand().equals("Cancle")) {
//			System.exit(0);
//		}
//		if (e.getActionCommand().equals("Insert")) {
//			Vector<Object> insertData = new Vector<Object>();
//			for (int i = 0; i < 6; i++) {
//				insertData.add("");
//			}
//			new UpdateForm("Insert form", insertData, selectedRow = 0);
//		} 
//		if (e.getActionCommand().equals("Delete")) {
//			String studentId = (String) ((Vector) StudentManagement.vData.elementAt(selectedRow)).get(0);		
//			int idConverted = Integer.parseInt(studentId);
//			try {
//				Controller.deleteStudent(idConverted);
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//			
//			StudentManagement.vData.removeElementAt(selectedRow);
//			StudentManagement.model.fireTableDataChanged();
//		}
//		if (e.getActionCommand().equals("Save XML File")) {
//			ModifyXML_StudentManagement.createXMLFile(vData, vTitle);
//		}
//		if (e.getActionCommand().equals("Show XML File")) {
//			try {
//				ModifyXML_StudentManagement obj = new ModifyXML_StudentManagement("XML Content");
//			} catch (SAXException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//	}

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new StudentManagement("Student Management");
//	}

}

//class UpdateForm extends JFrame implements ActionListener {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	// Initial
//	JLabel nameLabel, mathLabel, physLabel, chemLabel, errorLabel, errorDetaiLabel;
//	JTextField nameTextField, mathTextField, physTextField, chemTextField;
//
//	JButton okBtn, cancleBtn;
//
//	Container cont = this.getContentPane();
//
//	Vector<Object> studentDataSelected;
//
//	private int selectedRow;
//
//	public UpdateForm(String title, Vector<Object> studentData, int selectedRow) {
//		super(title);
//		cont.setLayout(new GridLayout(6, 2));
//		studentDataSelected = studentData;
//		this.selectedRow = selectedRow;
//
//		nameLabel = new JLabel("Name");
//		nameTextField = new JTextField((String) studentData.get(1));
//		mathLabel = new JLabel("Math");
//		mathTextField = new JTextField((String) studentData.get(2));
//		physLabel = new JLabel("Physical");
//		physTextField = new JTextField((String) studentData.get(3));
//		chemLabel = new JLabel("Chemistry");
//		chemTextField = new JTextField((String) studentData.get(4));
//
//		// Error labels
//		errorLabel = new JLabel("");
//		errorDetaiLabel = new JLabel("");
//		errorLabel.setVisible(false);
//		errorDetaiLabel.setVisible(false);
//
//		// Buttons
//		okBtn = new JButton("OK");
//		cancleBtn = new JButton("Cancle");
//
//		// Add to container
//		cont.add(nameLabel);
//		cont.add(nameTextField);
//		cont.add(mathLabel);
//		cont.add(mathTextField);
//		cont.add(physLabel);
//		cont.add(physTextField);
//		cont.add(chemLabel);
//		cont.add(chemTextField);
//
//		cont.add(errorLabel);
//		cont.add(errorDetaiLabel);
//
//		cont.add(okBtn);
//		cont.add(cancleBtn);
//
//		// Add actionListener
//		cancleBtn.addActionListener(this);
//		okBtn.addActionListener(this);
//
//		// Container setting
//		this.setSize(230, 200);
//		this.setLocation(250, 100);
//		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		this.setVisible(true);
//	}
//
//	public Vector<Object> getInputData() {
//		Vector<Object> data = new Vector<Object>();
//
//		if (nameTextField.getText().equals("") || mathTextField.getText().equals("")
//				|| physTextField.getText().equals("") || chemTextField.getText().equals("")) {
//			errorLabel.setText("Error");
//			errorDetaiLabel.setText("Empty value");
//			errorLabel.setBackground(Color.red);
//			errorDetaiLabel.setForeground(Color.red);
//
//			errorLabel.setVisible(true);
//			errorDetaiLabel.setVisible(true);
//		} else {
//			float math = Float.parseFloat(mathTextField.getText());
//			float phys = Float.parseFloat(physTextField.getText());
//			float chem = Float.parseFloat(chemTextField.getText());
//			float aver = (math + phys + chem) / 3;
//			data.add(studentDataSelected.get(0)); // id
//			data.add(nameTextField.getText());
//
//			String m = Float.toString(math);
//			String p = Float.toString(phys);
//			String c = Float.toString(chem);
//
//			data.add(m);
//			data.add(p);
//			data.add(c);
//			data.add(aver);
//		}
//
//		return data;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if (e.getActionCommand().equals("OK")) {
//			// Update to database and Update in screen
//			// Get values in textfields, update to view and database
//			// If value is empty - show err
//			Vector updateData = getInputData();
//
//			if (this.getTitle().equals("Update Form")) {
//				StudentManagement.vData.set(selectedRow, updateData);
//				this.dispose();
//				StudentManagement.model.fireTableDataChanged();
//
//				// Update in database
//				try {
//					Controller.updateStudent(updateData);
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			} else {
//				// Update to database then reload UI
//				try {
//					Vector<Object> insertData = getInputData();
//					Controller.insertStudent(insertData);
//
//					// Update in UI
//					Vector allStudentData = (Vector) Controller.getAllStudents().get(0);
//					int lastIndex = ((Vector) Controller.getAllStudents().get(0)).size() - 1;
//					
// 					String newStudentId = (String) ((Vector) allStudentData.get(lastIndex)).get(0);
// 					int newStudentIdConverted = Integer.parseInt(newStudentId);
// 					
//					insertData.set(0, newStudentIdConverted);
//					StudentManagement.vData.add(insertData); 	
//					
//					StudentManagement.model.fireTableDataChanged();
//					this.dispose();
//					
//				} catch (Exception e2) {
//					// TODO: handle exception
//					e2.printStackTrace();
//				}
//			}
//
//		} else if (e.getActionCommand().equals("Cancle"))
//
//		{
//			this.dispose();
//		}
//	}
//
//}
