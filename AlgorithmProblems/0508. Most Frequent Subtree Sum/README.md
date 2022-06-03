# **508. Most Frequent Subtree Sum**

508 出现次数最多的子树元素和 [508. Most Frequent Subtree Sum - LeetCode](https://leetcode.com/problems/most-frequent-subtree-sum/)

输入：Binary Tree

输出：

- 出现次数最多的子树元素和
- 如果有多个「子树元素和」出现的次数相同，返回所有（顺序无所谓）

子树元素和：以该结点为根的二叉树上所有结点的元素之和（包括本身）

# DFS

bottom up, 左右自

- Use a hashMap `count` to count the subtree sum occurrence.
- A sub function `dfs(TreeNode node)` will travel through a tree, recursively calculate the sum of subtree,increment the `count`, and finally return the sum of the sub tree.

Java

```java
class Solution {

    public int[] findFrequentTreeSum(TreeNode root) {
        //   value   frequence
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        int[] max_freq = new int[1];
        dfs(root, counter, max_freq);
        List<Integer> result = new ArrayList<>();
        
        for (int s : counter.keySet()) {
            if (counter.get(s) == max_freq[0])
                result.add(s);
        }
        
        // List<Integer> -> int[]
        return result
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();

        /* 或者
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }            
        */
    }
		// 求解以 root 为根节点的当前子树的 sum
    private int dfs(TreeNode root, Map<Integer, Integer> counter, int[] max_freq) {
        if (root == null) {
            return 0;
        } 
        int leftSum =  dfs(root.left, counter, max_freq);
		int rightSum =  dfs(root.right, counter, max_freq);
        int val = leftSum + rightSum + root.val;
        
        counter.put(val, counter.getOrDefault(val, 0) + 1);
        max_freq[0] = Math.max(max_freq[0], counter.get(val));
        
        return val;
    }
}
```

Python

```python
class Solution:
    def findFrequentTreeSum(self, root):   
        if not root: 
            return []
        
        counter = collections.Counter()
        self.tree_sum(root,counter)    
        max_freq = max(counter.values())        
        
        return [s for s in counter.keys() if counter[s] == max_freq]   
       
    
    def tree_sum(self, root, counter):
        if not root:
            return 0
        
        s = root.val + self.tree_sum(root.left,counter) + self.tree_sum(root.right,counter)
        counter[s] += 1
        return s
```

