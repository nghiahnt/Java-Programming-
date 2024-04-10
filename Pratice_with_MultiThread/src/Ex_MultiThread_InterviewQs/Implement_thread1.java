package Ex_MultiThread_InterviewQs;

// Extending the thread class
public class Implement_thread1 extends Thread {
	
	public void run() {
		System.out.println("My thread is in running state");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Implement_thread1 obj = new Implement_thread1();
		obj.start();
	}

}
