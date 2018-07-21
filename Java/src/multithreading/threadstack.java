package multithreading;

public class threadstack {
	
   //  BankAccount b;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
       
		BankAccount b = new BankAccount();
		
		System.out.println("------------------------synchronized block on another object-------------------------------------------");
		
		Thread a = new Thread(new BankAccountOperation(20,b));
		Thread c = new Thread(new BankAccountOperation(30,b));
		//a.start();
		//c.start();   
		
		
		System.out.println("----------------------synchronized method-------------------------------------------");
		
		BankAccountRunnable r = new BankAccountRunnable();
		Thread p = new Thread(r);
		Thread q = new Thread(r);
		//p.start();
		//q.start();
		
		System.out.println("----------------------synchronized datastructure without synchronization in run method???-------------------------------------------");
		BankAccountSynchronized s = new BankAccountSynchronized(20);
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				s.setBalance(60);
			}
			
		});
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("started");
				System.out.println(s.getBalance());

			}
			
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(s.getBalance());
		
		
	}
}

class BankAccountOperation implements Runnable{
	public int up;
	BankAccount b;
	public BankAccountOperation(int up,BankAccount b){
		this.up=up;
		this.b=b;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		synchronized(b){
		
		System.out.println(Thread.currentThread().getName()+" "+b.getBalance());
		b.setBalance(up);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(b.getBalance());
		}   
		
		
		
	}
}

class BankAccount{
	private int balance;
	public  int getBalance(){
		return balance;
	}
	public void setBalance(int bal){
		balance=bal;
	}
}


class BankAccountRunnable implements Runnable{
	private int balance;
	public   int getBalance(){
		return balance;
	}
	public  void setBalance(int bal){
		balance=bal;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*
		synchronized(this){
		System.out.println(getBalance());
		setBalance(getBalance()+20);
		System.out.println(getBalance());
		} */
		update();

		
	}
	synchronized void update(){
		System.out.println(getBalance());
		setBalance(getBalance()+20);
		System.out.println(getBalance());
	}
}


class BankAccountSynchronized{
	private int balance;
	BankAccountSynchronized(int b){
		this.balance=b;
	}
	public synchronized int getBalance(){
		return balance;
	}
	public synchronized void setBalance(int bal){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		balance=getBalance()+bal;
	}
}