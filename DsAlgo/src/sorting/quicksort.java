package sorting;

import java.util.Arrays;

public class quicksort {
    /*
     * taking last index as pivot, elements smaller than that particular element should on left and rest on right
     */
	public static void main(String []args){
		int a[] = {10, 7, 8, 9, 1, 5};
		quickSortArray(a,0,a.length-1);
		 System.out.println(Arrays.toString(a));
		// System.out.println(Arrays.toString(partition(a,0,a.length-1)));
		// System.out.println((partition(a,0,a.length-1)));
	}
	public static void quickSortArray(int a[],int low, int high){
		if(low>=high){
			return;
		}
		int pivot = partition(a,low,high);
		quickSortArray(a,low,pivot-1);
		quickSortArray(a,pivot+1,high);
	}
	public static int partition(int a[], int low, int high){
		int pIndex=-1;
		int pivot = a[high];
		for(int i=0;i<=high;i++){
			if(a[i]<=pivot){
				pIndex++;	
				int temp = a[i];
				a[i] = a[pIndex];
				a[pIndex]=temp;
			}
		}
		return pIndex;
	}
}
