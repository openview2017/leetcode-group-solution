import java.util.LinkedList;
import java.util.Queue;

public class main1210 {
    public static void main(String[] args) {
        Solution1210 sol = new Solution1210();

        int[][]grid = {{0,0,0,0,0,1},
               {1,1,0,0,1,0},
               {0,0,0,0,1,1},
               {0,0,1,0,1,0},
               {0,1,1,0,0,0},
               {0,1,1,0,0,0}};
        int res = sol.minimumMoves(grid);
        System.out.println(res);
    }
}


class Solution1210 {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        int step = 0;
        
        // 0: 水平方向是否访问过， 1: 垂直方向是否访问过
        boolean[][] visited = new boolean[n*n][2];
        // pos： x = pos / n, y = pos %n; 
        // director: 0 ,水平 1，垂直
        //Pair<Integer, Integer> pair = new Pair<>(1, 0);
        int[] pair = new int[]{1,0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(pair);
        // pos
        visited[1][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size(); 
            
            for (int i = 0; i < size; i++) {
                int[] curPair = queue.poll();
                int pos = curPair[0];
                int x = pos / n;
                int y = pos % n;
                int dir = curPair[1];

                if (x == n - 1 && y == n - 1 && dir == 0) {
                    return step;
                }
                // 蛇在水平方向
                if (dir == 0) {
                    // 向右移动
                    if (y + 1 < n && grid[x][y + 1] == 0 && !visited[pos + 1][0]) {
                        queue.add(new int[]{pos + 1, 0});
                         visited[pos +1][0] = true;

                    }
                    // 顺时针旋转90
                    if (x + 1 < n && grid[x + 1][y] == 0 && grid[x + 1][y - 1] == 0 && !visited[pos + n - 1][1]) {
                visited[pos + n - 1][1] = true;

                        queue.add(new int[]{pos + n - 1, 1});
                    }
                    // 整体向下平移
                    if (x + 1 < n && grid[x + 1][y] == 0 && grid[x + 1][y - 1] == 0 && !visited[pos + n][0]) {
                visited[pos + n][0] = true;

                        queue.add(new int[]{pos + n, 0});
                    }
                }

                // 蛇在竖直方向
                if (dir == 1) {
                    // 向下移动
                    if (x + 1 < n && grid[x + 1][y] == 0 && !visited[pos + n][1]) {
                        queue.add(new int[]{pos + n, 1});
                visited[pos + n][1] = true;

                    }
                    // 逆时针旋转90
                    if (y + 1 < n && grid[x][y + 1] == 0 && grid[x - 1][y + 1] == 0 && !visited[pos + 1 - n][0]) {
                visited[pos - n + 1][0] = true;

                        queue.add(new int[]{pos - n + 1, 0});
                    }
                    // 整体向右平移
                    if (y + 1 < n && grid[x][y + 1] == 0 && grid[x - 1][y + 1] == 0 && !visited[pos + 1][1]) {
                visited[pos + 1][1] = true;

                        queue.add(new int[]{pos + 1, 1});
                    }
                }
            }
            step++;
        }

        return -1;

    }
}