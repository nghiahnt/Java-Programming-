/**
 * A program create three threads
 * Each thread perform solve a value 
 * Main thread waiting to finish the equation
 */
package multiThread_Daily_Exercises;

// Define threads

// Fac thread
class FacThread extends Thread {
	long gt = 1;
	int n;
	
	public FacThread(int k) {
		n = k;
	}
	
	public void run() {
		for (int i = 2; i<=n; i++) {
			gt *= i;
		}
		System.out.println("\nF1 = "+ gt);
	}
	
	public long getResult() {
		return gt;
	}
}

// Sum Thread
class SumThread extends Thread {
	long S = 0;
	int n;
	
	public SumThread(int k) {
		n = k;
	}
	
	public void run() {
		for (int i=1; i<=n; i++) {
			S += i;
		}
		System.out.println("\nF2: "+ S);
	}
	
	public long getResult() {
		return S;
	}
}

// SumPow Thread
class SumPowThread extends Thread {
	long S = 0;
	int x, n;
	
	public SumPowThread(int y, int k) {
		x = y;
		n = k;
	}
	
	public void run() {
		for (int i=1; i<=n; i++) {
			S += Math.pow(x, i);
		}
		System.out.println("\nF3 = "+ S);
	}
	
	public long getResult() {
		return S;
	}
}

public class ThreeThread_SolveEquation {
	
	// Create 3 three thread
	FacThread t1 = new FacThread(2);
	SumThread t2 = new SumThread(3);
	SumPowThread t3 = new SumPowThread(2, 4);
	
	public ThreeThread_SolveEquation() {
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			
			long S = t1.getResult() + t2.getResult() + t3.getResult();
			System.out.println("\nKet qua: "+ S);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreeThread_SolveEquation();
	}

}
