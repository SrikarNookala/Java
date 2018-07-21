package trees;

import java.util.Stack;

public class nthsmallest {
    static int value;
    static int dest=3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(4,new Node(3, new Node(2),null), new Node(6,new Node(5),new Node(7)));
		inorderSearch(head,0,dest);
		System.out.println(value);
		System.out.println(inorderNonRec(head,dest));

		
	}
	static int inorderSearch(Node root,int k,int dest){
		if(root==null){
			return k;
		}
		k = inorderSearch(root.left,k,dest);
		k++;
		if(k==dest){
			value = root.n;
		}
		k =inorderSearch(root.right,k,dest);
		return k;
	}

	public static int inorderNonRec(Node head,int k){
		if(head==null){
			return 0;
		}
		int count=0;
		Stack<Node> x = new Stack<Node>();
		
		while(head!=null){
			x.push(head);
			head = head.left;
		}
		
		while(!x.isEmpty()){
			Node p = x.pop();
			count++;
			if(count==k){
				return p.n;
			}
			if(p.right!=null){
				p = p.right;
				while(p!=null){
					x.push(p);
					p = p.left;
				}
			}
		}
		return 0;
		
	}


}
