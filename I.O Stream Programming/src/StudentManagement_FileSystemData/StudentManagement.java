package StudentManagement_FileSystemData;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Vector;

public class StudentManagement {
	Vector<Object> listStudent = new Vector<Object>(); // GetAll and show student data
	Vector<Student> list = new Vector<Student>(); // Used to store data to file
	Vector<Object> searchData = new Vector<Object>(); // After search data

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

	public Vector<Object> getSearchData() {
		return searchData;
	}

	@SuppressWarnings("unchecked")
	public void searchStudent(String s) {
		searchData.clear();
		// Enumeration<Object> means list vEnum contain any type of data
		Enumeration<Object> vEnum = listStudent.elements();
		while (vEnum.hasMoreElements()) {
			Object object = (Object) vEnum.nextElement();
			// Get the first element of Vector through get() method and convert to string
			// Use method of String is indexOf to specify the s
			if (((Vector<Object>) object).get(0).toString().indexOf(s) != -1) {
				// If find out student like string s
				// save that vector to searchData
				searchData.add(object);
			}
		}
		// Refresh search screen

	}

	// BUG
	/**
	 * The resolve way is, transform student data vector to an array
	 * Sort the array, create the method Compare in Student object
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public Vector<Object> sortData() throws IOException {
	    getAllStudent();

	    // Sử dụng ArrayList cho hiệu suất và an toàn kiểu
	    ArrayList<Float> listAver = new ArrayList<>();
	    Enumeration<Object> vEnum = listStudent.elements();

	    while (vEnum.hasMoreElements()) {
	        Vector<Object> data = (Vector<Object>) vEnum.nextElement();
	        float aver = (float) data.get(2);
	        listAver.add(aver);
	    }

	    // Sắp xếp listAver hiệu quả
	    Collections.sort(listAver);

	    // Sử dụng HashSet để lưu trữ các điểm trung bình duy nhất và tránh trùng lặp
	    HashSet<Float> uniqueAverages = new HashSet<>(listAver);

	    // Tạo một Vector mới để lưu trữ sinh viên đã lọc (tránh sửa đổi danh sách ban đầu)
	    Vector<Object> filteredStudents = new Vector<>();

	    // Lặp qua các điểm trung bình duy nhất và tìm sinh viên phù hợp
	    for (float average : uniqueAverages) {
	        for (int i = 0; i < listStudent.size(); i++) {
	            if ((float) ((Vector<Object>) listStudent.get(i)).get(2) == average) {
	                filteredStudents.add(listStudent.get(i));
	                break; // Chỉ thêm học sinh đầu tiên khớp cho điểm trung bình này
	            }
	        }
	    }

	    // Xóa và cập nhật listStudent (tùy chọn)
	    listStudent.clear();
	    listStudent.addAll(filteredStudents);

	    // Trả về sinh viên đã lọc
	    return filteredStudents;
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
