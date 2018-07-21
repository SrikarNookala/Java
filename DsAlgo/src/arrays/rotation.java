package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class rotation {
 public static void main(String []args){
	 int a[] = {1, 2, 3, 4, 5, 6, 7};
	// System.out.println(Arrays.toString(rotate(a,2)));
	// System.out.println(Arrays.toString(rotate(a,2)));
	 
 }
 public static int[] rotate(int[]a,int d){
	 // Auxiliary  space - will fail for large array size
	 // o(n)
	 int[]c = new int[a.length];
	 int j=0;
	 for(int i=d;i<a.length;i++){
		 c[j]= a[i];
		 j++;
	 }
	 for(int i=0;i<d;i++){
		 c[j]= a[i];
		 j++;
	 }
	 return c;
 }
 public static int[] onybyone(int a[], int d){
	 for(int i=0;i<d;i++){
		 int temp = a[0];
		 for(int j=0;j<a.length-1;j++){
			 a[j]=a[j+1];
		 }
		 a[a.length-1]=temp;
	 }
	 return a;
 }
 
 
 public static int[] juggling(int a[],int d){
	 int gcd = gcd(a.length,d);
	 return null;
 }
 public static int gcd(int a, int b){
return 1;
 }
 
}
