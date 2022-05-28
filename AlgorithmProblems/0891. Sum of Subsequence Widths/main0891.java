import java.util.*;

public class main0891 {
    public static void main(String[] args) {
        Solution0891 sol = new Solution0891();
        int[] nums;
        int res;
        
        nums = new int[]{2,1,3};
        res = sol.sumSubseqWidths(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
    }
}


class Solution0891 {
    public int sumSubseqWidths(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);

        long[] pow2 = new long[N];
        pow2[0] = 1;
        for (int i = 1; i < N; ++i)
            pow2[i] = pow2[i-1] * 2 % MOD;

        long ans = 0;
        for (int i = 0; i < N; ++i)
            ans = (ans + (pow2[i] - pow2[N-1-i]) * A[i]) % MOD; // uplimit and down limit

        return (int) ans;
    }
}

/*abstract

Example 1:

Input: nums = [2,1,3]
Output: 6
Explanation: The subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
The sum of these widths is 6.
Example 2:

Input: nums = [2]
Output: 0
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105

*/