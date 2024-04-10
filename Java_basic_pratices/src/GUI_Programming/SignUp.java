package GUI_Programming;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class SignUp extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Components
	JLabel userJLabel = new JLabel("Username: ");
	JTextField userJTextField = new JTextField();
	
	JLabel passJLabel = new JLabel("Password: ");
	JTextField passJTextField = new JTextField();
	
	JLabel accessJLabel = new JLabel("Access rights: ");
	JComboBox<String> access = new JComboBox<String>();
	
	JButton saveJButton = new JButton("Save");
	JButton cancelJButton = new JButton("Cancle");
	
	// Store user
	ArrayList<Account> accountList = new ArrayList<Account>();
	
	// Initial function
	public SignUp(String title) {
		super(title);
		
		Container cont = this.getContentPane();
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3, 2));
		panel1.add(userJLabel);
		panel1.add(userJTextField);
		panel1.add(passJLabel);
		panel1.add(passJTextField);
		panel1.add(accessJLabel);
		
		access.addItem("Admin");
		access.addItem("Teacher");
		access.addItem("Student");
		panel1.add(access);
		
		// Panel2
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		
		panel2.add(saveJButton);
		panel2.add(cancelJButton);
		
		saveJButton.addActionListener(this);
		cancelJButton.addActionListener(this);
		
		// Main layout
		cont.add(panel1);
		cont.add(panel2, "South");
		
		this.setSize(300, 200);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Save")) {
			
			String name = userJTextField.getText();
			String pass = passJTextField.getText();
			String accessRight = (String)access.getSelectedItem();
			
			Account newUser = new Account(name, pass, accessRight);
			
			accountList.add(newUser);
			
			userJTextField.setText("");
			passJTextField.setText("");
			
//			for (Account account : accountList) {
//				System.out.println(account.getUserName() + account.getPassWord() + account.getAccessRight());
//			}
			
		} else { 
			this.dispose();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUp("Sign up popup");
	}
	
}

class Account {
	private String userName;
	private String passWord;
	private String accessRight;
	
	public Account() {
		userName = "";
		passWord = "";
		accessRight = "";
	}
	
	public Account(String n, String p, String a) {
		userName = n;
		passWord = p;
		accessRight = a;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getAccessRight() {
		return accessRight;
	}
	public void setAccessRight(String accessRight) {
		this.accessRight = accessRight;
	}
	
	
}
