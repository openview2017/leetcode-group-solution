class Solution1099 {
public:
    int twoSumLessThanK(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int i = 0, j = nums.size() - 1;
        int maxSum = -1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum >= k) {
                j--;
            } else {
                maxSum = max(maxSum, sum);
                i++;
            }
        }
        return maxSum;
    }
};