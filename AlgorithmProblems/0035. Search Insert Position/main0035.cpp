
#include <iostream>
#include <string>
#include<vector>
using namespace std;


class main0035 {
  public:
  int searchInsert(vector<int>& nums, int target) {
    int pivot, left = 0, right = nums.size() - 1;
    while (left <= right) {
      pivot = left + (right - left) / 2;
      if (nums[pivot] == target) return pivot;
      if (target < nums[pivot]) right = pivot - 1;
      else left = pivot + 1;
    }
    return left;
  }
};

int main() {
    main0035 sol;
    int n[] = {1,3,5,6};
    int target = {5};
    vector<int> nums(n,n+4);
    int res = sol.searchInsert(nums, target);
    cout << res;
    return 0;
};