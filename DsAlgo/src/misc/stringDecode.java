package misc;

import java.util.Scanner;

public class stringDecode {
	// eren -> reen > eren
	public static void main(String []args){
		Scanner s  = new Scanner(System.in);
		String p = s.nextLine();
		System.out.println(decode(enCode(p)));
	}
	public static String enCode(String a){
		String r = "";
		StringBuilder x = new StringBuilder(a);
		int length = x.length();
		while(length!=1){
			if(length%2==0){
				r = r+x.charAt(length/2-1);
				x.deleteCharAt(length/2-1);
			}else{
				r = r+x.charAt(length/2);
				x.deleteCharAt(length/2);
			}
			
			length--;
		}
		System.out.println(r+x);
		return r+x;
	}
	public static String decode(String y){
		String r = "";
		int length = y.length();
		if(length%2!=0){ 
		for(int i=0;i<length;i++){
			if(i%2==0){
				r = r+y.charAt(i);
			}else{
				r = y.charAt(i)+r;
			}
		}
		}else{
			for(int i=0;i<length;i++){
				if(i%2==0){
					r = y.charAt(i)+r;
				}else{
					r = r+y.charAt(i);
				}
			}
		}
		return r;
	}
}
