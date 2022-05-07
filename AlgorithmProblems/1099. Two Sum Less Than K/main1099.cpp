#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

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

int main() {
    vector<int> nums{34,23,1,24,75,33,54,8};
    int k = 60;
    Solution1099 sol;
    int res = sol.twoSumLessThanK(nums, k);
    cout << res << endl;
    return -1;
}

// nums = [34,23,1,24,75,33,54,8], k = 60