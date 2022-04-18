/*
Method 1. Dijkstra
tc: o(klogk)
sc: o(n2 + k) - visited + minheap size
*/
class Solution1 {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.val == c2.val) {
                    return 0;
                }
                return c1.val - c2.val;
            }
        });
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for (int i = 1; i < k; i++) {
            Cell tmp = minHeap.poll(); // expand
            int tmpx = tmp.x;
            int tmpy = tmp.y;
            
            if (tmpx + 1 < row && !visited[tmpx + 1][tmpy]) {
                minHeap.offer(new Cell(tmpx + 1, tmpy, matrix[tmpx+1][tmpy]));
                visited[tmpx + 1][tmpy] = true;
            }
            if (tmpy + 1 < col && !visited[tmpx][tmpy + 1]) {
                minHeap.offer(new Cell(tmpx, tmpy + 1, matrix[tmpx][tmpy+1]));    
                visited[tmpx][tmpy + 1] = true;
            }
        }
        return minHeap.poll().val;
    }
}

class Cell {
    int x, y, val;
    public Cell(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

/* Method 2 Merge sort
Regard each line as sorted int[] array;
TC: O(n + klogn)
sc: O(n) - minheap size
*/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }
}
/*
作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/
*/

/* Method 3 Binary search
TC: O(n log(mat[n-1][n-1] - mat[0][0])) - not as good as prev methods
Find 



*/
class Solution3 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
/*
作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/
*/