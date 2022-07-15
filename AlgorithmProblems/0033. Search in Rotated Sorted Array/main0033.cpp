#include <iostream>
#include <string>
#include<vector>
using namespace std;


class main0033 {
public:
    int search(vector<int>& array, int target) {
        int left = 0;
        int right = array.size()-1;  
        int mid = 0;
        while (left < right - 1)  {// check left, right at the end
            mid = left + (right - left) / 2;
            if (array[left] == target) {
                return left;
            } 
            if (array[mid] == target) {
                return mid;
            } 
            if (array[right] == target) {
                return right;
            }  
            if (array[left] < array[mid]) { // left mono increasing
                if (target < array[left] || target > array[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else if (array[mid] < array[right]) { // right mono increasing
                if (target < array[mid] || target > array[right]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        if (array[left] == target) {
            return left;
        }
        if (array[right] == target) {
            return right;
        }
        return -1;        
    }
};

int main() {
    main0033 sol;
    int n[] = {4,5,6,7,0,1,2};
    int target = {0};
    vector<int> nums(n,n+7);
    int res = sol.search(nums, target);
    cout << res;
    return 0;
};