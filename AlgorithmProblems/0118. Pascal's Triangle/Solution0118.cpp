#include <iostream>
#include <string>
#include<vector>
using namespace std;

class Solution0118 {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res;
        for (int i = 0; i < numRows; i++) {
            vector<int> row(i+1, 1);
            for (int j = 1; j < i; j++) {
                row[j] = res[i-1][j-1] + res[i-1][j];
            }
            res.push_back(row);
        }
        return res;
    }
};

int main() {
    Solution0118 sol;
    int numRows = 5;
    vector<vector<int>> vec = sol.generate(numRows);
    for (int i = 0; i < vec.size(); ++i)
    {
        for (int j = 0; j < vec[i].size(); ++j)
        {
            cout << vec[i][j];
        }
        cout << std::endl;
    }
    
}