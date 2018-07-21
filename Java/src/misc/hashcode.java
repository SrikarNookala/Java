package misc;

import java.util.HashMap;

public class hashcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        a x = new a();
        x.setn("abc");
        HashMap<a,String> p = new HashMap<a,String>();
        System.out.println(x.getn()+" "+x.hashCode());
        p.put(x, "original");
        x.setn("changed");
        System.out.println(x.getn()+" "+x.hashCode());
        System.out.println(p.get(x));
	}

}
class a{
	 String n;
	 public void setn(String x){
		 this.n = x;
	 }
	 public String getn(){
		 return this.n;
	 }
}
