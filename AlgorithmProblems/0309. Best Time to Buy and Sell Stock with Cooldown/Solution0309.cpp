#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution0309 {
public:
    int maxProfit(vector<int>& prices) {
        int buy(-prices[0]), sell(0), sellfree(0);
        for (int i = 1; i < prices.size(); i++) {
            int tmp = sellfree;
            sellfree = max(sellfree, sell);
            sell = buy + prices[i];
            buy = max(buy, tmp - prices[i]);
        }
        return max(sell, sellfree);
    }
};