package trees;

public class Node {
   int n;
   Node left;
   Node right;
   public Node(int n){
	   this.n=n;
   }
   public Node(int n,Node left,Node right){
	   this.n=n;
	   this.left=left;
	   this.right=right;
   }
}
