package arrays;

import java.util.ArrayList;
import java.util.Iterator;

public class addOneDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         ArrayList<Integer> p = new  ArrayList<Integer> ();
         p.add(0);
         p.add(6);
         p.add(0);
         p.add(9);
         System.out.println(plusOne(p));
	}


	    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
	    	if(A.isEmpty()){
	    		return A;
	    	}
	    	int carry=1;
	        for(int i=A.size()-1;i>=0;i--){
	        	if(carry+A.get(i)<=9){
	        		A.set(i, carry+A.get(i));
	        		carry=0;
	        		break;
	        	}else{
	        		A.set(i, A.get(i)+carry-10);
	        		carry =1;
	        	}
	        }
	        if(carry==1){
	        	A.add(0, new Integer(1));
	        }
	        ///////////////////////////concurrent modification
	        Iterator<Integer> c = A.iterator();
	        while(c.hasNext()){
	        	if(c.next()!=0){
	        		break;
	        	}else{
	        		c.remove();
	        	}
	        }
	        return A;
	        
	    }
	


}
