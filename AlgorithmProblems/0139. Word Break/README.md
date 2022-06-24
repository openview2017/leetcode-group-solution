# 139. Word Break 单词划分

[Word Break - LeetCode](https://leetcode.com/problems/word-break/)

Same as [LintCode 107](https://www.lintcode.com/problem/107/)

划分型动态规划，问一个字符串能否被划分为词典里的若干单词

```python
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true

Input: s = "leetcode", wordDict = ["lee","code"]
Output: false
```

## DP

State: `dp[i]` 表示前 i 个字符是否可以被划分成若干个单词

Induction Rule:

- dp[i]=  true if any ( dp[j] && check(s[j..i−1]) ) is true,  for  j ∈ [0, i)

Initialization:

- `dp[0] = true`
- `dp[1…n] = false`

Complexity Analysis:

- Time Complexity: $O(n^2)$
- Space Complexity: O(n)

```python
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s:
            return True
        
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True
        word_set = set(wordDict)
        
        for i in range(1, n + 1):
            for j in range(i):
                if not dp[j]:
                    continue
                word = s[j:i]
                if word in word_set:
                    dp[i] = True
                    break
        return dp[n]
```

Java

```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) {
            return true;
        }
        
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        HashSet<String> wordSet = new HashSet<>(wordDict);
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                
                String word = s.substring(j, i);
                if (wordSet.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}
```

## DP - 优化 O(n * L)

- 因为此题与单词有关，考虑到单词一般不会太长（英文单词平均长度为 5.6 个 letter），
- 所以对于 j，只需要看到最长的单词的长度就足够了
- 可优化到优化 O(n * L)
  - L: 最长单词的长度

Python
```python
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s:
            return True
        
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True
        word_set = set(wordDict)
        max_length = max([len(word) for word in word_set])
        
        for i in range(1, n + 1):
            for l in range(1, max_length + 1):
                if i < l:
                    break
                if not dp[i - l]:
                    continue
                word = s[i - l:i]
                if word in word_set:
                    dp[i] = True
                    break
        return dp[n]
```

Java
```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) {
            return true;
        }
        
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        HashSet<String> wordSet = new HashSet<>(wordDict);
        
        int maxLength = 0;
        for (String word: wordSet) {
            maxLength = Math.max(maxLength, word.length());
        }
        
        for (int i = 1; i <= n; i++) {
            for (int l = 1; l <= maxLength; l++) {
                if (i < l) break;
                if (!dp[i - l]) continue;
                
                String word = s.substring(i - l, i);
                if (wordSet.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}
```