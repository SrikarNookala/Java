package Algorithms;

import java.util.ArrayList;

public class kadane {
    /*
     *  find the max sum of contiguous sub array
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a[] = {-2,-3,4,-1,-1,1,5};
        int b[] = {-10,-1,-2};
        int c[] = {10,100};
        
        System.out.println(brute(a));
        System.out.println(brute(b));
        System.out.println(brute(c));

        
        System.out.println(Kadane(a));
        System.out.println(Kadane(b));
        System.out.println(Kadane(c));

        
	}
	
	/*
	 * This offers all comparisons so complexity is n^2
	 */
	public static ArrayList<Integer> brute(int a[]){
		int gsum =Integer.MIN_VALUE;
		int start = -1;
		int end = -1;
		ArrayList<Integer>ans  = new ArrayList<Integer>();
		for(int i=0;i<a.length-1;i++){
			int sum=a[i];
			gsum = Math.max(gsum, sum);
			if(sum==gsum){
				start = i;
				end = i;
			}
			for(int j=i+1;j<a.length;j++){
				sum =sum+a[j];
				gsum = Math.max(gsum, sum);
				if(sum==gsum){
					start = i;
					end=j;
				}
			}
		}
		ans.add(gsum);
		ans.add(start);
		ans.add(end);
		return ans;
	}
	/*
	 *  Efficient to find the max sum and indexes as well
	 *  
	 *  if all values are negative the value will be the least negative integer
	 *  
	 *  if the sequence has a single positive sum needs to be checked from that
	 *  
	 *  verified
	 */
	public static ArrayList<Integer> Kadane(int a[]){
		int gsum =Integer.MIN_VALUE;
		int start = 0;
		int end = -1;
		ArrayList<Integer>ans  = new ArrayList<Integer>();
		int currsum = 0;
		for(int i=0;i<a.length;i++){
		   currsum = currsum+a[i];
		   gsum = Math.max(gsum, currsum);
		   if(gsum==currsum){
			   end=i;
		   }
		   if(currsum<0){
			  currsum=0;
			  start = i+1;
		   }
		  
		}
		// happens for all negative values
		if(start>=a.length ){
			start=end;
		}
		ans.add(gsum);
		ans.add(start);
		ans.add(end);
		return ans;
	}
}
