# 300. Longest Increasing Subsequence

最长递增子序列

```
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
```

## DP

*June 13 2022 - Yang Xi* 

- 状态：

  - dp[i] 为考虑前 i 个元素，包括 nums[i], 最长上升子序列的长度

- 状态转移方程：

  - Lieaner Scan, 回头看所有
  - 只要 nums[i] 严格大于在它位置之前的某个数，那么 nums[i] 就可以接在这个数后面形成一个更长的上升子序列。

  - $$ dp[i] = \max_{0 \le j < i,\  \text{nums[j] < nums[i]}} {dp[j] + 1} $$

- 初始化：
  - 初始化整个 dp array 为 1，1 个字符显然是长度为 1 的上升子序列

Complexity Analysis:

- Time Complexity: $O(n^2)$
- Space Complexity: O(n)

Python

```python
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1 for _ in range(len(nums))]
        
        for i in range(len(nums)):
          for j in range(i):
            if nums[j] < nums[i] and dp[i] < dp[j] + 1:
              dp[i] = dp[j] + 1
        
        return max(dp)
```

Java

```java
import java.util.Arrays;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
```

