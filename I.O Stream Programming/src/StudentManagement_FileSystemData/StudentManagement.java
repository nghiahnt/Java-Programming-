package StudentManagement_FileSystemData;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class StudentManagement {
	Vector<Object> listStudent = new Vector<Object>();
	Vector<Student> list = new Vector<Student>();
	
	// IO Stream
	FileWriter file;
	FileReader readFile;
	PrintWriter printFile;
	String path = "./src/StudentManagement_FileSystemData/data.txt";
 	
	public StudentManagement() throws IOException {
		getAllStudent();
		new MainLayout("Student Management", this, listStudent);
	}
	
	public void getAllStudent() throws IOException {
		// Read txt file and push to Vector
		try {
			readFile = new FileReader(path);
			BufferedReader br = new BufferedReader(readFile);
			String studentInfo;
			
			while ((studentInfo = br.readLine()) != null) {
				Vector<Object> data = new Vector<Object>();
				String[] s = studentInfo.split("&");
				data.add(s[0]);
				data.add(s[1]);
				data.add(Float.parseFloat(s[2]));
				listStudent.add(data);
 			}
			readFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addStudent(String name, String id, float aver) {
		Student element = new Student(name, id, aver);
		list.add(element); // Contain student object

		// Use to display student data
		Vector<Object> studentData = null;

		studentData = new Vector<Object>();
		studentData.add(element.getName());
		studentData.add(element.getId());
		studentData.add(element.getAver());
		listStudent.add(studentData);

		System.out.println("Add student successfully!");
		Student_TableData.getModel().fireTableDataChanged();
	}
	
	public void saveFile() {
		try {
			file = new FileWriter(path, true);
			printFile = new PrintWriter(file);
			
			// Enumeration is effciency to fetch an list, array etc.
			// This is a const and 2 main methods (hasMoreElements and nextElement)
			// Get list vEnum
			Enumeration<Student> vEnum = list.elements();
			
			while (vEnum.hasMoreElements()) {
				Student st = vEnum.nextElement();
				String toString = st.getName() + "&" + st.getId() + "&" + st.getAver();
				// Print data to file
				printFile.println(toString);
				// Clean buffer 
				printFile.flush();
				System.out.println("Saved file");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new StudentManagement();
	}

}
