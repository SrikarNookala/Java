package Maths;

import java.util.ArrayList;
import java.util.Arrays;

public class sumoftwoprimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //System.out.println(primesum2(4));
       //System.out.println(isPrime(25));
       System.out.println(convertToTitle(943566));
       System.out.println((char)(21+64));
       System.out.println(convertToTitle(36291));
	}

	public static boolean isPrime(int n){
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	
	public static String convertToTitle(int A) {
        String val = "";
        while(A!=0){
            int r = A%26;
            if(r==0){
            	r=26;
            }
            System.out.println(r+" "+A);
            val = val+((char)(r+64));
            A=A/26;
        }
        StringBuilder r = new StringBuilder(val);
         val = r.reverse().toString();
            return val;

    }
	
	
	public static ArrayList<Integer> primesum2(int A) {
		//sieve halfsplit- efficient
        int [] primes = new int[A];
        ArrayList<Integer> p = new ArrayList<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=2;i<A/2;i++){
        	if(primes[i]!=1){
        		for(int j=2; i*j<=A/2;j++){
            	  primes[i*j]=1;
        		}
        	}
        }
        for(int i=2;i<=A/2;i++){
        	if(primes[i]==0){
        		p.add(i);
        	}
        }
        int i=0;
        while(i<p.size()){
        	if(isPrime(A-p.get(i)) ){
        		ans.add(p.get(i));
        		ans.add(A-p.get(i));
        		break;
        	}
        	i++;
        }
        
        return ans;
	}

	
public static ArrayList<Integer> primesum(int A) {
        //sieve
        int [] primes = new int[A];
        ArrayList<Integer> p = new ArrayList<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=2;i<A;i++){
        	if(primes[i]!=1){
        		for(int j=2; i*j<A;j++){
            	  primes[i*j]=1;
        		}
        	}
        }
        for(int i=2;i<A;i++){
        	if(primes[i]==0){
        		p.add(i);
        		p.add(i);
        		//System.out.println(i);
        	}
        }
        //System.out.println(p);
        int i=0;
        int j=p.size()-1;
        while(i<j){
        	int z = A-p.get(j);
        	//System.out.println(i+" "+j+" "+p.get(j)+" "+z+" "+p.get(i));
        	if(p.get(i)==z){
        		ans.add(z);
        		ans.add(p.get(j));
        		break;
        	}else if(p.get(i)>z){
        		j--;
        	}else{
        		i++;
        	}
        }
       
        return ans;

        
    }
}
