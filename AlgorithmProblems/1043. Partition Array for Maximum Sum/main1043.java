public class main1043 {
    
}

class Solution1043 { // 12 - 22
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        // int[] dp = new int[len + 1];
        int[] dp = new int[k];
        for (int i = 1; i <= len; i++) { // length 
            int best = 0, valMax = 0;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                valMax = Math.max(valMax, arr[i-j]);
                best = Math.max(best, valMax * j + dp[(i-j)%k]);
            }
            dp[i%k] = best;
        }
        return dp[arr.length%k];
    }
}

/* k = 3
       i
0 1 2  3 4 5 6 7
j  
1,15,7 ,9,2,5,10
0, 1,30,45

window size j = 1, 2, ... ,k
sliding window max: 15
best 7*1+30 = 37
    15*2+1 = 31
    15*3+0 =45

*/