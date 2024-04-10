package javaProgramming_BasicBook;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentManagement_Advanced extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Prepare data
	String columns[] = {"ID", "Name", "Math", "Phys", "Chem", "Aver"};
	String[][] rows = {{"1", "ho", "1", "2", "3", "3"},
						{"2", "nguyen", "3", "4", "5", "6"},
						{"3", "trong", "6", "7", "8", "9"},
						{"4", "nghia", "9", "9", "8", "7"},};
		
	// Initial table
	Vector vTitle = new Vector();
	Vector vData = new Vector();
	JScrollPane tableResult;
	JTable table;
	DefaultTableModel model; // Create and manage the data for tabel
	
	// Management data
	JButton edit, insert, delete;
	
	// Data picked
	int rowPicked = 0;
	
	// Show the table students
	@SuppressWarnings("unchecked")
	public StudentManagement_Advanced(String title) {
		super(title);
		Container cont = this.getContentPane();		
		
		try {
			// Add data to the table, put it on the top 
			// Load data
			load();
//			System.out.println(vTitle);
//			System.out.println(vData);
			
			// Initial buttons
			edit = new JButton("Edit");
			edit.addActionListener(this);
			delete = new JButton("Delete");
			delete.addActionListener(this);
			delete.setEnabled(false);
			insert = new JButton("Insert");
			insert.addActionListener(this);
			
			// Group buttons
			JPanel btnPanel = new JPanel();
			btnPanel.add(edit);
			btnPanel.add(delete);
			btnPanel.add(insert);
			
			model = new DefaultTableModel(vData, vTitle);
			table = new JTable(model);
			tableResult = new JScrollPane(table);
			table.addMouseListener(this); // Listener when click mouse to row
			
			cont.add(btnPanel, "South");
			cont.add(tableResult, "North");
			
			this.setSize(400, 300);
			this.setLocation(200, 100);
			this.setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	// Load data to the vector
	@SuppressWarnings("unchecked")
	public void load() {
		try {
			vTitle.clear();
			vData.clear();
			int num_column = columns.length;
			// Create data for title
			for (int i=0; i<num_column; i++) {
				vTitle.add(columns[i]);
			}
			
			// Data for row
//			for (String[] row : rows) {
//				ArrayList<String> data = new ArrayList<String>(num_column);
//				Collections.addAll(data, row); // Each row is an array list
//				vData.add(data);
//			}
			for (int i=0; i<rows.length; i++) {
				Vector row = new Vector(num_column);
				for (int j=0; j<rows[i].length; j++) {
//					System.out.println(rows[i][j]);
					row.add(rows[i][j]);
				}
				vData.add(row);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	// Insert data
	public void insertData(String id, String name, Float math, Float phys, Float chem, Float aver) {
		try {
			Vector<String> insertData = new Vector<String>();
			insertData.add(id);
			insertData.add(name);
			insertData.add(math+"");
			insertData.add(phys+"");
			insertData.add(chem+"");
			insertData.add(aver+"");
			
			vData.add(insertData);
			model.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// Edit data
	public void editData(String id, String name, Float math, Float phys, Float chem, Float aver) {
		try {
			Enumeration element = vData.elements(); // Element is a vector consist data
			int i = 0;
			while (element.hasMoreElements()) {
				Vector editingElement = (Vector)element.nextElement();
				if (editingElement.elementAt(0).equals(id)) {
					vData.remove(i); // Remove that vector
					break;
				}
				i++;
			}
			// Create new vector
			Vector<String> editedData = new Vector<String>();
			editedData.add(id);
			editedData.add(name);
			editedData.add(math+""); // Convert to string
			editedData.add(phys+"");
			editedData.addLast(chem+"");
			editedData.add(aver+"");
			
			vData.add(i, editedData);
			// Refresh model
			model.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// Delete data
	public void deleteData() {
		try {
			vData.remove(rowPicked);
			model.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		rowPicked = table.getSelectedRow();
		delete.setEnabled(true);
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
		if (e.getActionCommand().equals("Edit")) {
			Vector content = (Vector)vData.elementAt(rowPicked);
//			System.out.print(content); // good
			// Create Update form object
			new updateForm("Form edit", this, (String)content.elementAt(0), 
					(String)content.elementAt(1), 
					(String)content.elementAt(2),
					(String)content.elementAt(3), 
					(String)content.elementAt(4));
		} 
		if (e.getActionCommand().equals("Delete")) {
			deleteData();
		}
		if (e.getActionCommand().equals("Insert")) {
			new updateForm("Insert form", this, "", "", "0", "0", "0");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentManagement_Advanced("Management Students");
	}

}

class updateForm extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Initial components
	JLabel idLb, nameLb, mathLb, physLb, chemLb;
	JTextField idTextField, nameTextField, mathTextField, physTextField, chemTextField;
	
	// Error form
	JLabel errorLabel, errorDetailJLabel;
	
	// Confirm and cancel buttons
	JButton confirmBtn, cancelBtn;
	
	// StudentManagement obj
	StudentManagement_Advanced stdMAdvanced;

	public updateForm(String title, StudentManagement_Advanced st, String id, String name, String math, String phys, String chem) {
		super(title);
		System.out.println(title);
		
		// Student Management Advanced
		stdMAdvanced = st;
//		System.out.println(stdMAdvanced.vData);
		
		// Create form
		Container cont = this.getContentPane();
		cont.setLayout(new GridLayout(7, 2));
		
		idLb = new JLabel("Id");
		idTextField = new JTextField(id);
		nameLb = new JLabel("Name");
		nameTextField = new JTextField(name);
		mathLb = new JLabel("Math");
		mathTextField = new JTextField(math);
		physLb = new JLabel("Physical");
		physTextField = new JTextField(phys);
		chemLb = new JLabel("Chemistry");
		chemTextField = new JTextField(chem);
		
		cont.add(idLb);
		cont.add(idTextField);
		cont.add(nameLb);
		cont.add(nameTextField);
		cont.add(mathLb);
		cont.add(mathTextField);
		cont.add(physLb);
		cont.add(physTextField);
		cont.add(chemLb);
		cont.add(chemTextField);
		
		errorLabel = new JLabel("");
		errorDetailJLabel = new JLabel("");
		errorLabel.setVisible(false);
		errorDetailJLabel.setVisible(false);
		cont.add(errorLabel);
		cont.add(errorDetailJLabel);
		
		// Buttons
		confirmBtn = new JButton("Confirm");
		cancelBtn = new JButton("Cancel");
		cont.add(confirmBtn);
		cont.add(cancelBtn);
		confirmBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		this.setSize(230, 200);
		this.setLocation(250, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Confirm")) {
			insertDB(); // Update the data include (modify data)
			this.setVisible(false);
		}
		else this.dispose(); // Close window when press cancel button
 	}
	
	public void insertDB() {
		if (idTextField.getText().equals("") || nameTextField.getText().equals("") || 
				mathTextField.getText().equals("") || physTextField.getText().equals("")
				|| chemTextField.getText().equals("")) {
			// Create error content
			errorLabel.setText("Error");
			errorDetailJLabel.setText("Empty value!");
			errorLabel.setForeground(Color.red);
			errorDetailJLabel.setForeground(Color.red);
			
			errorLabel.setVisible(true);
			errorDetailJLabel.setVisible(true);
		} else {
			// Not empty - get value 
			try {
				String id = idTextField.getText();
				String name = nameTextField.getText();
				float mathScore = Float.parseFloat(mathTextField.getText());
				float physScore = Float.parseFloat(physTextField.getText());
				float chemScore = Float.parseFloat(chemTextField.getText());
				
				// Update the Vector vData
				if (this.getTitle().equals("Form edit")) {
					stdMAdvanced.editData(id, name, mathScore, physScore, chemScore, (mathScore + physScore + chemScore)/3);
				} else {
					stdMAdvanced.insertData(id, name, mathScore, physScore, chemScore, (mathScore + physScore + chemScore)/3);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
}
