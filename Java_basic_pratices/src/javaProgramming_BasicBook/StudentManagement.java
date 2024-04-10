package javaProgramming_BasicBook;

/***
 * A program to management student
 * - Enter student
 * - Show list student
 * - Sort student 
 * - Find student
 */

import java.util.Scanner;
import java.util.Vector;
import java.util.Enumeration;
import java.util.Arrays;

public class StudentManagement {
	// Used to store list student
	Vector<Student> list = new Vector();
	
	public StudentManagement() {
		while (true) {
			// Display menu
			System.out.println("*-CHUONG TRINH QUAN LY SINH VIEN-*");
			System.out.println("*-Chuc nang chinh chuong trinh-*");
			System.out.println(" 1. Nhap danh sach sinh vien ");
			System.out.println(" 2. Xem danh sach sinh vien ");
			System.out.println(" 3. Sap xep sinh vien tang dan diem trung binh ");
			System.out.println(" 4. Tim sinh vien theo ten ");
			System.out.println(" 5. Thoat ");
			System.out.println(" ----------- ");
			
			int num;
			Scanner sc = new Scanner(System.in);
			System.out.print(" Nhap mot so de chon chuc nang: ");
			num = sc.nextInt();
			
			// Check and call function
			switch(num) {
			case 1:
				this.input();
				break;
			case 2:
				this.view();
				break;
			case 3: 
				this.sort();
				break;
			case 4: 
				this.search();
				break;
			case 5:
				System.out.print("--- Chuong trinh ket thuc ---");
				return;
			}
		}
	}
	
	public void input() {
			int num;
			Scanner sc = new Scanner(System.in);
			System.out.print("Nhap so luong sinh vien");
			num = sc.nextInt();
			for (int i=1; i<=num; i++) {
				System.out.print("Nhap thong tin cho sinh vien thu: "+ i);
				System.out.print(" ID: ");
				int id = Integer.parseInt(sc.next()); 
				
				// Xoa bo dem
				sc.nextLine();
				System.out.print("Ten: ");
				String name = sc.nextLine();
				System.out.print("Diem trung binh: ");
				float aver = sc.nextFloat();
				
				// Create student object
				Student st = new Student(id, name, aver);
				list.add(st);
			}		
		System.out.println("\n-------------\n");
	}
	
	public void view() {
		System.out.println(" Thong tin danh sach sinh vien");
		Enumeration vEnum = list.elements();
		int i = 1;
		
		// Trong khi chua het phan tu
		while(vEnum.hasMoreElements()) {
			// vEnum ep kieu thanh Student
			Student sts = (Student)vEnum.nextElement();
			// Hien thi danh sach sinh vien
			System.out.println(" "+ i + ". ID="+ sts.getId() + ", Ten="+ sts.getName() + ", Diem TB=" + sts.getAver());
			i++;
		}
		System.out.println("\n-------------\n");
	}
	
	public void sort() {
		// Get data from vector
		Student[] sts = new Student[list.size()];
		int index = 0;
		
		Enumeration vEnum = list.elements();
		while(vEnum.hasMoreElements()) {
			sts[index] = (Student)vEnum.nextElement();
			index++;
		}
		// Sort array
		Arrays.sort(sts);
		System.out.println("\n--Danh sach sinh vien sau khi sap xep mang");
		for(index=0; index<sts.length; index++) {
			// Hien thi thong tin sinh vien
			System.out.println(" "+ (index+1) + ". ID=" + sts[index].getId() + ", Ten=" + sts[index].getName() + ", Diem TB=" + sts[index].getAver());
		}
		System.out.println("\n-------------\n");
	}
	
	public void search() {
		Scanner sc = new Scanner(System.in);
		System.out.print(" Nhap ten sinh vien can tim: ");
		String name = sc.nextLine();
		
		// Fetch array
		Enumeration vEnum = list.elements();
		System.out.println("\n--Thong tin sinh vien tim duoc--");
		while(vEnum.hasMoreElements()) {
			Student sts = (Student)vEnum.nextElement();
			if(sts.getName().indexOf(name) != -1)
				System.out.println("ID=" + sts.getId() + ", Ten=" + sts.getName() + ", Diem Tb=" + sts.getAver());
		}
		System.out.println("\n-------------\n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentManagement();
	}

}

class Student implements Comparable<Student> {
	
	private int id;
	private String name;
	private float aver;
	
	public Student() {
		name = new String("");
		id = 0;
		aver = 0;
	}
	
	public Student(int i, String n, float a) {
		id = i;
		name = n;
		aver = a;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public float getAver() {
		return aver;
	}

	@Override
	public int compareTo(Student other) {
		// TODO Auto-generated method stub
		return Float.compare(this.aver, other.aver);
	}
	
}
