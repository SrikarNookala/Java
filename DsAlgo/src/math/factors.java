package math;

import java.util.ArrayList;
import java.util.Arrays;

public class factors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      // System.out.println(fact(30031));
      // sieve(100);
      // System.out.println(checkPrime(30031));
	//	prodOfPrimeFactors(64);
		System.out.println(prodOfPrimeFactorsIter(145));
      // System.out.println(prodOfPrimeFactors(12));
	}
	

	public static ArrayList<Integer> fact(int A){
		ArrayList<Integer>o = new ArrayList<Integer>();
		ArrayList<Integer>b = new ArrayList<Integer>();
		for(int i=1;i<=Math.sqrt(A);i++){
			if(A%i==0){
				o.add(i);
				b.add(A/i);
			}
		}
		for(int j =b.size()-1;j>=0;j--){
			o.add(b.get(j));
		}
		return o;
	}
	public static ArrayList<Integer>sieve(int n){
		int a[] = new int[n+1];
		ArrayList<Integer>primeList = new ArrayList<Integer>();
		a[0]=1;
		a[1]=1;
		for(int i=2;i<=n;i++){
			int multiplier = 2;
			int val = i*multiplier;
			while(val<=n){
				a[val]=1;
				multiplier++;
				val = i*multiplier;
			}
		}
		for(int i=2;i<a.length;i++){
			if(a[i]==0){
				//System.out.print(i+" ");
				primeList.add(i);
			}
		}
		return primeList;
	}
	public static boolean checkPrime(int n){
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	public static ArrayList<Integer>manipulatedsieve(int n){
		int a[] = new int[n+1];
		ArrayList<Integer>primeList = new ArrayList<Integer>();
		a[0]=1;
		a[1]=1;
		for(int i=2;i<=n;i++){
			int smallestPrimeFactor = 0;
			int num = i;
			
		}
		return primeList;
	}
	public static ArrayList<Integer> prodOfPrimeFactors(int n){
		ArrayList<Integer>primeList = new ArrayList<Integer>();
		ArrayList<Integer>primesBelow = sieve(n);
		int p = n;
		int listIndex=0;
		while(p!=0 && listIndex<primesBelow.size()){
			int divisor = primesBelow.get(listIndex);
			if(divisor==n){
				primeList.add(n);
			}
			if(p%divisor==0){
				p = p/divisor;
				primeList.add(divisor);
			}else{
				listIndex++;
			}
		}
		System.out.println(primeList);
        return primeList;
	}
	public static ArrayList<Integer> prodOfPrimeFactorsIter(int n){
		ArrayList<Integer>primeList = new ArrayList<Integer>();
		if(n==0 || n==1){
			return primeList;
		}
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
				primeList.add(i);
				primeList.addAll(prodOfPrimeFactorsIter(n/i));
				return primeList;
			}
		}
		primeList.add(n);
		return primeList;
	}
	

}
