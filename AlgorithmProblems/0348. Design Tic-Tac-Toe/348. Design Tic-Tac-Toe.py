"""
We use row status, col status and diagonal status to track each row, column, diagonal in board. 
For example, in row status, the ith element [a, b] means player1 has filled n-a positions in current row and player2 filled n-b positions.
Once this value reaches 0, that means all positions in current row is filled by the current player, there is a win.
TC: O(1) in each move
SC: O(N^2) for board and O(N) for keep status
"""

import sys
class TicTacToe:

    def __init__(self, n: int):
        self.size = n
        self.board = [[0 for i in range(n)] for j in range(n)]
        self.row_status = [[n, n] for i in range(n)]
        self.col_status = [[n, n] for i in range(n)]
        self.diagonal_status = [[n, n] for i in range(2)]

    def move(self, row: int, col: int, player: int) -> int:
        cur_min = sys.maxsize
        self.board[row][col] = player
        self.row_status[row][player-1] -= 1
        cur_min = min(cur_min, self.row_status[row][player-1])
        self.col_status[col][player-1] -= 1
        cur_min = min(cur_min, self.col_status[col][player-1])
        if row == col:
            self.diagonal_status[0][player-1] -= 1
            cur_min = min(cur_min, self.diagonal_status[0][player-1])
        if row + col == self.size - 1:
            self.diagonal_status[1][player-1] -= 1
            cur_min = min(cur_min, self.diagonal_status[1][player-1])
        if cur_min == 0:
            return player
        return 0