package arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class sumpairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]={1,2,2,3};
		System.out.println(pairs(a,4));
		
		
	}
	public static int pairs(int a[],int sum){
		HashMap<Integer,Integer> c= new HashMap<Integer,Integer>();
		for(int i=0;i<a.length;i++){
			if(c.containsKey(a[i])){
				c.put(a[i], c.get(a[i])+1);
			}else{
				c.put(a[i],1);	
			}
		}
		int count=0;
		
		for(int i=0;i<a.length;i++){
			if (a[i]==sum-a[i]){
				count=count+c.get(sum-a[i])-1;
			}else if(c.containsKey(sum-a[i])){
				count=count+c.get(sum-a[i]);
			}
		}
		/*
		int count2=0;
		Set<Integer>x = c.keySet();
		Iterator<Integer>p = x.iterator();
		while(p.hasNext()){
			int l = p.next();
			if(l+l==sum){
				count2=count2+(c.get(l)*(c.get(l)-1))/2;
			}else if(c.containsKey(sum-l)){
				count2=count2+c.get(l)*c.get(sum-l);
			}
		}
		*/
		
		
		return count/2;
		//return count2;

		
		
	}

}
