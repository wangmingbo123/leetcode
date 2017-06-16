package leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wy on 2017/6/16.
 */
public class p57 {
     public class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
     }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> merge=new ArrayList<Interval>();
        int i=0;
        int j=intervals.size()-1;
        while (intervals.size()>i&&newInterval.start>intervals.get(i).end){
            merge.add(intervals.get(i));
            i++;
        }
        while (j>-1&&newInterval.end<intervals.get(j).start){
            j--;
        }
        if(i==intervals.size()||j==-1){
            // large all or
            // small all
            merge.add(i,newInterval);

        }else{
            Interval one=new Interval(Math.min(intervals.get(i).start,newInterval.start),
                    Math.max(intervals.get(j).end,newInterval.end));
            merge.add(i,one);
        }
        while ((j+1)<intervals.size()){
            merge.add(intervals.get(j+1));
            j++;
        }
        return merge;
    }
}
