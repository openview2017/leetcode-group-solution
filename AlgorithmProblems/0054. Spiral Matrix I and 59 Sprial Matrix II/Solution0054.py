class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        res = []
        top_row, bottom_row = 0, len(matrix) - 1         
        left_col, right_col = 0, len(matrix[0]) - 1
        while (top_row < bottom_row and left_col < right_col):
            for i in range(left_col, right_col):
                res.append(matrix[top_row][i])
            for i in range(top_row, bottom_row):
                res.append(matrix[i][right_col])
            for i in range(right_col,left_col,-1):
                res.append(matrix[bottom_row][i])
            for i in range(bottom_row,top_row,-1):
                res.append(matrix[i][left_col])
            top_row += 1
            bottom_row -= 1
            left_col += 1
            right_col -= 1
         
        if top_row == bottom_row:
            while left_col <= right_col:
                res.append(matrix[top_row][left_col])
                left_col += 1 #-
        elif left_col == right_col:
            while top_row <= bottom_row:
                res.append(matrix[top_row][left_col])
                top_row += 1 #|
        return res