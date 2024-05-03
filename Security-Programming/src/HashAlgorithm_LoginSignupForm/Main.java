package HashAlgorithm_LoginSignupForm;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Components
	Container cont;
	JLabel content;
	JButton signupBtn, loginBtn;

	JPanel panel;

	private static Statement statement = null;

	private Main(String title) {
		super(title);
		cont = this.getContentPane();

		content = new JLabel("Hash algorithm with login and signup functions");
		cont.add(content, "North");

		panel = new JPanel();

		signupBtn = new JButton("Sign up");
		loginBtn = new JButton("Login");

		panel.add(signupBtn);
		panel.add(loginBtn);

		cont.add(panel, "South");

		// ActionListener
		signupBtn.addActionListener(this);
		loginBtn.addActionListener(this);

		this.pack();
		this.setSize(300, 110);
		this.setLocation(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private Statement getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hash_algorithm_basic";
			String username = "root";
			String pass = "";

			Connection conn = DriverManager.getConnection(url, username, pass);
			statement = conn.createStatement();
			if (statement != null) {
				System.out.println("Connection established");
			} else {
				System.out.println("Connection faild");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

		return statement;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Sign up")) {
//			System.out.println("Sign up!");
			new Form("Sign up Form");
		} else {
//			System.out.println("Login");
			new Form("Login");
		}
	}

	public static void signup(String username, String pass) {
		String password = hashValue(pass);
		try {
			String sql = "insert into infomations (name, password) values (\"" + username + "\", \"" + password + "\")";
			statement.execute(sql);
			System.out.println("Insert account successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	public static String login(String username, String pass) {
		String password = hashValue(pass);
		String result = "Name or password are incorrect!";

		String sql = "SELECT name, password FROM infomations WHERE name = \"" + username + "\" AND password = \""
				+ password + "\"";
		String name = "", passW = "";
		try {
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				name = rs.getString("name");
				passW = String.valueOf(rs.getString("password"));
			}

			if (password.equals(passW) && username.equals(name)) {
				result = "Your information is correct";
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return result;
	}

	private static String hashValue(String text) {
		String hashValue = "";
		try {
			// Static getInstance method is called with hashing MD5
			MessageDigest md = MessageDigest.getInstance("MD5");

			// digest() method is called to calculate message digest
			// of an input digest() return array of byte
			byte[] messageDigest = md.digest(text.getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			hashValue = no.toString();
			while (hashValue.length() < 32) {
				hashValue = "0" + hashValue;
			}
			return hashValue;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hashValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Main obj = new Main("Main layout");
		obj.getConnection();
	}

}
