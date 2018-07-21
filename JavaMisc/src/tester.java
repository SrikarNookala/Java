import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class tester {

	
	public static void main(String[] args) {
		
		
	
		
	    String x = "rewr";
	    int l=x.length();
	    System.out.println(x.substring(l-10, l));
		
	
		
		
	}
	public static String countAndSay(int A) {
        int init=1;
        String temp="1";
        while(A>1){
            String l = "";
            int counter=1;
            char t = temp.charAt(0);
            
            for(int i=1;i<temp.length();i++){
                if(temp.charAt(i)==t){
                    counter++;
                    t=temp.charAt(i);
                }else{
                  l=l+counter+t; 
                  t=temp.charAt(i);
                  counter=1;
                }
            }
            
            l=l+counter+t;
            temp=l;
            A--;
        }
        
        return temp;
        
        
    }
	
	class qObject {
		String input;
		int priority;
		
		public qObject(String input,int priority){
			this.input = input;
			this.priority = priority;
		}
	}
	

	class custQueue{
		public static final int LIFO = 0;
		public static final int FIFO = 1;
		public static final int PRIORITY =2;
		public static final int BLOCKING =3;
		public static final int NON_BLOCKING =4;


		
		LinkedList<qObject> list;
		
		public custQueue(){
			// create the queue list
			list = new LinkedList<qObject>();
		}
		
		public void enQueue(qObject input){
			// adding at the beginning of the list 
			list.add(0, input);
		}
		public qObject deQueue(int deQueueCode, int modeOfInvocation){
			
			if(list.isEmpty()){
				// no elements case - need to throw an exception?
				if(modeOfInvocation == NON_BLOCKING){
					return null;
				}else if(modeOfInvocation == BLOCKING){
					// wait till there is an element in the list
					while(true){
						if(!list.isEmpty()){
							break;
						}else{
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
				}
			}
			
			if(deQueueCode == LIFO){
				// remove the recent element in the list added at the head
				qObject val = list.get(0);
				list.remove(0);
				return val;
				
			}else if(deQueueCode==FIFO){
				// remove the last element in the list
				int lastIndex = list.size()-1;
				qObject val = list.get(lastIndex);
				list.remove(lastIndex);
		        return val;
				
			}else if(deQueueCode==PRIORITY) {
				qObject val = null;
                int priority = Integer.MIN_VALUE;
                int index=0;
                for(int i=0; i<list.size();i++){
					if(list.get(i).priority>=priority){
						index = i;
					}
				}
                val = list.get(index);
				list.remove(index);
				return val;
                
			}
			
			// invalid input
			return null;
		}
        /*
		public qObject deQueue(int deQueueCode, int mPriority){
			
			if(list.isEmpty()){
				// no elements case - need to throw an exception?
				return null;
			}
			
			// overloaded method for priority based dequeue
			if(deQueueCode==PRIORITY){
				qObject val = null;
				int i=0;
				boolean elementfound=false;
				for(i=0; i<list.size();i++){
					if(list.get(i).priority==mPriority){
						elementfound = true;
			            break;
					}
				}
				if(elementfound){
					val = list.get(i);
					list.remove(i);
					return val;

				}
				// no element found case
				return null;
			}
			// invalid input priority code
			return null;	
			
		}  */
		
	}
	

}
