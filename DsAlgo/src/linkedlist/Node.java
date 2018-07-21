package linkedlist;

public class Node {
  int n;
  Node next;
  public Node(int n){
	  this.n=n;
  }
 public Node(int n,Node next){
	  this.n = n;
	  this.next=next;
  }
 public static void printlist(Node head){
	 Node temp = head;
	 while(temp!=null){
		 System.out.print(temp.n+"->");
		 temp = temp.next;
	 }
 }
}
