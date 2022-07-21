#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution0790 {
public:
    int numTilings(int n) {
        vector<long> dp{1, 0, 0, 1};
        long MOD = 1000000007;
        for (int i = 2; i <= n; i++) {
            vector<long> tmp{0, 0, 0, 0};
            tmp[0] = dp[3];
            tmp[1] = (dp[2] + dp[0]) % MOD;
            tmp[2] = (dp[1] + dp[0]) % MOD;
            tmp[3] = (dp[0] + dp[1] + dp[2] + dp[3]) % MOD;
            dp = tmp;
        }
        return (int) (dp[3] % MOD);
    }
};