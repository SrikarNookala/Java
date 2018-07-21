package linkedlist;

public class reverse {
 public static void main(String []args){
	 Node head = new Node(1,new Node(2,new Node(3,new Node(4,new Node(5,null)))));
	 Node basecase = new Node(1,new Node(2,null));
	// Node.printlist(revIter(head));
	 Node.printlist(zigzagReverse(head));
 }
 public static Node reverse(Node head){
	 Node one = head;
	 Node two=head.next;
	 Node three = head.next.next;
	 two.next=one;
	 one =two;
	 two=three;
	 three = three.next;
	 return head;
 }
 public static Node revIter(Node head){
	 if(head==null || head.next==null){
		 return head;
	 }
	 if(head.next.next==null){
		 Node temp = head.next;
		 temp.next = head;
		 head.next=null;
		 head = temp;
	 }else{
		 Node mList = revIter(head.next);
		 head.next = null;
		 Node temp = mList;
		 while(temp.next!=null){
			 temp = temp.next;
		 }
		 temp.next = head;
		 return mList;
	 }
	 
	 return head;
 }

 public static Node zigzagReverse(Node head){
	 if(head==null || head.next==null){
		 return head;
	 }
	 Node temp = head.next;
	 Node y = head.next.next;
	 temp.next = head;
	 head.next=zigzagReverse(y);
	 head = temp;
     return head;
 }
}
