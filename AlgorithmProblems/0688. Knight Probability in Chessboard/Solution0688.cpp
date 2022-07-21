#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    double find(int n, int k, int r, int c, vector<vector<vector<double>>>& dp) {
        
        if (r < 0 || r >= n || c < 0 || c >= n) return 0.0;
        if (k == 0) return 1.0;
        if (dp[r][c][k] != 0) return dp[r][c][k];
        double p = find(n, k-1, r-2, c+1, dp) + find(n, k-1, r-1, c+2, dp) + 
                   find(n, k-1, r+1, c+2, dp) + find(n, k-1, r+2, c+1, dp) + 
                   find(n, k-1, r+2, c-1, dp) + find(n, k-1, r+1, c-2, dp) + 
                   find(n, k-1, r-1, c-2, dp) + find(n, k-1, r-2, c-1, dp);
        p /= 8.0;
        dp[r][c][k] = p;
        return p;
    }
    
    double knightProbability(int n, int k, int row, int column) {
        vector<vector<vector<double>>> dp(n, vector<vector<double>>(n, vector<double>(k+1))); // dp[n][n][k+1]
        return find(n, k, row, column, dp);
    }
};
