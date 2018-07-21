package Maths;

import java.util.ArrayList;

public class gcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     // System.out.println(gcd(9,33));
    //  System.out.println(reverse(1234567891));
     // System.out.println(reverse(Integer.MAX_VALUE));
     // ArrayList<Integer> c = new ArrayList<Integer>();
      
      System.out.println(gcdIter(3,42));
    
	}
	
	public static int gcd(int a,int b){
		if(a==0){
			return b;
		}
		if(b==0){
			return a;
		}
		if(a>b){
			int swap = a;
			a=b;
			b=swap;
		}
		if(b%a==0){
			return a;
		}else{
			return gcd(b%a,a);
		}	
	}
	
	public static int gcdIter(int a,int b){
		if(a<b){
			int swap = a;
			a=b;
			b=swap;
		}
		while(a%b!=0){
		    int c=b;
			b=a%b;
		    a=c;
		}
		return b;
	}
	public static int reverse(int A) {
        boolean isneg=false;
        if(A<0){
            A=A*-1;
            isneg=true;
        }
        int p = 0;
        while(A!=0){
        	p=p*10+(A%10);
        	if(p%10!=A%10){
        		return 0;
        	}
        	A=A/10;
          }
        return p;
        
    }

}
