package sorting;

import java.util.Arrays;

public class insertionsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a[] = {4,3,2,1};
        System.out.println(Arrays.toString(insertionSort(a)));
    }
	
	public static int[] insertionSort(int a[]){
		for(int i=1;i<a.length;i++){
			if(a[i]<a[i-1]){
				int index=i;
				int value = a[i];
				while(index>0 && a[index-1]>value){
					a[index]=a[index-1];
					index--;
				}
				a[index]=value;
			}
		}
		return a;
	}

}
