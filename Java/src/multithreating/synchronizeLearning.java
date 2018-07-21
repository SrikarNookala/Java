package multithreating;

public class synchronizeLearning {
   public static void main(String []args){
	   SynchronizedCounter s = new SynchronizedCounter();
	   Thread a = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				s.increment();
			}

		});
	   Thread b = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				s.decrement();
			}

		});
	   a.start();
	   b.start();
	   try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   System.out.println(s.value());
   }
}
 class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
}