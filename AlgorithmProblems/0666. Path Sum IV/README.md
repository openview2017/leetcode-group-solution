# 666. Path Sum IV

输入：`int[]`

- int array 中的数字都是三位数
- 百位表示在树中的深度
- 十位表示该 node 在该层中的位置
- 个位表示该 node 的值
- 输入已经排序

Constraints:

- 树的高度不会超过5，i.e. ≤ 4. 2^3 = 8, 如果深度超过 5 的话，一位数就表示不了了。
- node value v 取值为  `0 <= v <= 9`，同理

输出：

- 树中所有的 root 到 leaf 的 path sum 的和

```
Input: nums = [113,215,221]
Output: 12

The path sum is (3 + 5) + (3 + 1) = 12
```

<img src="https://assets.leetcode.com/uploads/2021/04/30/pathsum4-1-tree.jpg" alt="Untitled" style="zoom:50%;" />

# DFS

- 无法用常规的 `left, right` 指针来遍历左右子节点，但是可以通过父节点的编号直接计算出子节点的编号，从而确定子节点。

- 如果父节点在行中的编号为 `x`

  - 则左子节点为下一行的 `2 * x - 1`
  - 右子节点为下一行的 `2 * x`

- 然后就可以 DFS 了

Complexity Analysis:

- Time Complexity: O(n)
- Space Complexity: O(n)

```java
class Solution {
    public int pathSum(int[] nums) {
        HashMap<Integer, Integer> tree = new HashMap<>();
        int[] result = new int[1];
        
        // 建图
        for (int code: nums) {
            int value = code % 10; // 取出个位
            code = code / 10;
            tree.put(code, value);
        }
        
        int root = nums[0] / 10;
        dfs(root, 0, result, tree);
        return result[0];
    }
    
    private void dfs(int code, int sum, int[] result, HashMap<Integer, Integer> tree) {
        if (!tree.containsKey(code)) {
            return;
        }
        
        int value = tree.get(code);
        int[] pos = decode(code);
        
        int depth = pos[0];
        int id = pos[1];
        
        int leftCode = encode(depth + 1, id * 2 - 1);
        int rightCode = encode(depth + 1, id * 2);
        
        if (!tree.containsKey(leftCode) && !tree.containsKey(rightCode)) {
            result[0] += sum + value;
            return;
        }
        dfs(leftCode, sum + value, result, tree);
        dfs(rightCode, sum + value, result, tree);                
        
    }
    
    // 将 (depth, id) 编码为十进制两位数
    private int encode(int depth, int id) {
        return 10 * depth + id;
    }

    // 解码出 (depth, id)
    private int[] decode(int code) {
        return new int[]{code / 10, code % 10};
    }
}
```