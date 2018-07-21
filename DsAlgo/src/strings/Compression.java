package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println(redup(dedup("aaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbcccccccccc",10),10));
	}
	  static String dedup(String inputStr, int chunkSize) {
	        // Write your code here.
	        String dupStr = "";
	        HashMap<String,ArrayList<Integer>> m = new HashMap<String, ArrayList<Integer>>();
	        int i=0;
	        for( i=0;i<inputStr.length();i=i+chunkSize){
	            String p = inputStr.substring(i,i+chunkSize);

	            if(m.containsKey(p)){
	                ArrayList<Integer> x =(ArrayList<Integer>) m.get(p);
	                x.add(i);
	            }else{
	                ArrayList<Integer> l = new ArrayList<Integer>();
	                l.add(i);
	                m.put(p,l);
	            }
	        }
	        for (String name: m.keySet()){

	            String key =name.toString();
	            ArrayList<Integer> value = (ArrayList<Integer>)m.get(name);
	            String cursor = "";
	            for(Integer p:value){
	            	cursor = cursor+p+",";
	            }
	            cursor=cursor.substring(0, cursor.length()-1);
	            dupStr = dupStr+name+":"+cursor+"-";


	        	} 
           System.out.println(dupStr+i);  
	  	  return dupStr+i;

	    }
	  static String redup( String deduplicatedStr, int chunkSize){
		  String [] sp = deduplicatedStr.split("-");
		  int size = Integer.valueOf(sp[sp.length-1]);
		  String [] an = new String[size/chunkSize];
		  for(String x:sp){
			  String[] val = x.split(":");
			  if(val.length>1){
				  String q = val[1];
				  String []index = q.split(",");
				  for(String i:index){
					  an[Integer.valueOf(i)/chunkSize] = val[0];
				  }
			  }
		  }
		  String result = "";
		  for(String d:an){
			  result =result+d;
		  }
		  return result;
	  }

}
