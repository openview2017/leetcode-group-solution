public class main0975 {
    
}


class Solution { // 52 - 07, tc:o(nlogn), sc: o(n)
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        int count = 1;
        boolean[][] dp = new boolean[n][2]; // [i][0]-odd->[greater][1], [i][1]-even->[smaller][0]
        TreeMap<Integer, Integer> idxMap = new TreeMap<>();
        idxMap.put(arr[n-1], n-1); // !!!!!!
        dp[n-1][0] = true;        
        dp[n-1][1] = true;
        for (int i = n-2; i >= 0; i--) {
            // greater search, ood step
            Integer cKey = idxMap.ceilingKey(arr[i]); // greater
            //Integer nextGreater = map.ceilingKey(A[i]);
            Integer fKey = idxMap.floorKey(arr[i]);     // smaller
            if (cKey != null) {
                dp[i][0] = dp[idxMap.get(cKey)][1];
            }
            if (fKey != null) {
                dp[i][1] = dp[idxMap.get(fKey)][0];
            }
            if (dp[i][0]) {
                count++;
            }
            idxMap.put(arr[i], i);
        }
        return count;
    }
}
/*abstract

https://leetcode.com/problems/odd-even-jump/discuss/217974/Java-solution-DP-%2B-TreeMap

*/