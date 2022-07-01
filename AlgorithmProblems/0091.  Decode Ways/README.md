# **91. Decode Ways**
[Decode Ways - LeetCode](https://leetcode.com/problems/decode-ways/); Same as [LintCode 512](https://www.lintcode.com/problem/512/)


有一个消息包含`A-Z`通过以下规则编码

```
'A' -> 1
'B' -> 2
...
'Z' -> 26
```

现在给你一个加密过后的消息，问有几种解码的方式

```java
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
```

------

问方案总数，**划分型（前缀型）动态规划**. See also, [LeetCode 139. Work Break](https://github.com/openview2017/leetcode-group-solution/tree/main/AlgorithmProblems/0139.%20Word%20Break)

State: `dp[i]` 表示前 i 个字符有多少种解码方式

Induction Rule:

- `dp[i] = dp[i - 1] * decodeOK(最后1个字符) + dp[i - 2] * decodeOK(最后2个字符)`

- `decodeOK()` 返回 1 如果可以decode，否则返回 0
  - "0" 不行，"01" 不行，"27" 不行，
  - "1" 可以，"10" 可以

Initialization:

- dp[0] = 1
- dp[1] 第一个字符的解码方案数

Return：

- dp[n], if n ≥ 1
- 0, if n = 0

Complexity Analysis:

- Time Complexity: O(n)
- Space Complexity: O(1)

Python

```python
class Solution:
    def numDecodings(self, s: str) -> int:
        if not s:
            return 0
        
        n = len(s)
        
        dp = [1, 0, 0]  
        dp[1] = self.decode_able(s[0])
        
        for i in range(2, n+1):
            dp[i % 3] = dp[(i -1) % 3] * self.decode_able(s[i - 1: i]) + \
                dp[(i - 2) % 3] * self.decode_able(s[i - 2: i])
    
    
        return dp[n % 3]
    
    def decode_able(self, substr):
        code = int(substr)
        
        if len(substr) == 1 and 1 <= code <= 9:
            return 1
        
        if len(substr) == 2 and 10 <= code <=26:
            return 1
    
        return 0
```

Java

```java
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        
        int[] dp = new int[3];
        
        dp[0] = 1;
        dp[1] = decodeAble(s.substring(0, 1));
        
        for (int i = 2; i <= n; i++) {
             dp[i % 3] = dp[(i -1) % 3] * decodeAble(s.substring(i - 1, i)) + 
                dp[(i - 2) % 3] * decodeAble(s.substring(i - 2, i));
        }
        
        return dp[n % 3];
        
    }
    
    private int decodeAble(String substr) {
        int code = Integer.parseInt(substr);
        int len = substr.length();
        
        if (len == 1 && code >= 1 && code <= 9) return 1;
        if (len == 2 && code >= 10 && code <= 26) return 1;
        return 0;
    }
}
```

