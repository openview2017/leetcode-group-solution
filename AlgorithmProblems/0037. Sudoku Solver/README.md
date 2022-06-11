# 37. Sudoku Solver

[37. Sudoku Solver - LeetCode](https://leetcode.com/problems/sudoku-solver/); 

See also [leetcode-group-solution/AlgorithmProblems/0036. Valid Sudoku at main](https://github.com/openview2017/leetcode-group-solution/tree/main/AlgorithmProblems/0036. Valid Sudoku)

---

*Ziheng Gong - June 9th 2022*

数独规则：

1. 数字 `1-9` 在每一行只能出现一次。
2. 数字 `1-9` 在每一列只能出现一次。
3. 数字 `1-9` 在每一个以粗实线分隔的 `3x3` 宫 (sub-grid) 内只能出现一次

输入：3 * 3 矩阵

- 空白用 `'.'` 表示。

输出：

- in-place，在矩阵上填好所有数字
- 保证，有且仅有一个解

## DFS Backtracking

- DFS，一行一行的填所有的空格，搜索所有的可能性，每次填写时，都要满足数组的规则。
- 填到最后一个格子时，看看得到的解是否有效。

Time Complexity: $O(9^{9 \times 9})$

### DFS - N-queen Generalization

与 n 皇后比：

- 一行只放一个皇后，一行放了一个之后就去下一行；此题，每行不知道有多少个 blank，需要先检查 blank（有障碍的皇后）
- 皇后需要检查行，列，对角线；此题需要检查行，列，宫 (sub-grid)

宫的计算：

![](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e938b49b-e0a0-4e97-b778-366769763bc5/image.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220610%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220610T044034Z&X-Amz-Expires=86400&X-Amz-Signature=b03ab07ee7a7ef59b867d967219b6fd0db9772a97ea4ce29837045b7508d4561&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22image.jpg%22&x-id=GetObject)



Java

```java
class Solution {
    public void solveSudoku(char[][] board) {
        // 保证有解
        dfs(board);
    }

    private boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') { // blank
                    // 看看 9 个数里能放啥到这个 blank 里
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (isValid(board, i, j, digit)) {
                            board[i][j] = digit;
                            if (dfs(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    // 如果 1-9 都不能填入这个格子
                    return false;
                }
            }
        }
        // 填完了所有的空
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char digit) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit) return false; // 检查同一行
            if (board[i][col] == digit) return false; // 检查同一列            
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == digit)
                return false;
        }

        return true;
    }
}
```

Runtime:

```
Runtime: 19 ms, faster than 44.20% of Java online submissions for Sudoku Solver.

Memory Usage: 41.3 MB, less than 65.04% of Java online submissions for Sudoku Solver.
```



## DFS - Array

[解数独 - 解数独 - 力扣（LeetCode）](https://leetcode.cn/problems/sudoku-solver/solution/jie-shu-du-by-leetcode-solution/)

Pre-processing,先扫描一遍 matrix

- 把所有的 blank 添加到 `List<int[]> blank` 中，之后 DFS 时使用这个 `blank`
- 把所有的数字 `x`，其位置 `(i, j)`，更新 rows[i][x - 1], cols[j][x-1], boxes[i/3][j/3][x-1] 设置为 true

然后开始 DFS，对 `blank` 中的每个 blank：

- 当前层：
  - 对每个 blank (i, j), 尝试放入数字 1 - 9 (x)
  - valid check:  放入数字时 rows[i][x - 1], cols[j][x-1], boxes[i/3][j/3][x-1] 必须为 False
  - 放入了一个数字后，将上述三个值设为 true
- 进入下一层
- 将上述三个值设为 false

```java
class Solution {
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][][] boxes = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> blank = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    blank.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    rows[i][digit] = true;
                    cols[j][digit] = true;
                    boxes[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if (pos == blank.size()) {
            valid = true;
            return;
        }

        int[] space = blank.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            if (!rows[i][digit] && !cols[j][digit] && !boxes[i / 3][j / 3][digit]) {
                rows[i][digit] = cols[j][digit] = boxes[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                rows[i][digit] = cols[j][digit] = boxes[i / 3][j / 3][digit] = false;
            }
        }
    }
}
```

Run time

```
Runtime: 4 ms, faster than 96.84% of Java online submissions for Sudoku Solver.
Memory Usage: 41.9 MB, less than 39.82% of Java online submissions for Sudoku Solver.
```

## DFS Optimize -  Bitmask

Idea：

- 使用一个整数表示每个数字是否出现过，每个 int 的第 i 位的 binary 表示一个 boolean
- eg. `011000100` 表示数字 3 7 8 已经出现过
- 将 rows cols 从  boolean[9][9] 压缩到 int[9]

Bit tricks:

-  `!rows[i][digit] && !cols[j][digit] && !boxes[i / 3][j / 3][digit]`  → `~(rows[i] | cols[j] | boxes[i / 3][j / 3]) & 0x1ff`
-  todo....

```java
class Solution {
    private int[] rows = new int[9];
    private int[] cols = new int[9];
    private int[][] boxes = new int[3][3];
    private boolean valid = false;
    private List<int[]> blank = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    blank.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    flip(i, j, digit);
                }
            }
        }

        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if (pos == blank.size()) {
            valid = true;
            return;
        }

        int[] space = blank.get(pos);
        int i = space[0], j = space[1];
        int mask = ~(rows[i] | cols[j] | boxes[i / 3][j / 3]) & 0x1ff; // 0b111111111
        for (; mask != 0 && !valid; mask &= (mask - 1)) {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip(i, j, digit);
            board[i][j] = (char) (digit + '0' + 1);
            dfs(board, pos + 1);
            flip(i, j, digit);
        }
    }

    public void flip(int i, int j, int digit) {
        // XOR
        // False ^ True = True
        // True ^ False = False
        rows[i] ^= (1 << digit);
        cols[j] ^= (1 << digit);
        boxes[i / 3][j / 3] ^= (1 << digit);
    }
}
Runtime: 4 ms, faster than 96.84% of Java online submissions for Sudoku Solver.
Memory Usage: 41.3 MB, less than 65.04% of Java online submissions for Sudoku Solver.
```



## N-queen Generalization

*Yingqi Luo,  Feb 9 2022* 

```java
class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    
    //物理意义：当前的board，with当前填过的数，是否有一个valid的填剩下的方法。
    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (helper(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false; // 说明对于当前这个位置，1-9填进去，都不会有一个最后return true的，那这整个只能return false了
                }
            }
        }
        //最后，又没return true，又没return false，是什么情况呢？
        //说明都填完了，没有进入到10行；然后也没有任何一个空格的地方return了false。那就可以return true，相当于填完了
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
            if (board[i][col] == num) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
```