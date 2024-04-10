package javaProgramming_BasicBook;

class Person {
	private String name;
	private int age;
	private String address;
	
	public Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public void display() {
		System.out.print("Nhan vien " + name + ", " + age + " tuoi, tai dia chi " + address);
	}
}

public class SalaryManagement extends Person {
	// Employee attributes
	private float salary;
	private float rate;
	
	// Define initialize function
	public SalaryManagement(String name, int age, String address, float salary, float rate) {
		super(name, age, address);
		this.salary = salary;
		this.rate = rate;
	}
	
	public float totalSalary() {
		return salary*rate;
	}
	
	public void display() {
		super.display();
		System.out.print(" co tong luong la: "+ totalSalary());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SalaryManagement A = new SalaryManagement("Nghia", 22, "Quang Nam", 80000000, 4.00f);
		A.display();
	}

}
