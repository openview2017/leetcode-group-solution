# 51. N-Queens

[N-Queens - LeetCode](https://leetcode.com/problems/n-queens/), see also [LaiCode 233](https://app.laicode.io/app/problem/233?plan=3)

给一个 n，表示 n x n 矩阵，问在这个矩阵上放 n 个皇后，有几种摆法

LeetCode 输出与 LaiCode 不一样：eg. n = 4

- LeetCode： `[[".Q..","...Q","Q...","..Q."], ["..Q.","Q...","...Q",".Q.."]]`
- LaiCode：`[[1,3,0,2], [2,0,3,1]]`



## DFS

*Ziheng Gong - June 9th 2022*

<img src="233%20N%20Queens%203de1fc8e633b4cf98391b4ffb0941e0e/Untitled.png"   />

- 红色Code
- 8 × 8 的国际象棋棋盘上放置八个皇后，使得任何两个皇后都无法互相攻击

**DFS:**

- how many levels?
  
    8 levels, each level represent a possible position for 1 queen
    
- how many branches?
  
    at most 8 positions.
    
- recursion tree diagram
  
    ![233%20N%20Queens%203de1fc8e633b4cf98391b4ffb0941e0e/Untitled%201.png](233%20N%20Queens%203de1fc8e633b4cf98391b4ffb0941e0e/Untitled%201.png)
    
    level 0: 第一个 branch：Queen 0 放在位置 (0,0); 第二个 branch：Queen 0 放在位置 (0,1) ...
    
    level 1: 第一个 branch：Queen 1 放在位置 (0,0); 第二个 branch：Queen 1 放在位置 (0,1) ...
    
    ...
    

**Time Complexity**: $O(8^8)$ × 8 

- 在说 TC 时不考虑剪枝...
- 如果是「n 皇后」问题：$O(n^n)$ × n
- 可优化到 $O(n!)$

**Implementation:**

- 不需要使用二维矩阵来模拟棋盘：
    - 每个皇后只有可能在一行中的一个位置上，所以使用 array[8] 就可以表示每个皇后的位置。
    - array[8] 的 index 表示第几行，array[index]表示该 queen 被放在了第几列。
- `currentRow`:
    - the row where we are inserting a new queen into
    - 第几个皇后，i.e. 第几层
- for loop `i`：表示在当前层上，正在尝试的状态
    - `i = 0`: 尝试放在第 0 列；`i = 1`: 尝试放在第 1 列 ...
- `pass_the_check()` , 以 currentRow 为 4 时为例：
    - 需要检查 queen 4 是否与 queen 3 2 1 0 冲突，i.e. 上层 level 的已经放好的四个 queens
    - 如果 array[4] 与 array[3] array[2] array[1] array[0] 里的任何一个数值相同，表示放在了同一列  →  冲突
    - 如果 (4 - 3) / (array[4] - array[3]), (4 - 2) / (array[4] - array[2]) ... 为 1，既斜率为 1，表示放在了对角线  →  冲突
- Base Case: the last row is done, 0 row left
- Recursive Rule: iff position(i, j) valid -> go to the next row (i + 1)


Time Complexity: O(n!*n)

- n 层 n 个叉，每个 node 检查也是 n

Space Complexity: O(n)

```python
class Solution:
	def solveNQueens(self, n):

		result = []
		self.dfs(n , [], result)
		
		output = []
		template = ["."] * n
		
		for sol in result:
				temp = []
				for position in sol:
						ans = template.copy()
						ans[position] = "Q"
						temp.append("".join(ans))
				output.append(temp)            
		
		return output
	
	def dfs(self, n, solution, result):
		if len(solution) == n:
			result.append(solution.copy())
			return

		for i in range(n):
			if self.is_valid(i, solution):
				solution.append(i)
				self.dfs(n, solution, result)
				solution.pop()
		
	def is_valid(self, new_col, solution):
		new_row = len(solution)
		for exist_row in range(len(solution)):
			exist_col = solution[exist_row]
			if exist_col == new_col or abs(new_col - exist_col) == new_row - exist_row:
				return False
		
		return True
```

Java

*Yingqi Luo - Feb 23 2022*

```java
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(n, cur, res);
        return res;
    }
    
    private void helper(int n, List<Integer> cur, List<List<String>> res) {
        if (cur.size() == n) {
            res.add(convert(cur));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(cur, i)) {
                cur.add(i);
                helper(n, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private List<String> convert(List<Integer> list) {
        List<String> res = new ArrayList<>();
        int n = list.size();
        char[][] board = new char[n][n];
        
        for (char[] b : board) {
            Arrays.fill(b, '.');
        }

        int row = 0;
        for (int i : list) {
            board[row++][i] = 'Q';
        }
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }

    private boolean isValid(List<Integer> cur, int col) {
        // i, cur.get(i); size, col; row, col
        int size = cur.size();
        for (int i = 0; i < size; i++) {
            // isvalid里面这里的判断条件时最关键的。
            if (col == cur.get(i) || Math.abs(i - size) == Math.abs(cur.get(i) - col)) {
                return false;
            }  
        }
        return true;
    }
}
```