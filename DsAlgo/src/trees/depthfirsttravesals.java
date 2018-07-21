package trees;

import java.util.Stack;

public class depthfirsttravesals {

	 public static void inOrder(Node head){
	    	if(head==null){
	    		return;
	    	}
	    	inOrder(head.left);
	    	System.out.print(head.n);
	    	inOrder(head.right);
	    }
	 public static void preOrder(Node head){
	    	if(head==null){
	    		return;
	    	}
	    	System.out.print(head.n);
	    	preOrder(head.left);
	    	preOrder(head.right);
	    }
	 public static void postOrder(Node head){
	    	if(head==null){
	    		return;
	    	}
	    	postOrder(head.left);
	    	postOrder(head.right);
	    	System.out.print(head.n);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1,new Node(2, new Node(4, new Node(9),null),new Node(5)), new Node(3,null,null));
		inOrder(head);
		System.out.println();
		inorderNonRec(head);
		/*
		System.out.println();
		preOrder(head);
		System.out.println();
		postOrder(head);
		System.out.println();
		System.out.println(height(head));
		levelOrder(head,1);
		*/
		


	}
	
	public static int height(Node head){
		if(head==null){
			return 0;
		}
		int h1 = height(head.left);
		int h2 = height(head.right);
		int height = Math.max(h1, h2);
		return height+1;
	}
	
	public static void levelOrder(Node head,int level){
		if(head==null){
			return;
		}
		if(level==1){
		 System.out.println(head.n);
		}
		
		if(head.left!=null){
			System.out.print(head.left.n);
		}
		if(head.right!=null){
			System.out.print(head.right.n);
		}
		System.out.println();
		levelOrder(head.left,level+1);
		levelOrder(head.right,level+1);
	}
	
	public static void inorderNonRec(Node head){
		if(head==null){
			return;
		}
		
		Stack<Node> x = new Stack<Node>();
		
		while(head!=null){
			x.push(head);
			head = head.left;
		}
		
		while(!x.isEmpty()){
			Node p = x.pop();
			System.out.println(p.n);
			if(p.right!=null){
				p = p.right;
				while(p!=null){
					x.push(p);
					p = p.left;
				}
			}
		}
		
	}

}
