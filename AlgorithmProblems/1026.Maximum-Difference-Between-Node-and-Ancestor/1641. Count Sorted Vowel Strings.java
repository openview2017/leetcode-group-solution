
class Solution0 {
    // 定义dp[n][5]数组，其中dp[i][0-4]表示长度为i的以a-u结尾的字符串的个数，递推关系见代码。
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][5];

        for (int i=0;i<5;i++){
            dp[1][i]=1;
        }
/*  0 1 2 3 4
    a e i o u
 0 
 1  1 1 1 1 1
 2  1 2 3 4 5  = 15
 3        10,15

*/
        for (int i=2;i<=n;i++){
            //长度i的以u结尾的字符串可以由任意一个长度i-1的字符串结尾加个u得到
            // +u
            dp[i][4]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2]+dp[i-1][3]+dp[i-1][4];
            // +o
            dp[i][3]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2]+dp[i-1][3];
            // +i
            dp[i][2]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2];
            dp[i][1]=dp[i-1][0]+dp[i-1][1];
            //长度i的以a结尾的字符串只能由长度i-1的以a结尾的字符串结尾加个a得到
            dp[i][0]=dp[i-1][0];
        }

        //最终答案求个和就行啦
        return dp[n][0]+dp[n][1]+dp[n][2]+dp[n][3]+dp[n][4];
    }
}


/*
 两重循环，复杂度为O（n）

长度为 i 且以第 j 个元音为结尾的字符串数量 = 长度为 i - 1 且以小于等于 j 元音为结尾的字符串数量的和

dp[i][j]保存的状态为 长度为 i 且以大于等于 j 元音为结尾的字符串数量的和

所以有状态转移方程

dp[i][j] =dp[i-1][j] +dp[i][j-1];
*/
class Solution {

    public int countVowelStrings(int n) {
        int[][] ans = new int[n+1][5];
        if(n == 0) return 0;
        if(n == 1) return 5;
        ans[1][0] = 1;
        ans[1][1] = 2;
        ans[1][2] = 3;
        ans[1][3] = 4;
        ans[1][4] = 5;
        for(int i = 2; i <= n; i++) {
            for(int j = 0;j < 5; j++) {
                if(j == 0) 
                    ans[i][j] = ans[i-1][j];
                else
                    ans[i][j] = ans[i-1][j] + ans[i][j-1];
            
            }
        }
        return ans[n][4];
        
    }

}

/*
Use 5-1 board to separate n characters
Hence, the count equals to choose 4 locations among n+4 possible locations = 
(n+4,4) = (n+4)*(n+3)*(n+2)*(n+1)/24;


*/
class Solution2 {
    public int countVowelStrings(int n) {    
        return (n+4)*(n+3)*(n+2)*(n+1)/24;
    }
}