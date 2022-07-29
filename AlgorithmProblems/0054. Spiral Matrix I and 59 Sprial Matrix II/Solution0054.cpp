#include <vector>

using namespace std;

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int>res;
        int row = matrix.size(), col = matrix[0].size();
        int topRow = 0, bottomRow = row - 1;
        int leftCol = 0, rightCol = col - 1;        
        while (topRow < bottomRow && leftCol < rightCol) {
            for (int c = leftCol; c < rightCol; c++) {
                res.push_back(matrix[topRow][c]);
            }
            for (int r = topRow; r < bottomRow; r++) {
                res.push_back(matrix[r][rightCol]);
            }
            for (int c = rightCol; c > leftCol; c--) {
                res.push_back(matrix[bottomRow][c]);
            }
            for (int r = bottomRow; r > topRow; r--) {
                res.push_back(matrix[r][leftCol]);
            }
            topRow++; bottomRow--;
            leftCol++; rightCol--;             
        }
        if (topRow == bottomRow) {
            while (leftCol <= rightCol) {
                res.push_back(matrix[bottomRow][leftCol++]);
            }
        } else if(leftCol == rightCol) {
            while(topRow <= bottomRow) {
                res.push_back(matrix[topRow++][leftCol]); // !!!
            }
        }  
        
        return res;        
    }
};