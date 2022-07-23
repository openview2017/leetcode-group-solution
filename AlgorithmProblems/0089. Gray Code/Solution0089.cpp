#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> res;
        res.push_back(0);
        int ref = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = res.size()-1; j >= 0; j--) {
                res.push_back(res[j] + ref);
            }
            ref *= 2;
        }
        return res;
    }
    vector<int> grayCode0(int n) {
        vector<int> result(1 << n);
        for (int i = 0; i < result.size(); i++) {
            result[i] = (i >> 1) ^ i;
        }
        return result;
    }

// 作者：zzpig
// 链接：https://leetcode.cn/problems/gray-code/solution/dai-ma-jie-de-xiao-bai-javac-san-chong-f-iaxe/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
};