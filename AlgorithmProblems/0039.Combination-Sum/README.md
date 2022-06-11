# Combination Sum

[39. Combination Sum - LeetCode](https://leetcode.com/problems/combination-sum/)

[40. Combination Sum II - LeetCode](https://leetcode.com/problems/combination-sum-ii/)

[216. Combination Sum III - LeetCode](https://leetcode.com/problems/combination-sum-iii/)

[377. Combination Sum IV - LeetCode](https://leetcode.com/problems/combination-sum-iv/)


## 39. Combination Sum
[39. Combination Sum - LeetCode](https://leetcode.com/problems/combination-sum/)

输入：array 和 target

- array 中为 distinct 元素

输出

- 所有能 sum 成 target 的子元素的 unique combination
- combination 不能重复，但是每个元素可以用多次
- order 不重要

```
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
```

**DFS**

只要还能加，就考虑对 array 中的每个元素加或不加

Complexity Analysis:

- Time Complexity: $O(n \times 2^n)$
- Space Complexity: O(target) - call stack

*Yingqi Luo - Feb 1 2022*; *Ziheng Gong - June 10th*

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, cur, result);
        return result;
    }
    private void helper(int[] candidates, int target, int index, List<Integer> cur, List<List<Integer>> result) {
        // base case
        if (index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(cur));
            }
            return;
        }
        
        // recursion rule
        helper(candidates, target, index + 1, cur, result);
        int value = candidates[index];
        int size = cur.size();
        while (target - value >= 0) {
            cur.add(value);
            target = target - value;
            helper(candidates, target, index + 1, cur, result);
            
        }
        cur.subList(size, cur.size()).clear();
    }
}
```

## 40. Combination Sum II

https://leetcode.com/problems/combination-sum-ii/

输入：array 和 target

- array 中的元素可能重复

输出

- 所有能 sum 成 target 的子元素的 unique combination
- combination 不能重复，每个元素只能使用一次
- 输出的 order 不重要

```
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[ [1,1,6], [1,2,5], [1,7], [2,6] ]
```

**DFS Solution**

- 对输入先排序
- 对 array 中的每个元素，探索加或不加
- 如果不加，那么跳过所有的相同的元素

Complexity Analysis: n 为数组的长度

- Time Complexity: $O(2^n \cdot n)$
  - worst case: 数组中每个树都不相同，且所有元素的和加起来都不满足 target，那么 2^n 中 combination 都会被遍历到。
  - n 为输出答案的时间
- Space Complexity: O(n) - call stack

*Yingqi Luo - Feb 1 2022*; *Ziheng Gong - June 10th*

```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, cur, result, 0);
        return result;
    }
    private void dfs(int[] candidates, int target, List<Integer> cur, List<List<Integer>> result, int index) {
        // base case
        if (target == 0) {
            result.add(new ArrayList(cur));
            return;
        }
        
        if (target < 0 || index >= candidates.length) {
            return;
        }
        
        // case 1: add the current element
        cur.add(candidates[index]);
        dfs(candidates, target - candidates[index], cur, result, index + 1);
        cur.remove(cur.size() - 1); // cur list还原
        //target = target + candidates[index]; // target 还原 其实这里不用变他，用的是本轮的 parameter 的 target 即可。
        
        // case 2: not add the current element, also skip all same elements
        while (index + 1 < candidates.length && candidates[index + 1] == candidates[index]) { // 
            index++;
        }
        
        dfs(candidates, target, cur, result, index + 1); //从不相等的index位置往下走
    }
}
```


## 216. Combination Sum III

[216. Combination Sum III - LeetCode](https://leetcode.com/problems/combination-sum-iii/)

输入：n 和 k

- n： sum 的目标
- k：可以使用数字 1-9， 共 k 个数字，每个数字可以使用一次

输出

- *所有可能的有效组合的列表*
- 不能包含相同的组合两次
- 输出的 order 不重要

```
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
```

------

相当于对集合$S = \{ 1,2,3,4,5,6,7,8,9 \}$, 找出大小为 k，和为 n 的子集。

DFS：

- 对每个数字，选择加与不加
- how many levels: there're 1 to 9, a total of 9 levels
- what does each level mean: use or not to use the current level value

Complexity Analysis:

- Time Complexity: $O(2^9 \cdot 9)$
- Space Complexity: O(9) - call stack

*Yingqi Luo - Feb 1 2022*; *Ziheng Gong - June 10th*

```java
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(k, n, cur, result, 1);
        return result;
    }

    // n: target,  k digits
    private void helper(int k, int n, List<Integer> cur, List<List<Integer>> result, int index) {
        if (cur.size() == k) {
            if (n == 0) {
                result.add(new ArrayList(cur));
            }
            return;
        }
        if (index == 10 || n < 0) {
            return;
        }
        
        cur.add(index);
        helper(k, n - index, cur, result, index + 1);
        cur.remove(cur.size() - 1);
        
        helper(k, n, cur, result, index + 1);
    }
}
```



## 377. Combination Sum IV

[377. Combination Sum IV - LeetCode](https://leetcode.com/problems/combination-sum-iv/)

输入：nums, target

- nums: distinct 整数组成的数组

输出：总和为 target 的组合的个数

- 同样的数字，但是如果顺序不一样，那么视作不同的组合
- 组合中可以重复使用同一个数字

```java
输入：nums = [1,2,3], target = 4
输出：7
所有可能的组合为： 顺序不同的序列被视作不同的组合
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
```

尽管名字里带 combination，但是其实是一道 permutation 问题，因为 nums 中每个元素可以选取多次，且要考虑选取元素的顺序。

 *Ziheng Gong - June 10th*

### DFS w/ memo, buttom up

![Untitled.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/a92383c9-cb75-4bca-8396-f44e14902d88/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220611%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220611T023009Z&X-Amz-Expires=86400&X-Amz-Signature=547a564e0183b35acb7c6a80b26b0cfca59aee20e8d8a6d90b6a52c4367aec86&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

- 观察 Recursion Tree，发现很多很多重复计算
- 实现的时候，使用 remaining

Complexity Analysis:

- Time Complexity: O(n * m)
  - n, target value
  - m, size of array
- Space Complexity: O(n)

Base Case:

- sum 0: {}
- sum 1: 1, 如果数组中有 1 的话

Induction：

$$ \text{memo}[target] = \sum_{i}^{\text{nums.lenth - 1} } \text{memo}[target - i] $$

```python
class Solution(object):
    def combinationSum4(self, nums, target):
        memo = [-1] * (target + 1)
        memo[0] = 1
        return self.dfs(nums, target, memo)

    def dfs(self, nums, target, memo):
        if target < 0: 
            return 0
        if memo[target] != -1:
            return memo[target]
        res = 0
        for num in nums:
            res += self.dfs(nums, target - num, memo)
        memo[target] = res
        return res
```

### DP

Complexity: same as DFS w/ memo

```python
class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        memo = dict()
        memo[0] = 1
        
        for total in range(1, target + 1):
            memo[total] = 0
            for n in nums:
                memo[total] += memo.get(total - n, 0)
        
        return memo[target]
```





*Yingqi Luo - Feb 1 2022*

```java
class Solution {
    public int combinationSum4(int[] nums, int target) {
        // corner case check
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= target; i++) {  // i represents the target so far
            for (int j = 0; j < nums.length; j++) { // j represents the index of the current nums, so we have 0...j index values
                if (i >= nums[j]) {
                    dp[i]+= dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
```