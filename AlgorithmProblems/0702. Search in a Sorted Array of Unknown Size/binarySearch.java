/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        // 1. 当没有超界，而且right上的value小于target时，扩展left和right的边界
        // corner case是：只有一个element，但此时right直接就是index为1，所以一来就超界了。
        // 这个corner case在下面的binary search里面处理。
        while (reader.get(right) != Integer.MAX_VALUE && reader.get(right) < target) { 
            
            left = right;
            right = 2 * right;
        }

        return binarySearch(reader, left, right, target);
    }
    private int binarySearch(ArrayReader reader, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //如果mid超界，说明其实right一来就超界了，需要在这里处理
            //直接让right = mid - 1
            //然后下面继续找
            if (reader.get(mid) == Integer.MAX_VALUE || reader.get(mid) > target) {
                right = mid - 1;
            } else if (reader.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}