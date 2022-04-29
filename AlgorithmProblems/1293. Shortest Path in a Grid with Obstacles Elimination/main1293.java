/*
1293. Shortest Path in a Grid with Obstacles Elimination
Hard

You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

 

Example 1:


Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
Output: 6
Explanation: 
The shortest path without eliminating any obstacle is 10.
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).


*/


    //bfs, layer
//visited[i][j] - #o_passed,     m*n from 0,0 to i,j
// Integer_maxvalue  r*c
// status queue: {r,c,o_passed},  {r,c,obstacle}   (steps)

// init {0,0,0} 
// queue<int[]>  size
// layer  
//      1. reach destination, return steps
//      2. r,c next UDLR 
//           a. outofrange continue
//           b. status[2] + grid[nxtr][nxtc] > k || visited[nxtr][nxtr] not min continue
//           c. update and put to queue

// return visited[r-1][c-1] > r*c-1 ? -1 : steps
      
// tc: o(v+E) -> o(rc + k*r*c) - o(r*C)
// sc: o(rc)  -> o(rc)
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class main1293 {
    public static void main(String[] args) {
        Solution1293 sol = new Solution1293();
        int[][] grid;
        int k, res;

        grid = new int[][]{{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        k = 1;
        res = sol.shortestPath(grid, k);
        System.out.println(Arrays.deepToString(grid));
        System.out.println("k : " + k);
        System.out.println(res);
    }
}


class Solution1293 { // 34 - 50

    public static final int[][] DIRS = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int shortestPath(int[][] grid, int k) {
        int r = grid.length, c = grid[0].length;
        int[][] visited = new int[r][c]; // min o used
        for (int[] arr : visited) {
            Arrays.fill(arr, r*c);
        }
        Deque<int[]> queue = new ArrayDeque<>();
        // 1. init
        int steps = 0;
        visited[0][0] = 0;
        queue.offerLast(new int[]{0,0,0}); // rloc, cloc, obs used
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] tmp = queue.pollFirst();
                if (tmp[0] == r-1 && tmp[1] == c-1) {
                    return steps;
                }
                for (int[] dir : DIRS) {
                    int nxtR = tmp[0] + dir[0];
                    int nxtC = tmp[1] + dir[1];
                    if (!isValid(r,c,nxtR, nxtC)) {
                        continue;
                    }
                    int nxtO = tmp[2] + grid[nxtR][nxtC];
                    if (nxtO > k || visited[nxtR][nxtC] <= nxtO) { // > not working
                        continue;
                    }
                    visited[nxtR][nxtC] = nxtO; // 00 -> curLocation, min obstacles
                    queue.offerLast(new int[]{nxtR, nxtC, nxtO});
                }   
            }
            steps++;
        }
        return -1;
        //return visited[r-1][c-1] >= r*c ? -1 : steps;
    }
    
    private boolean isValid(int row, int col, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col) {
            return false;
        }
        return true;
    }
}

//bfs visited[][] - m*n from 0 to i,j
// {r,c,o_left}
// init {0,0,k} 
// queue<int[]>
//      reach, steps
//      next UDLR 
//           a. outofrange continue
//           b.k<=0 || visited[i][j] not min continue
//           c. update and put to queue
// return visited[r-1][c-1] > r*c-1 ? -1 : visited[r-1][c-1]
// tc: o(v+E) -> o(rc)
// sc: o(rc)
