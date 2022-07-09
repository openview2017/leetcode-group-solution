import java.util.Arrays;
import java.util.Random;

public class main0973 {
    public static void main(String[] args) {
        Solution0973 sol = new Solution0973();
        int[][] points, res;
        int k;

        points = new int[][]{{1,3},{-2,2}};
        k = 1;
        res = sol.kClosest(points, k);
        System.out.println(Arrays.deepToString(res));

        points = new int[][]{{3,3},{5,-1},{-2,4}};
        k = 2;
        res = sol.kClosest(points, k);
        System.out.println(Arrays.deepToString(res));
    }
}

class Solution0973 {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length - 1, k-1);
        return Arrays.copyOfRange(points, 0, k);
    }
    
    private void quickSelect(int[][] points, int left, int right, int k) {
        Random rand = new Random();
        int pivot = left + rand.nextInt(right - left + 1);
        int pivotDist = getDist(points[pivot]);
        swap(points, pivot, right);
        int l = left, r = right - 1;
        while (l <= r) {
            if (getDist(points[l]) < pivotDist) {
                l++;
            } else {
                swap(points, l, r--);
            }
        }
        swap(points, l, right);
        if (l < k) {
            quickSelect(points, l+1, right, k);
        } else if (l > k) {
            quickSelect(points, left, l-1, k);
        }
        return;
    }
    
    private int getDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    private void swap(int[][] points, int i, int j) {
        int[] tmp = new int[2];
        tmp[0] = points[i][0];        
        tmp[1] = points[i][1];
        points[i][0] = points[j][0];        
        points[i][1] = points[j][1];
        points[j][0] = tmp[0];        
        points[j][1] = tmp[1];
     }
}