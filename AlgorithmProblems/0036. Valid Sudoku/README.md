# **36. Valid Sudoku**

[Valid Sudoku - LeetCode](https://leetcode.com/problems/valid-sudoku/); [See also: 0037. Sudoku Solver](https://github.com/openview2017/leetcode-group-solution/tree/main/AlgorithmProblems/0037.%20Sudoku%20Solver)

数独规则：

1. 数字 `1-9` 在每一行只能出现一次。
2. 数字 `1-9` 在每一列只能出现一次。
3. 数字 `1-9` 在每一个以粗实线分隔的 `3x3` 宫内只能出现一次

输入：2 * 2 矩阵

- 一个有效的数独（部分已被填充）不一定是可解的。
- 只需要根据规则，验证已经填入的数字是否有效即可。
- 空白用 `'.'` 表示。

# 数组计数 - 1 Pass Solution

使用三个数组，分别记录行，列，宫

对于数组中的一个格子 (i, j), 其

- row：floor(i / 3)
- col：floor(j / 3)

Complexity Analysis:

- Time Complexity: O(1)
- Space Complexity: O(1)

Java

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] boxes = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int number = c - '0' - 1;
                    rows[i][number]++;
                    columns[j][number]++;
                    boxes[i / 3][j / 3][number]++;
                    
                    if (rows[i][number] > 1 || columns[j][number] > 1 || boxes[i / 3][j / 3][number] > 1) {
                        return false;
                    }
                    
                }
            }
        }
        return true;
    }
}
```

# Python , Bitmask

```python
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        N = 9
        # Use binary number to check previous occurrence
        rows = [0] * N
        cols = [0] * N
        boxes = [0] * N

        for r in range(N):
            for c in range(N):
                # Check if the position is filled with number
                if board[r][c] == ".":
                    continue

                number = int(board[r][c]) - 1

                if rows[r] & (1 << number):
                    return False
                rows[r] |= (1 << number)

                if cols[c] & (1 << number):
                    return False
                cols[c] |= (1 << number)

                idx = (r // 3) * 3 + c // 3
                if boxes[idx] & (1 << number):
                    return False
                boxes[idx] |= (1 << number)

        return True
```

