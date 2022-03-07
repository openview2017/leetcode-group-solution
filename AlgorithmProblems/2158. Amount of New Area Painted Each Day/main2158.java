import java.util.*;

public class main2158 {
    public static void main(String[] args) {
        Solution2158 sol = new Solution2158();
        int[] res;

        int[][] paint = new int[][]{{1,4},{4,7},{5,8}};
        res = sol.amountPainted(paint);
        System.out.println(Arrays.toString(res));
    }
}

class Solution2158 {
    public int[] amountPainted(int[][] paint) {
        int n = paint.length;
        int[] result = new int[n];
        TreeMap<Integer, Integer> intervals = new TreeMap<>();
    
        for (int i = 0; i < n; i++) {
            int[] current = paint[i];
            // start and end to record the merged interval
            int start = current[0];
            int end = current[1];
            int toPaint = end - start;
    
            Map.Entry<Integer, Integer> floor = intervals.floorEntry(current[0]);
            if (floor != null) {
                if (floor.getValue() >= end) {
                    // the entire current interval has been covered by floor, so the result[i] = 0 and simply just continue.
                    continue;
                }//  [4,5]  [3,6]
                if (floor.getValue() >= start) {
                    // the current interval has been partially covered by floor, so deduct the overlapping length.
                    toPaint -= floor.getValue() - start;
                    intervals.remove(floor.getKey());
                    start = floor.getKey();
                } //  [4,5]  --[3,4.5]---
            }
    
            Map.Entry<Integer, Integer> ceiling = intervals.ceilingEntry(current[0]);
            // there could be multiple ceilings overlap with the current interval.
            // e.g. current [5, 20], ceilings: -[6, 8]-, -[10, 15]-, [18, 22]
            // We need to deduct the overlapping length properly
            while (ceiling != null && ceiling.getKey() <= end) {
                toPaint -= Math.min(end, ceiling.getValue()) - ceiling.getKey();
                intervals.remove(ceiling.getKey());
                end = Math.max(end, ceiling.getValue());
                ceiling = intervals.ceilingEntry(current[0]);
            }
    
            result[i] = toPaint;
            // add the merged interval to treemap
            intervals.put(start, end);
        }
    
        return result;
    }
    }
    /*
    https://leetcode.com/problems/amount-of-new-area-painted-each-day/discuss/1784268/Java-TreeMap-%2B-Merge-Intervals-Easy-to-Understand-Beats-95.83
    
    Although there are 2 loops, the time complexity is still amortized O(nlogn) since we put and remove each interval at most once.
    
    [1,4] [4,7] [2,8]
    
    */