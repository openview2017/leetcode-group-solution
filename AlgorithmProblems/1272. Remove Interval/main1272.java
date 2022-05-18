import java.util.*;

public class main1272 {
    public static void main(String[] args) {
        Solution1272 sol = new Solution1272();
        int[][] intervals;
        int[] toBeRemoved;
        List<List<Integer>> res;

        intervals = new int[][]{{0,2},{3,4},{5,7}};
        toBeRemoved = new int[]{1,6};
        res = sol.removeInterval(intervals, toBeRemoved);
        System.out.println(Arrays.deepToString(res.toArray()));
    }
}

class Solution1272 { // 48 - 52
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < toBeRemoved[0] || interval[0] > toBeRemoved[1]) {
                res.add(Arrays.asList(interval[0], interval[1]));
            } else {
                if (interval[0] < toBeRemoved[0]) {
                    res.add(Arrays.asList(interval[0], toBeRemoved[0]));
                }
                if (interval[1] > toBeRemoved[1]) {
                    res.add(Arrays.asList(toBeRemoved[1], interval[1]));
                }                
            }
        }
        return res;
    }
}
// tc: o(n), sc: o(1), sweeping line method