package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PathTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1,new Node(2, new Node(4, new Node(9),null),new Node(5)), new Node(3,null,null));
	   head = new Node(1000,new Node(2000, new Node(-3001, null,null),null), null);
	   System.out.println(checksum(head,-1,0));
	//	System.out.println(sum(path(head,new ArrayList<Integer>(),-3001)));

	}
	public static ArrayList<Integer> nodepath(Node root,ArrayList<Integer>pathlist,Node x){
		if(nodesearch(root,x)){
			pathlist.add(root.n);
			//System.out.println(pathlist);
			if(nodesearch(root.left,x)){
			    pathlist = path(root.left,pathlist,x.n);
			}else{
				pathlist = path(root.right,pathlist,x.n);
			}
			return pathlist;
		}
		return pathlist;
		
	}
	
	public static boolean nodesearch(Node root,Node a){
		if(root==null){
			return false;
		}
		if(root==a){
			return true;
		}
		return nodesearch(root.left,a)|| nodesearch(root.right,a);
	}
	
	public static ArrayList<Integer> path(Node root,ArrayList<Integer>pathlist,int n){
		if(search(root,n)){
			pathlist.add(root.n);
			//System.out.println(pathlist);
			if(search(root.left,n)){
			    pathlist = path(root.left,pathlist,n);
			}else{
				pathlist = path(root.right,pathlist,n);
			}
			return pathlist;
		}
		return pathlist;
		
	}
	public static int hasPathSum(Node A, int B) {
		if(A==null){
			return 0;
		}
		Queue<Node> list = new LinkedList<Node>();
		list.add(A);
		while(!list.isEmpty()){
			Node p = list.poll();
			if(p.left==null && p.right==null){
				int sum = sum(path(A,new ArrayList<Integer>(),p.n));
				//System.out.println(sum);
				if(sum==B){
					return 1;
				}
			}
				
			if(p.left!=null){
				list.add(p.left);
			}
			if(p.right!=null){
				list.add(p.right);
			}
			
		}
		return 0;
		
		
	}
	public static int sum(ArrayList<Integer>list){
		int sum=0;
		for(int x : list){
			sum=sum+x;
		}
		return sum;
	}
	public static boolean search(Node root,int a){
		if(root==null){
			return false;
		}
		if(root.n==a){
			return true;
		}
		return search(root.left,a)|| search(root.right,a);
	}
	
	
	
	public static boolean checksum(Node root,int a,int sum){
		if(root==null){
			return false;
		}
		sum =sum+root.n;
		if(root.left==null && root.right==null){
			if(sum==a){
				return true;
			}
		}
		return checksum(root.left,a,sum)||checksum(root.right,a,sum);
	}
	
	
	
	
	
	

}
