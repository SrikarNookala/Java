package trees;

import java.util.LinkedList;
import java.util.Queue;

public class levelorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1,new Node(2, new Node(4),new Node(5)), new Node(3,new Node(6),new Node(7)));
		//System.out.println(height(head));
		//level(head);
		levelrec(head);

	}
	public static void level(Node a){
		if(a==null) return;
		Queue<Node> x = new LinkedList<Node>();
		x.add(a);
		
		while(!x.isEmpty()){
			Node p = x.poll();
			System.out.println(p.n);
			if(p.left!=null){
				x.add(p.left);
			}
			if(p.right!=null){
				x.add(p.right);
			}
		}
		
	}
	
	public static void levelrec(Node a){
		if(a==null) return;
		for(int i=1;i<=height(a);i++){
			printlevel(a,i);
		}
		
	}
	private static void printlevel(Node a, int i) {
		// TODO Auto-generated method stub
		if(i==1){
			System.out.println(a.n);
			return;
		}
		printlevel(a.left,i-1);
		printlevel(a.right,i-1);

	}
	public static int height(Node a){
		if(a==null){
			return 0;
		}
		return 1+Math.max(height(a.left), height(a.right));
	}

}
