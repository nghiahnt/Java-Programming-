package IO_Stream_Practices;

import javax.swing.*;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Save_Txt_File extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Interface components
	Container cont = this.getContentPane();
	JTextArea content = new JTextArea("");
	JButton saveBtn = new JButton("Save as");
	JFileChooser chooser = new JFileChooser();
	
	// IO
	FileWriter f;
	File path = new File(".");
	
	public Save_Txt_File(String s) {
		super(s);
		
		// Set layout
		cont.add(content);
		
		cont.add(saveBtn, "South");
		saveBtn.addActionListener(this);
		this.setSize(400, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		chooser.setCurrentDirectory(path);
		chooser.setDialogTitle("Save as...");
		
		// When user press save btn
		if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			String fileName = chooser.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);
			saveFile(fileName);
		}
	}
	
	public void saveFile(String path) {
		try {
			String text = content.getText();
			f = new FileWriter(path);
			f.write(text);
			f.flush();
			f.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Save_Txt_File("Save Text File");
	}

}
