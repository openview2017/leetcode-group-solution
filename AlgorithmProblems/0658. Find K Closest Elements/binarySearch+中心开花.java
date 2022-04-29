/*
总结：
step1: find closest
step2: 中心开花
TC: O(logn + k)
SC: o(1)

唯一注意：在中心开花的过程中注意left and right index out of bound 的cases讨论。
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0 || k < 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int left = findClosest(arr, x); // step1: find closest
        int right = left + 1;
        for (int i = 0; i < k; i++) {
            if (right >= arr.length) {  // case1: 因为right是left + 1，所以case1 是right超界了
                result.add(arr[left]);
                left--;
            } else if (left < 0) {  // case2: 如果right没超界，那么left超界了
                result.add(arr[right]);
                right++;
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {  // case3:到这里left和right都没超界，正常判断
              result.add(arr[left]);
              left--;
            } else { // case4: else
                result.add(arr[right]);
                right++; 
            }
        }
        Collections.sort(result);
        return result;
    }
    private int findClosest(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) { // 出来while的时候剩2个elements
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) { // 最后出来判断是左边还是右边更近
            return left;
        } else {
            return right;
        }
    }
}
