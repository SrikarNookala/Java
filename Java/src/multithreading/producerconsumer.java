package multithreading;

import java.util.Queue;
import java.util.Scanner;

public class producerconsumer {

	Queue<String> Stream;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedObject s  = new SharedObject();
		Thread p = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
				
					synchronized(s){
					    Scanner f = new Scanner(System.in);
						s.message=f.nextLine();
						s.notify();
					    System.out.println("After wait-"+s.message);

					}
				}
				
			}
			
		});
		
		Thread c = new Thread(new Runnable(){
           
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					synchronized(s){
						try {
							s.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    System.out.println("Received message:"+s.message);
					}
					
				}
					
			}
			
		});
		c.start();
		p.start();
		
     
	}

}

class SharedObject{
    String message="frttf";
}
