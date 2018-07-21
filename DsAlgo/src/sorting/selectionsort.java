package sorting;

import java.util.Arrays;

public class selectionsort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a[] = {6,1,7,2};
        System.out.println(Arrays.toString(insertionSort(a)));
    }
	
	public static int[] insertionSort(int a[]){
		for(int i=0;i<a.length-1;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]>a[j]){
					int swap = a[i];
					a[i] = a[j];
					a[j]=swap;
				}
			}
		}
		return a;
	}

}
