package multithreating;

import java.util.Scanner;

public class ProducerConsumer {
	void produce() {
		synchronized (this) {
			System.out.println("produce");
			try {
				//Thread.sleep(1000);
				this.wait();
				System.out.println("recieved");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	void consume() {
		synchronized (this) {
			System.out.println("consume");
			Scanner s = new Scanner(System.in);
			String message = s.nextLine();
			this.notify();
		}
	}

	public static void main(String[] args) {
		ProducerConsumer myPC = new ProducerConsumer();
		Thread p1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				myPC.produce();
			}

		});
		Thread p2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				myPC.consume();
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
