# LintCode 437 · 书籍复印

[437 · 书籍复印 - LintCode](https://www.lintcode.com/problem/437/)

输入：

- `List[int]` ：`n` 本书，第 `i` 本书有 `pages[i]`页。
- 有 `k` 个人来抄这些书。

题干：

- 这些书排成一行，每个人都可以索取连续一段的书。例如，一个抄书人可以连续地将书从第 

- 第 i 册复制到第 j 册，但是他不能复制第 1 册、第 2 册和第 4 册（没有第 3 册）。

  - sub array, 不是 sub sequence

- 他们在同一时间开始抄书，每抄一页书都要花 1 分钟。为了让最慢的抄书人能在最早的时间完成书的分配，最好的策略是什么？

输出：`int` 最终需要的时间。

```java
输入: pages = [3, 2, 4], k = 2
输出: 5
解释: 第一个人复印前两本书, 耗时 5 分钟. 第二个人复印第三本书, 耗时 4 分钟.
pages = [3,2,1,1,1,1], k = 3
output: 3
```

------

## DP

划分型动态规划

State: `dp[i][j]`: 前 i 本书分给 j 个人，最少花多少时间完成所有的复印工作

Induction Rule:

```
 dp[i][j] = min(dp[i][j], max(dp[prev][j - 1],  sum{pages[prev...i - 1]} ) )
```

Initialization:

- `dp[0][i] = 0`
- 其他初始化为正无穷

Return：`dp[n][k]`

Complexity Analysis:

- Time Complexity: $O(n^2 \cdot k)$
  - 可以用四边形不等式优化法将时间复杂度降低为 O(nk)，
  
- Space Complexity: $O(n \cdot k)$

Python

```python
class Solution:
    def copy_books(self, pages: List[int], k: int) -> int:
        if not pages or not k:
            return 0
        
        n = len(pages)
        prefix_sum = [0] * (n + 1)
        for i in range(1, n + 1):
            prefix_sum[i] = prefix_sum[i - 1] + pages[i - 1]

        dp = [[float('inf')] * (k + 1) for _ in range(n + 1)]

        for i in range(k + 1):
            dp[0][i] = 0

        for i in range(1, n + 1):
            for j in range(1, k + 1):
                for prev in range(i):
                    cost = prefix_sum[i] - prefix_sum[prev]
                    dp[i][j] = min(dp[i][j], max(dp[prev][j - 1], cost))
        
        return dp[n][k]
```
Java

```java
```




## Binary Search

Time Complexity: $O(n\log(sum))$

```python
class Solution:
    """
    @param pages: an array of integers
    @param k: An integer
    @return: an integer
    """
    def copyBooks(self, pages, k):
        if not pages:
            return 0
            
        start, end = max(pages), sum(pages)
        while start + 1 < end:
            mid = (start + end) // 2
            if self.get_least_people(pages, mid) <= k:
                end = mid
            else:
                start = mid
                
        if self.get_least_people(pages, start) <= k:
            return start
            
        return end
        
    def get_least_people(self, pages, time_limit):
        count = 0
        time_cost = 0 
        for page in pages:
            if time_cost + page > time_limit:
                count += 1
                time_cost = 0
            time_cost += page
            
        return count + 1
```

