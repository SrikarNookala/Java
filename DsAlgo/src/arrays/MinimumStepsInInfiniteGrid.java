package arrays;

import java.util.ArrayList;

public class MinimumStepsInInfiniteGrid {

	
	public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
	        
	        int steps=0;
	         if(A.size()==0 || B.size()==0 || A.size()!=B.size()){
	             return 0;
	         }
	         
	        
	        for(int i=0;i<A.size()-1;i++){
	            int diffx = A.get(i)-A.get(i+1);
	            int diffy = B.get(i)-B.get(i+1);
	            
	            if(diffx<0){
	                diffx = diffx*-1;
	            }
	             if(diffy<0){
	                diffy = diffy*-1;
	            }
	            if(diffx>=diffy){
	                steps = steps+diffx;
	            }else{
	                steps = steps+diffy;
	            }
	            
	        }
	        
	        return steps;
	        
	        
	        
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // A -> 3 1 2 3
		// B -> 3 1 2 3
		// ->> (1,1) (2,2) (3,3)  -> this movement required 2 steps with 8 possible movements from each co-ordinate
	}

}
