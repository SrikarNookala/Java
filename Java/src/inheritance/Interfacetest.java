package inheritance;



interface a{
	public int p=1;
	//public void print();
}
interface b{
	public String print();
}


public class Interfacetest implements a {
    /*
     * method clash in two interfaces results in compilation error
     * 
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interfacetest test = new Interfacetest();
		test.runner();
	}
	public void runner(){
		System.out.println(this.p);
	}
	
}
