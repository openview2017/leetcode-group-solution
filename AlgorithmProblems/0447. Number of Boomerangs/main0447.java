import java.util.*;

public class main0447 {
    public static void main(String[] args) {
        Solution0447 sol = new Solution0447();
        int[][] points;
        int res;

        points = new int[][]{{0,0},{1,0},{2,0}};
        res = sol.numberOfBoomerangs(points);
        System.out.println(Arrays.deepToString(points));
        System.out.println(res);
        System.out.println();

    }
}

class Solution0447 { // tc/sc: o(n2)
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> distFreq = new HashMap<>();
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            distFreq = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int dist = getDist(points[i], points[j]);
                distFreq.put(dist, distFreq.getOrDefault(dist, 0) + 1);
            }
            for (int distCount : distFreq.values()) {
                count += distCount * (distCount - 1);
            }
            //distFreq.clear();
        }
        return count;
    }
    
    private int getDist(int[] a, int[] b){
    	int dx = a[0] - b[0];
    	int dy = a[1] - b[1];
    	return dx * dx + dy * dy;
    }
}