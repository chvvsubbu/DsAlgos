package mergeintervals;

import java.util.*;

public class IntervalOverlap {
    public static boolean isIntervalOverlap(List<Interval> intervals) {
        if(intervals.size() < 2) return true;
        Collections.sort(intervals, (a, b)->Integer.compare(a.start, b.start) );
        Iterator<Interval> intervalIterator = intervals.iterator();
        Interval interval = intervalIterator.next();
        int start = interval.start;
        int end = interval.end;
        while (intervalIterator.hasNext()) {
            interval = intervalIterator.next();
            if(interval.start <= end){
                return true;
            }else {
                start = interval.start;
                end = interval.end;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        //input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Is interval overlap: " + IntervalOverlap.isIntervalOverlap(input));
        System.out.println();

        input = new ArrayList<Interval>();
       // input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Is interval overlap: " + IntervalOverlap.isIntervalOverlap(input));
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Is interval overlap: " + IntervalOverlap.isIntervalOverlap(input));
        System.out.println();

    }
}
