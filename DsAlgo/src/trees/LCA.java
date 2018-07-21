package trees;

public class LCA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(4,new Node(3, new Node(2),null), new Node(6,new Node(5),new Node(7)));
		Dsearch(head,4,4);
		System.out.println(counter);

	}


	 public int lca(Node A, int B, int C) {
	        Dsearch(A,B,C);
	        if(counter==2){
	        
	        while(A!=null){
	            
	           if(A.n==B  || A.n==C){
	             return A.n;   
	           }
	           counter=0;
	           Dsearch(A.left,B,C);
	           if(counter==0){
	               A=A.right;
	           }else if(counter==1){
	               return A.n;
	           }else if(counter==2){
	               A=A.left;
	           }
	        }
	        }
	      return -1;
	    }
	    
	    public static int counter=0;
	    public static void Dsearch(Node root, int a,int b) {
		    if(root==null){
	            return;
	        }
	        if(root.n==a|| root.n==b){
	           counter++;
	            if(a==b){
		        	   counter++;
		           }
	        }
	         Dsearch(root.left,a,b);
	         Dsearch(root.right,a,b);
	    }

}

