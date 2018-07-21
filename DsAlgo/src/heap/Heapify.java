package heap;

import java.util.Arrays;
import java.util.Scanner;

public class Heapify {
     // base implementation, needs a datastrcuture having arraylist  to maintain heapsize
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a[] = {3,-1,-2,0,-9};
        a = buildMinHeap(a);
        System.out.println(Arrays.toString(a));
        
        /*
        while(true){
        	Scanner s = new Scanner(System.in);
        	a = kthMax(a,s.nextInt());
        	System.out.println("current 5th largest->"+a[0]);
        }   */  
	}
	

	public static int[] minHeapify(int []a,int i,int heapindex){
		int pickedindex=0;
		boolean picked  =false;
		if(2*i+1>heapindex){
			//no leaf nodes
			return a;
		}else if((2*i+2)>heapindex){
			// no right node
			int left = a[2*i+1];
			if(a[i]>left){
				a[2*i+1]=a[i];
				a[i]=left;
				pickedindex= 2*i+1;
				picked=true;
			}
		}else{
		  // both node exist	
			int left = a[2*i+1];
			int right= a[2*i+2];
			if(left<right){
					if(a[i]>left){
						a[2*i+1]=a[i];
						a[i]=left;
						pickedindex= 2*i+1;
						picked=true;
					}
			
				}else{
					if(a[i]>right){
						a[2*i+2]=a[i];
						a[i]=right;
						pickedindex= 2*i+2;
						picked=true;
					}
			}
		}
		//System.out.println(Arrays.toString(a));
		if(picked){
			return minHeapify(a,pickedindex,heapindex);
		}else{
			return a;
		}
	}
	
	
	
	public static int[] buildMinHeap(int a[]){
		int startPoint  = a.length/2;
		for(int i=startPoint;i>=0;i--){
			a = minHeapify(a,i,a.length-1);
		}
		return a;
	}
	
	public static int[] heapSort(int a[]){
		a = buildMinHeap(a);
		for(int i=0;i<a.length-1;i++){
		   int swap = a[0];
		   a[0] = a[a.length-1-i];
		   a[a.length-1-i]=swap;
		   a = minHeapify(a,0,a.length-2-i);
		}
		return a;
	}

    public static int[] kthMax(int a[],int input){
    	// create a min heap of size k , 5 in this case
    	// for each input update the heap so that 5th largest is always on the top
    	if(input <a[0]){
    		return a;
    	}else{
    		a[0]=input;
    		return minHeapify(a,0,a.length-1);
    	}	
    }


    public static int extractMin(int a[],int heapindex){
    	int result = a[0];
    	a[0]= a[heapindex];
    	a[heapindex] = result;
    	heapindex--;
    	minHeapify(a,0,heapindex);
    	return result;
    }



}
