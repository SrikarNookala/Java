package trees;

import java.util.ArrayList;

public class commonAncestor {

	public static void main(String []args){
		Node head = new Node(1,new Node(2, new Node(4),new Node(5)), new Node(3,new Node(6),new Node(7)));
		System.out.println(commonAncestor(head,4,5).n);
	}
	public static Node commonAncestor(Node head,int a,int b){
		if(head ==null || head.n ==a || head.n==b){
			return head;
		}
		Node left = commonAncestor(head.left,a,b);
		Node right= commonAncestor(head.right,a,b);
		if(left!=null && right!=null){
			return head;
		}
		return left!=null?left:right;
	}
}
