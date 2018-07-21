
public class salesforce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         compare("1.0.0","2.0.0");
	}
	
	 static void compare(String version1, String version2) {
	        /*
	         * Write your code here.
	         */
	        if(!isValid(version1) || !isValid(version2)){
	            System.out.println("Error Showing Wrong format of version");
	            return;
	        }
	        
	        String [] v1  = version1.split(".");
	        String [] v2  = version2.split(".");
	        for(String x:v1){
	        	System.out.println(x);
	        }
	        for(int i=0;i<3;i++){
	            if(Long.valueOf(v1[i])>Long.valueOf(v2[i])){
	                 System.out.println(1);
	                 return;
	            }else if(Long.valueOf(v1[i])<Long.valueOf(v2[i])){
	                System.out.println(-1);
	                return;
	            }
	            
	        }
	        System.out.println(0);
	        

	    }
	    static boolean isValid(String version){
	        String [] v  = version.split("\\.");
	        for(String x:v){
	        	System.out.println(x);
	        }
	        if(v.length!=3){
	            return false;
	        }
	        try{
	            for(String x:v){
	                Long a  = Long.valueOf(x);
	            }
	            
	        }catch(Exception e){
	            return false;
	        }
	        return true;
	    }


}
