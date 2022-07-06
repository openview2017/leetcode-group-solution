public class main1049 {
    
}

class Solution1046 {
    public int lastStoneWeightII(int[] stones) {
        // 把石头分成两堆要求两堆重量尽可能接近；定义一个容量为sum/2的01背包
        int sum=0;
        for(int stone:stones) sum+=stone;
        int v=sum/2;
        int[]dp=new int[v+1];
        int n=stones.length;
        for(int i=0;i<n;i++){
            for(int j=v;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-2*dp[v]; 
    }
}

/*
定义 f[i][j]f[i][j] 代表考虑前 ii 个物品（数值），凑成总和不超过 jj 的最大价值。
2,7,4,1,8,1

(4-2)
[(4-2),7,1,8,1]

[(4-2),(8-7),1,1]

[(4-2 - 8+7),1,1]

[(4-2 - 8+7 - 1),1]

4,7,1  ----- 2,8,1
*/