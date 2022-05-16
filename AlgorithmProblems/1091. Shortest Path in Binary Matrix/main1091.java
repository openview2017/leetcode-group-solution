import java.util.*;

public class main1091 {
    public static void main(String[] args) {
        Solution1091 sol = new Solution1091();
        int[][] grid;
        int dist;

        grid = new int[][]{{0,1},{1,0}};
        dist = sol.shortestPathBinaryMatrix(grid);
        System.out.println(dist);
    }
}


class Solution1091 { // 03 - 18
    private static int[][] DIRS = new int[][]{{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) { // bfs
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        } // corner case 1 !!!!!!!!!!!!!!
        Deque<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.offerLast(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int curr = cur[0], curc = cur[1], curd = grid[curr][curc];
            if (curr == n-1 && curc == n-1) {
                return curd;
            }
            for (int[] next : getNext(curr, curc, grid)) {
                int nr = next[0], nc = next[1];
                grid[nr][nc] = curd + 1;
                queue.offerLast(new int[]{nr, nc});
            }
        }
        
        return grid[n-1][n-1] != 0 ? grid[n-1][n-1] : -1 ; // corner case 2 !!!!!!!!!!!!!!
    }
                                          
    private List<int[]> getNext(int r, int c, int[][] grid) {
        List<int[]> nexts = new ArrayList<>();
        int n = grid.length;
        for (int[] dir : DIRS) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || grid[nr][nc] != 0) {
                continue;
            }
            nexts.add(new int[]{nr, nc});
        }
        return nexts;
    }
}

class Solution1091_dijstra { // 03 - 18 dijstra, tc: o(nlogn)
    private static int[][] DIRS = new int[][]{{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) { // bfs
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        } // corner case 1 !!!!!!!!!!!!!!
        //Deque<int[]> queue = new ArrayDeque<>();
        Queue<int[]> queue = new PriorityQueue<int[]>((i1, i2) -> grid[i1[0]][i1[1]] - grid[i2[0]][i2[1]]);
        grid[0][0] = 1;
        // queue.offerLast(new int[]{0, 0});
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            //int[] cur = queue.pollFirst();
            int[] cur = queue.poll();
            int curr = cur[0], curc = cur[1], curd = grid[curr][curc];
            if (curr == n-1 && curc == n-1) {
                return curd;
            }
            for (int[] next : getNext(curr, curc, grid)) {
                int nr = next[0], nc = next[1];
                grid[nr][nc] = curd + 1;
                //queue.offerLast(new int[]{nr, nc});
                queue.offer(new int[]{nr, nc});
            }
        }
        
        return grid[n-1][n-1] != 0 ? grid[n-1][n-1] : -1 ; // corner case 2 !!!!!!!!!!!!!!
    }
                                          
    private List<int[]> getNext(int r, int c, int[][] grid) {
        List<int[]> nexts = new ArrayList<>();
        int n = grid.length;
        for (int[] dir : DIRS) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || grid[nr][nc] != 0) {
                continue;
            }
            nexts.add(new int[]{nr, nc});
        }
        return nexts;
    }
}