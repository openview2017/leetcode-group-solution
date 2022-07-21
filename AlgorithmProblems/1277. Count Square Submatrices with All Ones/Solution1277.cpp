#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int countSquares(vector<vector<int>>& matrix) {
        int sum = 0;
        int row = matrix.size();
        int col = matrix[0].size();
        vector<vector<int>> dp(row+1, vector<int>(col+1, 0));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    dp[i+1][j+1] = 0;
                } else {
                    dp[i+1][j+1] = min(min(dp[i][j+1], dp[i+1][j]), dp[i][j]) + 1;
                    sum += dp[i+1][j+1];
                }
                
            }
        }
        return sum;
    }
};