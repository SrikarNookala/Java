package multithreating;

public class Mythread extends Thread {
   public void run(){
	   System.out.println("invoked by-"+Thread.currentThread().getName());
   }
}
