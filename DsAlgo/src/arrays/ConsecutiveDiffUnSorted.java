package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ConsecutiveDiffUnSorted {
    /*
       Given an unsorted array find the max difference between two consecutive integers in LINEAR TIME AND  LINEAR SPACE

       eg: 4,1,10,5
       ans: 10-5 = 5

       -- sorting take nlogn time
       -- can create a bucket array of size = max(array) and create a lookup but will run to heap memory issues

       Solution:

         Max diff possible = max - min
         Min diff possible = (max-min)/(length-1)  i.e placing points at a equal distance

         so the intervals possible are  [min,min+mindiff),[min+mindiff,min+2*mindiff)......

         then determine where each value belongs to in to these buckets

         consider example of 1,7,10
         1 has to raise to 10 that means an increment of 9 with 2 increments, i.e per each step an average of 4.5 units ciel to 5
         so the partition array will be like 1 1+5 1+2*5 =  1,6,11, so the values in range 1-6 will be in first bucket and 6-11 in second bucket

         index calculation  =   (value-min)/partition gap
         for 1 =>   0
         for 7 =>  (7-1)/5  = 6/5  = 1
         for 10 =>  9/5  = 1

         {1,1} and {7,10} are two buckets so the diff is max of first bucket - min of second bucket = 7-1 =6



          consider case 1,2,2

          partition = 1,  buckets = 2, value=2


          for the case 1,2,3

          partition = 1,  buckets = 2

          while inserting 3 into bucket the calculated index will be 2 which will give an index out of bound!
          This is happens when difference between min and max equals to distance between them

          to avoid all this, max and min are not bucketed



     */


    public static  void main(String []args){
        int a[] = {1,1};
        ArrayList<Integer> m= new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            m.add(a[i]);
        }
       System.out.println(findDiff(m));
    }
    public  static int findDiff(ArrayList<Integer> m){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(Integer x:m){
            max = x>max?x:max;
            min = x<min?x:min;
        }
        int n = max-min;
        if(n==0){
            // all values are same
            return 0;
        }
        double h = ((double)n)/(m.size()-1);
        int partition = (int)Math.ceil(h);
        Bucket [] blist = new Bucket[m.size()-1];
        for(int i=0; i<blist.length; i++){
            blist[i] = new Bucket();
        }
        for(Integer x:m){

            if(x==min || x==max){
                continue;
            }
           int index = (x-min)/partition;
           if(blist[index].count==0){
               blist[index].minValue=x;
               blist[index].maxValue=x;
               blist[index].count=1;
           }else{
               blist[index].minValue=Math.min(x, blist[index].minValue);
               blist[index].maxValue=Math.max(x, blist[index].maxValue);
           }
        }

        int i=0;
        int prev = min;
        int mindiff = Integer.MIN_VALUE;
        while(i<blist.length){
            if(blist[i].count==0){
                i++;
                continue;
            }
            mindiff = Math.max(blist[i].minValue-prev,mindiff);
            prev = blist[i].maxValue;
            i++;
        }
        mindiff = Math.max(max-prev,mindiff);
        return mindiff;

    }


}
class Bucket{
    int minValue=Integer.MAX_VALUE;
    int maxValue=Integer.MIN_VALUE;
    int count=0;
    public  void push(int x){
        count++;
        if(x<minValue){
            minValue=x;
        }
        if(x>maxValue){
            maxValue=x;
        }
    }
    public String toString(){
        return "Bucket :"+minValue+" "+maxValue;
    }
}