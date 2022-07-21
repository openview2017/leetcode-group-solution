#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;

class Solution0279 {
public:
    int numSquares(int n) {
        int sqrtn = (int) sqrt((double) n);
        vector<int> sq(sqrtn, 0);
        for (int i = 0;  i < sqrtn; i++) {
            sq[i] = (i+1) * (i+1);
        }
        vector<int> dp(n+1, 0);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 0; j < sqrtn && i >= sq[j]; j++) {
                dp[i] = min(dp[i], dp[i - sq[j]] + 1);
            }
        }
        return dp[n];
    }
};