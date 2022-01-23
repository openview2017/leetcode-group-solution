


# 378. Kth Smallest Element in a Sorted Matrix
```java
class Solution {
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


```