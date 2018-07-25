package arrays.mergeintervals;

import java.util.ArrayList;

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

        You may assume that the intervals were initially sorted according to their start times.

        Example 1:

        Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

        Example 2:

        Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

        This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

        Make sure the returned intervals are also sorted.

solution:  Insert the element at the correct index, check all the test cases and then merge intervals similar to mergeintervals.java


*/




public class insertAndMerge {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> nlist = new ArrayList<Interval>();

        if(intervals.size()==0){
            nlist.add(newInterval);
            return nlist;
        }
        if(newInterval.start>newInterval.end){
            newInterval = new Interval(newInterval.end,newInterval.start);
        }
        int i=0;
        for(i=0;i<intervals.size();i++){
            if(newInterval.start<=intervals.get(i).start){
                break;
            }
        }
        //  System.out.println(i);
        if(i==intervals.size()){
            intervals.add(newInterval);
        }else{

            if(newInterval.start==intervals.get(i).start){

                if(newInterval.end<=intervals.get(i).end){
                    intervals.add(i,newInterval);
                }else{
                    intervals.add(i+1,newInterval);
                }

            }else{
                intervals.add(i,newInterval);
            }

        }
        Interval x = intervals.get(0);

        for(i=1;i<intervals.size();i++){

            Interval p = intervals.get(i);
            if(x.end>=p.start){
                x = new Interval(x.start,x.end>p.end?x.end:p.end);

                continue;
            }
            if(x.start==p.start){
                x=p;
                continue;
            }
            nlist.add(x);
            x=p;
            //  System.out.println(x.start+""+x.end);
        }
        nlist.add(x);
        return nlist;
    }
}
