import java.util.*;

/*
978. Longest Turbulent Subarray

给定一个整数数组 arr ，返回 arr 的 最大湍流子数组的长度 。

如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是 湍流子数组 。

更正式地来说，当 arr 的子数组 A[i], A[i+1], ..., A[j] 满足仅满足下列条件时，我们称其为湍流子数组：

若 i <= k < j ：
当 k 为奇数时， A[k] > A[k+1]，且
当 k 为偶数时，A[k] < A[k+1]；
或 若 i <= k < j ：
当 k 为偶数时，A[k] > A[k+1] ，且
当 k 为奇数时， A[k] < A[k+1]。
 

示例 1：

输入：arr = [9,4,2,10,7,8,8,1,9]
输出：5
解释：arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
示例 2：

输入：arr = [4,8,12,16]
输出：2
示例 3：

输入：arr = [100]
输出：1
 

提示：

1 <= arr.length <= 4 * 104
0 <= arr[i] <= 109

*/

public class main0978 {
    public static void main(String[] args) {
        int[] arr;
        int res;
        Solution978_1 sol = new Solution978_1();

        arr = new int[]{9,4,2,10,7,8,8,1,9};
        res = sol.maxTurbulenceSize(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);
        System.out.println();

        arr = new int[]{4,8,12,16};
        res = sol.maxTurbulenceSize(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);
        System.out.println();
        
        arr = new int[]{100};
        res = sol.maxTurbulenceSize(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);
    }
}

// method dp
class Solution978_1 {
    public int maxTurbulenceSize(int[] arr) {
        // dp0 last desc, dp1 last increase, ret result max length so far
        int dp0 = 1, dp1 = 1, ret = 1;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i-1]) {
                dp1 = dp0 + 1;
                dp0 = 1;
            } else if (arr[i] > arr[i-1]) {
                dp0 = dp1 + 1;
                dp1 = 1;
            } else {
                dp1 = 1;
                dp0 = 1;
            }
            ret = Math.max(dp0, ret);
            ret = Math.max(ret, dp1); // the end is not always largest, need to calculate every step
        }
        return ret;
    }
}

class Solution978_2 { // two point, tc: o(n), sc: o(1)
    public int maxTurbulenceSize(int[] arr) {
        int l = 0, r = 0;
        int res = 1;
        while (r < arr.length - 1) {
            if (l == r) {
                if (arr[l] == arr[l+1]) {
                    l++;
                }
                r++;
            } else {
                if (arr[r-1] > arr[r] && arr[r] < arr[r+1]) {
                    r++;
                } else if (arr[r-1] < arr[r] && arr[r] > arr[r+1]) {
                    r++;
                } else {
                    l = r;
                }
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}