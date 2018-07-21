package multithreating;

public class Tester {

	public static void main(String[] args) {
		Mythread m1 = new Mythread();
		Thread m2 = new Thread(new Myrunnable());
		m1.start();
		m2.start();
	}

}
