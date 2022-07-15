public class main0719 {
    
}

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = (int)1e6;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(nums, mid) >= k) r = mid;
            else l = mid + 1;
        }
        return r;
    }
    int check(int[] nums, int x) {
        int n = nums.length, ans = 0;
        for (int i = 0, j = 1; i < n; i++) {
            while (j < n && nums[j] - nums[i] <= x) j++;
            ans += j - i - 1;
        }
        return ans;
    }

// 作者：AC_OIer
// 链接：https://leetcode.cn/problems/find-k-th-smallest-pair-distance/solution/by-ac_oier-o4if/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}