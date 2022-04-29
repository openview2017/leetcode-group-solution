import java.util.*;

/*
954. Array of Doubled Pairs
Medium

Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.

 

Example 1:

Input: arr = [3,1,3,6]
Output: false
Example 2:

Input: arr = [2,1,2,6]
Output: false
Example 3:

Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 

Constraints:

2 <= arr.length <= 3 * 104
arr.length is even.
-105 <= arr[i] <= 105


*/

public class main0954 {
    public static void main(String[] args) {
        Solution0954 sol = new Solution0954();
        boolean res;
        int[] arr;

        arr = new int[]{3,1,3,6};
        res = sol.canReorderDoubled(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);

        arr = new int[]{2,1,2,6};
        res = sol.canReorderDoubled(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);
    }
}



class Solution0954 { // 28 - 38
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> freqMap = new TreeMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        for (int key : freqMap.keySet()) {
            // if (key < 0 && key % 2 != 0) {
            //     return false;
            // }
            int target = (key < 0 ? key / 2 : key * 2);
            int keyCount = freqMap.get(key);
            if (keyCount == 0) continue;
            if ((key < 0 && key % 2 != 0) || !freqMap.containsKey(target)) return false;
            int targetCount = freqMap.get(target);
            if (keyCount > targetCount) {
                return false;
            }
            freqMap.put(target, targetCount - keyCount);
        }
        return true;
    }
}
// tc: o(n + klogk) ~ o(n)