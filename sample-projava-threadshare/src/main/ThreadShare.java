package main;

public class ThreadShare implements Runnable {

	public int shareValue = 100;
	
	@Override
	public void run() {
		shareValue += 100;
		System.out.println("Value: " + shareValue);
	}

	public static void main(String[] args) {
		ThreadShare ts = new ThreadShare();
		Thread t1 = new Thread(ts);
		Thread t2 = new Thread(ts);
		
		t1.start();
		t2.start();
	}

}
