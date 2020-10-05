package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static List<Interval> insert1(List<Interval> intervals, Interval newInterval){

        intervals.add(newInterval);
        return MergeIntervals.merge(intervals);
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval){
        if(intervals== null || intervals.isEmpty()){
            return Arrays.asList(newInterval);
        }
        List<Interval> mergedInterval = new ArrayList<>();
        int i= 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start ){
            mergedInterval.add(intervals.get(i++));
        }

        while (i < intervals.size() && intervals.get(i).start <= newInterval.end ) {
            newInterval.start = Math.min(intervals.get(i).start , newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        mergedInterval.add(newInterval);

        while (i < intervals.size()){
            mergedInterval.add(intervals.get(i));
        }

        return mergedInterval;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert1(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert1(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert1(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

    }
}
