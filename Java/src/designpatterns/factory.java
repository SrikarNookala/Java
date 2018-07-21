package designpatterns;

class company{
	int ctc;
	
	void print(){
		System.out.println("generic ctc");
	}
}

class oracle extends company{
	public oracle(){
		this.ctc = 1;
	}
	void print(){
		System.out.println("ctc-"+ctc);
	}
}

class amazon extends company{
	public amazon(){
		this.ctc = 10;
	}
	void print(){
		System.out.println("ctc-"+ctc);
	}
	void printoverload(){
		System.out.println("ctc-"+ctc);
	}
}

 class cFactory {
	public static company getCompany(String name){
		if("oracle".equals(name)){
			return new oracle();
		}else if("amazon".equals(name)){
			return new amazon();	
		}
		return new company();
	}
}

public class factory {

	public static void main(String []args){
		company b  = cFactory.getCompany("oracle");
		b.print();
		company c  = cFactory.getCompany("amazon");
		c.print();
	}
}
