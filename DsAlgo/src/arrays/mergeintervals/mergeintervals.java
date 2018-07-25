package arrays.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*


Given a collection of intervals, merge all overlapping intervals.

For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.


Solution:  we need to do sorting of objects based on some parameter so we can directly use comparable interface or comparator in java
           and define the sorting criteria, then pick and element and compare with element in array, if there is a merge proceed or else add
           the result till that point to answer list



 */


public class mergeintervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals,new IntervalComp());
        ArrayList<Interval>j = new ArrayList<Interval>();
        Interval prev = null;
        for(Interval i:intervals){
            if(prev==null){
                prev = i;
                continue;
            }
            Interval curr = i;
            if(prev.end<curr.start){
                j.add(prev);
                prev = curr;
            }if(prev.end==curr.start){
                Interval x = new Interval(prev.start,curr.end);
                /// j.add(x);
                prev = x;
            }else{

                if(prev.end>=curr.end){
                    Interval x = new Interval(prev.start,prev.end);
                    prev = x;
                }else{
                    Interval x = new Interval(prev.start,curr.end);
                    // j.add(x);
                    prev = x;

                }
            }
        }
        j.add(prev);
        return j;
    }
}
class IntervalComp implements Comparator<Interval> {
    public int compare(Interval a,Interval b){
        if(a.start>b.start){
            return 1;
        } if(a.start<b.start){
            return -1;
        }

        if(a.end>b.end){
            return 1;
        } if(a.end<b.end){
            return -1;
        }
        return 0;

    }
}

