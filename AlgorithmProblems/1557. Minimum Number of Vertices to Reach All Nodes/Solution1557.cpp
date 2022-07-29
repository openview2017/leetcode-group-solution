#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution1557 {
public:
    vector<int> findSmallestSetOfVertices(int n, vector<vector<int>>& edges) {
        vector<int> res;
        vector<int> deg(n,0);
        for (vector<int> edge : edges) {
            deg[edge[1]]++;
        }
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                res.push_back(i);
            }
        }
        return res;
    }
};