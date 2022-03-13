import java.util.*;

public class main1610 {
    public static void main(String[] args) {
        int[][] ps;
        int[] o;
        int angle, res;
        List<List<Integer>> points;
        List<Integer> location;
        Solution1610 sol = new Solution1610();

        ps = new int[][]{{2,1},{2,2},{3,3}}; angle = 90; o = new int[]{1,1};
        System.out.println(Arrays.deepToString(ps));
        System.out.println(Arrays.toString(o));
        System.out.println(angle);

        points = new ArrayList<>();
        for (int[] p : ps) {
            List<Integer> tmp = new ArrayList<>();
            for (int x : p) {
                tmp.add(x);
            }
            points.add(tmp);
        }
        location = new ArrayList<>();
        location.add(o[0]);
        location.add(o[1]);
        res = sol.visiblePoints(points, angle, location);
        System.out.println(res);
    }
}

class Solution1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0;
        for (List<Integer> p : points) {
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx == 0 && dy == 0) { // edge case of same point
                count++;
                continue;
            } 
            angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
        }
        Collections.sort(angles);
        List<Double> tmp = new ArrayList<>(angles);
        // System.out.println(Arrays.toString(tmp.toArray()));
        
        for (double d : angles) tmp.add(d + 360); // concatenate to handle edge case
        // System.out.println(Arrays.toString(tmp.toArray()));

        int res = count;
        for (int i = 0, j = 0; i < tmp.size(); i++) {
            while (tmp.get(i) - tmp.get(j) > angle) {
                j++;
            }
            res = Math.max(res, count + i - j + 1);
        }
        return res;
    }
}