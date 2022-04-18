import java.util.*;

public class main0939 {
    public static void main(String[] args) {
        Solution0939 sol = new Solution0939();
        int[][] p;
        int area;

        p = new int[][]{{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
        area = sol.minAreaRect(p);
        System.out.println(Arrays.deepToString(p));
        System.out.println(area);
    }
}


class Solution0939 { // 19 - 26, tc/sc: o(n2)
    public int minAreaRect(int[][] p) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p1 : p) {
            map.putIfAbsent(p1[0], new HashSet<>());
            map.get(p1[0]).add(p1[1]);
        }
        int area = Integer.MAX_VALUE;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (i == j || p[i][0] == p[j][0] || p[i][1] == p[j][1]) continue;
                if (map.get(p[i][0]).contains(p[j][1]) && map.get(p[j][0]).contains(p[i][1])) {
                    area = Math.min(area, Math.abs(p[i][0] - p[j][0]) * Math.abs(p[i][1] - p[j][1]));
                }
            }
        }
        return area == Integer.MAX_VALUE? 0 : area;
    }
}