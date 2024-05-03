package HashAlgorithm_LoginSignupForm;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Form extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Components
	JLabel nameLabel, passwordLable, notification;
	JTextField nameTextField, passwordTextField;

	JButton okBtn, cancleBtn;

	JPanel panel, panelBtn;

	public Form(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		Container cont = this.getContentPane();

		nameLabel = new JLabel("Name");
		passwordLable = new JLabel("Password");
		notification = new JLabel("");
		notification.setVisible(false);

		nameTextField = new JTextField("");
		passwordTextField = new JTextField("");

		panel = new JPanel();

		panel.setLayout(new GridLayout(3, 2));
		panel.add(nameLabel);
		panel.add(nameTextField);
		panel.add(passwordLable);
		panel.add(passwordTextField);

		panelBtn = new JPanel();

		okBtn = new JButton("Ok");
		cancleBtn = new JButton("Cancle");
		
		panelBtn.add(okBtn);
		panelBtn.add(cancleBtn);

		// Action listener
		okBtn.addActionListener(this);
		cancleBtn.addActionListener(this);

		cont.add(panel, "North");
		cont.add(notification);
		cont.add(panelBtn, "South");

		this.setSize(300, 150);
		this.setLocation(300, 300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (this.getTitle().equals("Login")) {
			if (e.getActionCommand().equals("Ok")) {
				String result = Main.login((String) nameTextField.getText(), (String) passwordTextField.getText());
				notification.setText(result);
				notification.setVisible(true);
			} else {
				this.dispose();
			}
		} else {
			if (e.getActionCommand().equals("Ok")) {
				Main.signup((String) nameTextField.getText(), (String) passwordTextField.getText());
				this.dispose();
			} else {
				this.dispose();
			}
		}
	}

}
