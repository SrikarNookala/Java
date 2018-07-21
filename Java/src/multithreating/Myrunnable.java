package multithreating;
public class Myrunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("runnable invoked by-"+Thread.currentThread().getName());
	}
}
