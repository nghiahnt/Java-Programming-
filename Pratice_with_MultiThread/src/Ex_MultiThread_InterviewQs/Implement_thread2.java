package Ex_MultiThread_InterviewQs;

// Implementing Runnable interface in Java
public class Implement_thread2 implements Runnable {
	
	public void run() {
		System.out.println("My thread is in running state");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Implement_thread2 obj = new Implement_thread2();
		Thread tobj = new Thread(obj);
		tobj.start();
	}

}
