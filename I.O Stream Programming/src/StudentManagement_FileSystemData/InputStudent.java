package StudentManagement_FileSystemData;

import java.awt.*;
import java.awt.event.*;

public class InputStudent extends Frame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Initial
	private Panel panel1, panel2;
	
	private Label nameLb;
	private TextField nameTextField;
	private Label idLb;
	private TextField idTextField;
	private Label averLb;
	private TextField averTextField;
	
	private Button saveBtn, cancelBtn, newInput;
	
	private StudentManagement management;
	
	public InputStudent(String title, StudentManagement admin) {
		super(title);
		management = admin;
		
		panel1 = new Panel();
		panel1.setLayout(new GridLayout(3, 2));
		
		nameLb = new Label("Name");
		nameTextField = new TextField(20);
		idLb = new Label("Id");
		idTextField = new TextField(20);
		averLb = new Label("Average");
		averTextField = new TextField(20);
		
		panel1.add(nameLb);
		panel1.add(nameTextField);
		panel1.add(idLb);
		panel1.add(idTextField);
		panel1.add(averLb);
		panel1.add(averTextField);
		
		this.add(panel1, "North");
		
		panel2 = new Panel();
		
		saveBtn = new Button("Save");
		saveBtn.addActionListener(this);
		
		cancelBtn = new Button("Cancel");
		cancelBtn.addActionListener(this);
		
		newInput = new Button("New input");
		newInput.addActionListener(this);
		
		panel2.add(saveBtn);
		panel2.add(newInput);
		panel2.add(cancelBtn);
		
		this.add(panel2, "South");
		setSize(300, 200);
		setVisible(true);
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
//				System.exit(0);
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Save")) {
			String name = nameTextField.getText();
			String id = idTextField.getText();
			float aver = Float.parseFloat(averTextField.getText());
			management.addStudent(name, id, aver);
			setVisible(false);
		}
		if (e.getActionCommand().equals("Cancel")) {
			this.dispose();
		}
		if (e.getActionCommand().equals("New input")) {
			nameTextField.setText("");
			idTextField.setText("");
			averTextField.setText("");
		}
		
	}
	
}
