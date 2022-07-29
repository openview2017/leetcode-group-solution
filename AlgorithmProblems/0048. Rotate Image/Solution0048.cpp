# include<vector>
# include<iostream>
using namespace std;

class Solution0048 {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int level = 0;
        while (level < n / 2) {
            for (int i = level; i < n - 1 - level; i++) {
                int tmp = matrix[level][i];
                matrix[level][i] = matrix[n-1-i][level]; // 1- , 7|
                matrix[n-1-i][level] = matrix[n-1-level][n-1-i]; // 7\, 9-
                matrix[n-1-level][n-1-i] = matrix[i][n-1-level]; //9-. 3|
                matrix[i][n-1-level] = tmp;
            }
            level++;
        }
        return;
    }
};