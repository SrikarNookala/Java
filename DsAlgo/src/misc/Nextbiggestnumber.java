package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Nextbiggestnumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n = 143;
        System.out.println(nextbig(n));
        
        ArrayList<String> arr;
        arr = new ArrayList<String>();
         
        //output should be 6054854654
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        System.out.println(largestNumber(arr));
        
	}
	public static String nextbig(int n){
		int c = n;
		String num = String.valueOf(n);
		char[] p = num.toCharArray();
		int lastDigit = p[p.length-1];
	    for(int i=p.length-2;i>=0;i--){
	    	if(p[i]<lastDigit){
	    		 char swap = p[i];
	    		 p[i] =p[p.length-1]; 
	    		 p[p.length-1] = swap;
	    		 // sort values in between
	    		 for(int k = i+1;k<p.length;k++){
	    			 for(int l=k+1;l<p.length;l++){
	    				 if(p[l]<p[k]){
	    					 char temp = p[l];
	    					 p[l]=p[k];
	    					 p[k]=temp;
	    				 }
	    			 }
	    		 }
	    		break;
	    	}
	    }
	    return new String(p);
	}


	public static String largestNumber(ArrayList<String> a){
		Collections.sort(a,new myComparator());
		return Arrays.toString(a.toArray());
	}
	
}
class myComparator implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		String n1 = arg0+arg1;
		String n2 = arg1+arg0;
		if(Long.valueOf(n1)>Long.valueOf(n2)){
			return -1;
		}
		return 1;
	}
	 
}