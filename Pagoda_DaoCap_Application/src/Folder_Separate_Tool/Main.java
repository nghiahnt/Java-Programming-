package Folder_Separate_Tool;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;

public class Main extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Init
	Container container;
	
	JPanel pathPanel;
	
	JButton openBtn;
	JTextField pathTextField;
	JLabel pathLabel, status;
		
	private Main() {
		container = this.getContentPane();
		
		pathPanel = new JPanel();
		pathPanel.setLayout(new GridBagLayout());
		// Create grid bag constrants
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 10, 5, 5);
		
		openBtn = new JButton("Transfer");
		openBtn.addActionListener(this);
		
		pathLabel = new JLabel("Path");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		pathPanel.add(pathLabel, gbc);
		
		pathTextField = new JTextField("");
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		pathPanel.add(pathTextField, gbc);
		
		status = new JLabel("Done");
		
		container.add(pathPanel);
		container.add(openBtn, "South");
		this.setSize(550, 150);
		this.setLocation(300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private static String getBaseName(String fileName) {
		int dashIndex = fileName.indexOf("-");
		return (dashIndex == -1) ? fileName : fileName.substring(0, dashIndex);
	}
	
	private static List<String> organizeFiles(String filePath) throws IOException {
		File directory = new File(filePath);
//		File[] files = directory.listFiles((dir, name) -> name.endsWith(".png"));
		File[] files = directory.listFiles();
		
		if (files == null || files.length == 0) {
			throw new IOException("No files found in the directory");
		}
		
		Map<String, List<File>> fileGroups = new HashMap<>();
		
		for (File file : files) {
			if (file.isFile()) {
				String fileName = file.getName();
				String baseName = getBaseName(fileName);
				
				fileGroups.computeIfAbsent(baseName, k -> new ArrayList<>()).add(file);
			}
		}
		
		List<String> newDirectories = new ArrayList<>();
		
		for (Map.Entry<String, List<File>> entry : fileGroups.entrySet()) {
			String baseName = entry.getKey();
			List<File> groupedFiles = entry.getValue();
			
			if (groupedFiles.size() > 1) {
				String newFolderName = filePath + File.separator + baseName + "-DC";
				File newFolder = new File(newFolderName);
				
				if (!newFolder.exists()) {
					newFolder.mkdir();
				}
				newDirectories.add(newFolder.getAbsolutePath());
				
				for (File file : groupedFiles) {
					Files.move(file.toPath(), new File(newFolder, file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
				}
			}
		}
		
		return newDirectories;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String pathName = pathTextField.getText();
		
		try {
			List<String> newDirs = organizeFiles(pathName);
			newDirs.forEach(System.out::println);
		} catch (IOException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}

}
