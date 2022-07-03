from typing import List


class Solution0322:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [0] + [amount+1]*amount
        for i in range(amount+1):
            for coin in coins:
                if i < coin:
                    continue
                dp[i] = min(dp[i], dp[i - coin] + 1)
        return dp[-1] if dp[-1] != amount + 1 else -1 