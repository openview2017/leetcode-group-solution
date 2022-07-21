class Solution0790:
    def numTilings(self, n: int) -> int:
        # state0 -> 都空
        # state1 -> 第一行有瓷砖
        # state2 -> 第二行有瓷砖
        # state3 -> 都有瓷砖
        # 初始化考虑只有一列
        dp = [1, 0, 0, 1]
        for i in range(2, n+1):
            dpn = [0, 0, 0, 0]
            dpn[0] = dp[3]
            dpn[1] = dp[0] + dp[2]
            dpn[2] = dp[0] + dp[1]
            dpn[3] = dp[0] + dp[1] + dp[2] + dp[3]
            dp = dpn 
        return dp[3] % (10**9 + 7)

# 作者：DreamerDiWu
# 链接：https://leetcode.cn/problems/domino-and-tromino-tiling/solution/dong-tai-gui-hua-zhuang-tai-ya-suo-by-dr-j0a0/
# 来源：力扣（LeetCode）
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。