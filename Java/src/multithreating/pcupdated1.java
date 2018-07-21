package multithreating;

import java.util.Scanner;

public class pcupdated1 {
	String message;
	void produce() {
		
		synchronized (this) {
			while(true){
			try {
				this.wait();
				System.out.println("recieved-"+message);
				this.notify();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

	void consume() throws InterruptedException {
		
		synchronized (this) {
			while(true){
			System.out.println("enter input:");
			Scanner s = new Scanner(System.in);
			this.message = s.nextLine();
			this.notify();
		 }
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pcupdated1 myPC = new pcupdated1();
		Thread p1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("starting producer..");
				myPC.produce();
			}

		});
		Thread p2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("starting consumer..");
				try {
					myPC.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		p2.start();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p1.start();


	}

}
