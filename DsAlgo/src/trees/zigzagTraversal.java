package trees;

import java.util.Stack;

public class zigzagTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1,new Node(2, new Node(4),new Node(5)), new Node(3,new Node(6),new Node(7)));
		zigzag(head);
	}
	public static void zigzag(Node head){
		Stack<Node>a = new Stack<Node>();
		Stack<Node>b = new Stack<Node>();
		a.push(head);
		while(!a.isEmpty() || !b.isEmpty()){
			while(!a.isEmpty()){
				Node p = a.pop();
				System.out.println(p.n);
				if(p.right!=null){
					b.push(p.right);
				}
				if(p.left!=null){
					b.push(p.left);
				}
			}
			while(!b.isEmpty()){
				Node p = b.pop();
				System.out.println(p.n);
				if(p.right!=null){
					a.push(p.left);
				}
				if(p.left!=null){
					a.push(p.right);
				}
			}
		}
	}

}
