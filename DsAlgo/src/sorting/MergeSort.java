package sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,1};
		System.out.println(Arrays.toString(mergeSort(a)));

	}
	
	public static int[] mergeSort(int a[]){
		if(a.length==1){
			return a;
		}
		int mid = (a.length-1)/2;
		int left[] = new int[mid+1];
		int right[] = new int[a.length-mid-1];
		for(int i=0;i<=mid;i++){
			left[i]=a[i];
		}
		int c=0;
		for(int i=mid+1;i<a.length;i++){
			right[c]=a[i];
			c++;
		}
		return merge(mergeSort(left),mergeSort(right));
	}
	public static int[] merge(int[]a,int []b){
		// assuming here the two arrays are sorted. merging these two
		int merged[] = new int[a.length+b.length];
		int i=0,j=0,c=0;
		while(i!=a.length || j!=b.length){
			if(i==a.length){
				merged[c]=b[j];
				c++;
				j++;
				continue;
			}
			if(j==b.length){
				merged[c]=a[i];
				c++;
				i++;
				continue;
			}
			if(a[i]<b[j]){
				merged[c]=a[i];
				c++;
				i++;
			}else if(a[i]>b[j]){
				merged[c]=b[j];
				c++;
				j++;
			}else if(a[i]==b[j]){
				merged[c]=a[i];
				c++;
				merged[c]=b[j];
				c++;
				i++;
				j++;
			}
		}
		return merged;
	}

}
