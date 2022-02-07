/*
从右往左看，目前为止最高的的building是多少
然后building的高度大于目前为止最高的，就可以。
O(n)

Runtime: 2 ms, faster than 98.85% of Java online submissions for Buildings With an Ocean View.
Memory Usage: 55.4 MB, less than 69.71% of Java online submissions for Buildings With an Ocean View.

*/

class Solution {
    public int[] findBuildings(int[] heights) {
        if (heights == null || heights.length == 0) {
            return new int[1];
        }
        int n = heights.length;
        
        List<Integer> res = new ArrayList<>();
        res.add(n - 1);
        
        int curMax = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (heights[i] > curMax) {
                curMax = heights[i];
                res.add(i);
            }
        }
        int resLength = res.size();
        int[] result = new int[resLength];
        
        int j = 0;
        for (int i = resLength - 1; i >= 0; i--) {
            result[i] = res.get(j);
            j++;
        }
        return result;
        
    }
}

/*
right to left, highest
highest: 4 2 3 1
origin:  4 2 3 1
0, 2, 3

highest: 4 3 2 1
origin:  4 3 2 1 
res: 0, 1, 2, 3

highest: 4 4 4 4
origin:  1 3 2 4
res: 3
*/