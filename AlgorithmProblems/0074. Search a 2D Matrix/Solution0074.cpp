#include <iostream>
#include <string>
#include <vector>
using namespace std;


class Solution0074 {
public:
  bool searchMatrix(vector<vector<int>>& matrix, int target) {
    if (matrix.empty()) return false;
    int l = 0;
    int r = matrix.size() * matrix[0].size();
    const int cols = matrix[0].size();
    while (l < r) {
      const int m = l + (r - l) / 2;
      if (matrix[m / cols][m % cols] == target) {
        return true;
      } else if (matrix[m / cols][m % cols] > target) {
        r = m;
      } else {
        l = m + 1;
      }
    }
    return false;
  }
};

int main() {
    Solution0074 sol;

    vector<vector<int>> vect
    {
        {1,3,5,7},
        {10,11,16,20},
        {723,30,34,60}
    }; 

    int target = 3;
    bool res = sol.searchMatrix(vect, target);
    cout << res;
}