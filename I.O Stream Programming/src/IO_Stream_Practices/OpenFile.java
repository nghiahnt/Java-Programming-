package IO_Stream_Practices;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class OpenFile extends JFrame implements ActionListener {
	JTextArea textArea = new JTextArea();
	JButton openBtn = new JButton("Open");
	
	FileReader fr;
	BufferedReader br;
	
	JFileChooser chooser;
	
	public OpenFile() {
		Container cont = this.getContentPane();
		openBtn.addActionListener(this);
		cont.add(openBtn, "South");
		cont.add(textArea);
		this.setSize(400, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OpenFile();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		chooser = new JFileChooser();
		// Open current directory
		chooser.setCurrentDirectory(new java.io.File("."));
		// Title
		chooser.setDialogTitle("Open file");
		// If picked file
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			// Get file's path
			String fileName = chooser.getSelectedFile().getAbsolutePath();
			// Read file
			readFile(fileName);
		}
	}
	
	public void readFile(String path) {
		try {
			textArea.setText("");
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			String s;
			while ((s = br.readLine()) != null) {
				textArea.append(s + "\n");
			}
			fr.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
