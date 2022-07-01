# 44. Wildcard Matching
Same as [LintCode 192](https://www.lintcode.com/problem/192/)

给定一个字符串 `s` 和一个字符模式 `p` ，实现一个支持 `'?'` 和 `'*'` 的通配符匹配。匹配规则如下：

- `'?'` 可以匹配任何单个字符。
- `'*'` 可以匹配任意字符串（包括空字符串）。

两个串完全匹配才算匹配成功。

```python
"aab"
"c*a*b"
输出: false
```

------

## DFS + Memo

Tree:

- 层：source 或 pattern 的较长者的长度
- 叉： 最多为 source 的长度

<<<<<<< HEAD
![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/83f38732-8c66-4e02-bf1f-0eff5522bf18/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220701%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220701T013206Z&X-Amz-Expires=86400&X-Amz-Signature=26eefe1167a253daa27db65b2c8999053ddd6291986a69ef54e6f420f95a10ce&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)
=======
![Untitled]([Untitled.png (1314×1257) (amazonaws.com)](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/83f38732-8c66-4e02-bf1f-0eff5522bf18/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220701%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220701T013206Z&X-Amz-Expires=86400&X-Amz-Signature=26eefe1167a253daa27db65b2c8999053ddd6291986a69ef54e6f420f95a10ce&X-Amz-SignedHeaders=host&response-content-disposition=filename %3D"Untitled.png"&x-id=GetObject))
>>>>>>> main

Python

```python
class Solution:

    def isMatch(self, source, pattern):
        return self.is_match_helper(source, 0, pattern, 0, {})
                
    # source 从 i 开始的后缀能否匹配上 pattern 从 j 开始的后缀
    # 能 return True
    def is_match_helper(self, source, i, pattern, j, memo):
        if (i, j) in memo:
            return memo[(i, j)]
            
        # source is empty
        if len(source) == i:
            # every character should be "*"
            for index in range(j, len(pattern)):
                if pattern[index] != '*':
                    return False
            return True
            
        if len(pattern) == j:
            return False
            
        if pattern[j] != '*': 
            matched = self.is_match_char(source[i], pattern[j]) and \\
                self.is_match_helper(source, i + 1, pattern, j + 1, memo)
        else:                
            matched = self.is_match_helper(source, i + 1, pattern, j, memo) or \\
                self.is_match_helper(source, i, pattern, j + 1, memo)
        
        memo[(i, j)] = matched
        return matched
        
        
    def is_match_char(self, s, p):
        return s == p or p == '?'
```

Java

```java
public class Solution {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        return isMatchHelper(s, 0, p, 0, memo, visited);
    }
    // 递归函数
		//
    private boolean isMatchHelper(String s, int sIndex,
                                  String p, int pIndex,
                                  boolean[][] memo,
                                  boolean[][] visited) {
				// 如果 s 或 p 是空：
        // 如果 p 从 pIdex 开始是空字符串了，那么 s 也必须从 sIndex 是空才能匹配上
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }
        
        // 如果 s 从 sIndex 是空，那么 p 必须全是 * 
        if (sIndex == s.length()) {
            return allStar(p, pIndex);
        }
        
        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }
        
        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean match;
        
        if (pChar == '*') {
            match = isMatchHelper(s, sIndex, p, pIndex + 1, memo, visited) ||
                isMatchHelper(s, sIndex + 1, p, pIndex, memo, visited);
        } else {
            match = charMatch(sChar, pChar) &&
                isMatchHelper(s, sIndex + 1, p, pIndex + 1, memo, visited);
        }
        
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }
    
    private boolean charMatch(char sChar, char pChar) {
        return (sChar == pChar || pChar == '?');
    }
    
    private boolean allStar(String p, int pIndex) {
        for (int i = pIndex; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
```

## DP

匹配型动态规划

- 题目通常给出两个字符串
- `dp[i][j]` 表示第一个字符串的前 i 个字符与第二个字符串的前 j 个字 符怎么样怎么样(max/min/sum/or)

State:

- `dp[i][j]`:  source 的前 i 个字符能否匹配上 pattern 的前 j 个字符

Induction Rule:

- 如果 `pattern[j - 1] == '*'`:  
  - `dp[i][j] = dp[i][j - 1] or dp[i - 1][j]`                                                                

- else: 
  - `dp[i][j] = dp[i - 1][j - 1] and isMatchChar(source[i - 1], pattern[j - 1])`   


Initialization：

- `dp[i][0] = false` (i > 0，第二个字符串为空，不能匹配任何字符串)
- `dp[0][i] = pattern`  前 i 个字符都是`*` （）

Complexity Analysis:

- Time Complexity: $O(n^2)$
- Space Complexity: $O(n^2)$

Python

```python
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        if s is None or p is None:
            return False
        
        n, m = len(s), len(p)
        
        dp = [ [False] * (m + 1) for _ in range(n+1)]
        
        dp[0][0] = True
        
        for i in range(1, m + 1):
            dp[0][i] = dp[0][i-1] and p[i - 1] == '*'
            
        
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if p[j-1] == '*':
                    dp[i][j] = dp[i - 1][j] or dp[i][j - 1]
                else:
                    dp[i][j] = dp[i - 1][j - 1] and (s[i - 1] == p[j - 1] or p[j -1] == '?') 
                    
        return dp[n][m]
```

Java

```java
public class Solution {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        int n = s.length(), m = p.length();
        
        // state
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        // initialization
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        
        // function
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (
                        s.charAt(i - 1) == p.charAt(j - 1) ||
                        p.charAt(j - 1) == '?'
                    );
                }
            }
        }
        
        return dp[n][m];
    }
}
```

## DP - 空间压缩

只回头看一行

Java

```java
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        int n = s.length(), m = p.length();
        
        // state
        boolean[][] dp = new boolean[2][m + 1];
        
        // initialization
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        
        // function
        for (int i = 1; i <= n; i++) {
            dp[i % 2][0] = false;  // ‼️‼️ 必须写这句话
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] || dp[i % 2][j - 1];
                } else {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] && (
                        s.charAt(i - 1) == p.charAt(j - 1) ||
                        p.charAt(j - 1) == '?'
                    );
                }
            }
        }
        
        return dp[n % 2][m];
    }
}
```

## Ref

- [通配符匹配・Wildcard Matching - 九章算法 (jiuzhang.com)](https://www.jiuzhang.com/solutions/wildcard-matching)
- [通配符匹配 - 通配符匹配 - 力扣（LeetCode）](https://leetcode.cn/problems/wildcard-matching/solution/tong-pei-fu-pi-pei-by-leetcode-solution/)