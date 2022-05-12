import java.util.*;

public class main0986 {
    public static void main(String[] args) {
        Solution0986 sol = new Solution0986();
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        int[][] res = sol.intervalIntersection(firstList, secondList);
        System.out.println(Arrays.deepToString(res));
    }
}

class Solution0986 { // 42 - 47
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        int m = firstList.length, n = secondList.length;
        while (i < m && j < n) {
            int left = Math.max(firstList[i][0], secondList[j][0]);     
            int right = Math.min(firstList[i][1], secondList[j][1]);
            if (left <= right) {
                res.add(new int[]{left, right});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}