#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution0740 {
public:
    int deleteAndEarn(vector<int>& nums) {
        int maxNum = 0;
        for (int i = 0; i < nums.size(); i++) {
            maxNum = max(maxNum, nums[i]);
        }
        vector<int> sums(maxNum+1, 0);        
        vector<int> dp(maxNum+1, 0);
        for (int i = 0; i < nums.size(); i++) {
            sums[nums[i]] += nums[i];
        }
        dp[1] += sums[1];
        for (int i = 2; i < maxNum+1; i++) {
            dp[i] = max(dp[i-2] + sums[i], dp[i-1]);
        }
        return dp[maxNum];
    }
};

int main() {
    Solution0740 sol;
    vector<int> nums{3,4,2};
    int res = sol.deleteAndEarn(nums);
    cout << res << endl;
}