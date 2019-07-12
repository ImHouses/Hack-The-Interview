import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * Seen at: https://www.interviewbit.com/problems/merge-overlapping-intervals/
 * Status: SOLVED on O(nlogn) time and O(n) space.
 */
class MergeOverlappingIntervals {
    public static void main(String[] args) {

        Interval[] input = new Interval[]{new Interval(1, 10), new Interval(2, 9), new Interval(3, 8), new Interval(4, 7), new Interval(5, 6), new Interval(6, 6)};
        ArrayList<Interval> intervals = new ArrayList<>();
        for (Interval interval : input) {
            intervals.add(interval);
        }
        ArrayList<Interval> result = merge(intervals);
        System.out.println("Result: " + result.toString());
    }

    static class Interval {
        int start;
        int end;
        Interval() {
            this.start = 0;
            this.end = 0;
        }
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return String.format("[%d, %d]", this.start, this.end);
        }
    }

    /**
     * Returns an ArrayList of merged intervals.
     * 
     * @param intervals The intervals to merge.
     * @return An ArrayList of merged intervals.
     */
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() == 1 || intervals.size() == 0) {
            return intervals;
        }
        intervals.sort((interval1, interval2) -> interval1.start - interval2.start);
        int i = 0;
        int j = 1;
        while (j < intervals.size()) {
            Interval first = intervals.get(i);
            Interval next = intervals.get(j);
            if (first.end >= next.start) {
                Interval merged = mergeIntervals(first, next);
                intervals.set(i, merged);
                intervals.set(j, null);
                j++;
            } else {
                i = j;
                j++;
            }
        }
        ArrayList<Interval> result = new ArrayList<>();
        for (int index = 0; index < intervals.size(); index++) {
            Interval interval = intervals.get(index);
            if (interval == null) {
                continue;
            }
            result.add(interval);
        }
        return result;
    }
    
    /**
     * Auxiliar method for merging intervals.
     */
    public static Interval mergeIntervals(Interval interval1, Interval interval2) {
        int start = interval1.start < interval2.start ? interval1.start : interval2.start;
        int end = interval1.end > interval2.end ? interval1.end : interval2.end;
        return new Interval(start, end);
    }
}