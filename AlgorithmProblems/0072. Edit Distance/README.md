# 72. Edit Distance

[72. Edit Distance - LeetCode](https://leetcode.com/problems/edit-distance/); same as LaiCode 100

Given two strings `word1` and `word2`, return *the minimum number of operations required to convert `word1` to `word2`*.

You have the following three operations permitted on a word:

- Insert a character
- Delete a character
- Replace a character

```java
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
```

------

## DFS w/ Memo

eg. `editDistance(asdf, sghj)`

1. 不用操作                                                               3:3

2. Replace: a → s

   `a sdf`  `s sdf`   editDistance(sdf, ghj) + 1                3:3

3. Delete: 不能两边都删

   `asdf`  `sghj`      editDistance(sdf, sghj) + 1               3:4

4. Insert:

   `s asdf` `s ghj`  editDistance(asdf, ghj) + 1               4:3

Tree:

- m + n 层
- 三个叉（不操作和 replace 子问题是一样的）

Complexity Analysis:

- Time Complexity: $O(3 ^{m+n})$
- Space Complexity: O(m + n)

Python

```python
class Solution:
    def minDistance(self, one: str, two: str) -> int:
        memo = dict()
        result = self.dfs(one, two, memo)
        return result

    def dfs(self, one, two, memo):
        if not one:
            return len(two)

        if not two:
            return len(one)

        if (one[1:], two[1:]) not in memo:
            memo[(one[1:], two[1:])] = self.dfs(one[1:], two[1:], memo)
        if (one[1:], two) not in memo:
            memo[(one[1:], two)] = self.dfs(one[1:], two, memo)
        if (one, two[1:]) not in memo:
            memo[(one, two[1:])] = self.dfs(one, two[1:], memo)

        if one[0] == two[0]:
            replace = 0 + memo[(one[1:], two[1:])]
        else:
            replace = 1 + memo[(one[1:], two[1:])]

        delete = 1 + memo[(one[1:], two)]
        insert = 1 + memo[(one, two[1:])]

        return min(replace, delete, insert)
```

## DP

**State:**

- `M[i][j]` represent the minimum edit distance to change `s1` with size `i` to `s2` with size `j`

**Base Case**

- `M[0][0] = 0`
- `M[0][j] = j`
- `M[i][0] = i`

**Induction Rule**

- if `s1[i] == s2[j]`,  `M[i][j] = M[i-1][j-1]`

- if `s1[i] != s2[j]`, ` M[i][j]= min( M[i-1][j-1], M[i-1][j],  M[i][j-1] )`
                                                                                              *左上 replace     正上 delete     正左 insert* 

**Case Analyse**

1. 不用操作，直接匹配
   - s1 = s1_remaining + “a”       size = i
   - s2 = s2_remaining + “a”    size = j
   - 剩余需要匹配：`M[i-1][j-1]`
2. Replace
   - s1 = s1_remaining + “s”       size = i
   - s2 = s2_remaining + “a”     size = j
   - 剩余需要匹配：`M[i-1][j-1] + 1`
3. Delete
   - s1 = s1_remaining + “s”       size = i
   - s2 = s2_remaining + “a”     size = j
   - 剩余需要匹配：`M[i-1][j] + 1`
4. Insert
   - s1 = s1_remaining + “a” + “s”       size = i
   - s2 = s2_remaining +          “s”       size = j
   - 剩余需要匹配：`M[i][j-1] + 1`

Time Complexity: O(m * n)

Space Complexity: O(m * n)

- can beoptimized to O(min(m, n)): 只需要记录 (i-1,j-1) (i-1, j) (i, j-1)

Python

```python
class Solution(object):
    def editDistance(self, one, two):
        distance = [
            [0 for _ in range(len(two) + 1)]
            for _ in range(len(one) + 1)
        ]

        for i in range(0, len(one) + 1):
            for j in range(0, len(two) + 1):
                if i == 0:
                    distance[i][j] = j
                elif j == 0:
                    distance[i][j] = i
                elif one[i-1] == two[j-1]:
                    distance[i][j] = distance[i-1][j-1]
                else:
                    distance[i][j] = min(
                        distance[i-1][j-1] + 1,
                        distance[i-1][j] + 1,
                        distance[i][j-1] + 1,
                    )
        return distance[-1][-1]
```