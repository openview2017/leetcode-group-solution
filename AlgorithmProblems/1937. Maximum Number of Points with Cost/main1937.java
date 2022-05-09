public class main1937 {
    
}

class Solution1937 { // 43 - 49x - 50
    public long maxPoints(int[][] points) {
        int row = points.length, col = points[0].length;
        long[] cur = new long[col];   // ending at cur[col]     
        long[] prev = new long[col];
        long[] left = new long[col];
        long[] right = new long[col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                left[c] = (c == 0) ? prev[c] : Math.max(prev[c], left[c-1]-1);
            }
            for (int c = col - 1; c >= 0; c--) {
                right[c] = (c == col-1) ? prev[c] : Math.max(prev[c], right[c+1]-1);
            } 
            for (int c = 0; c < col; c++) {
                cur[c] = points[r][c] + Math.max(left[c], right[c]);
            }            
            prev = cur;
        }
        long max = -1;
        for (int i = 0; i < col; i++) {
            max = Math.max(max, cur[i]);
        }
        return max;
    }
}