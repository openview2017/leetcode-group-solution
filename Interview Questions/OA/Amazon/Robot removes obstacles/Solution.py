from collections import deque
class RobotRemoveObstacles:
    def removeObstacles(self, lot):
        if lot[0][0] == 0:
            return -1

        queue = deque([(0,0)])
        visited = [[False for i in range(len(lot[0]))] for j in range(len(lot))]
        visited[0][0] = True
        directions = [(1,0), (0,1), (-1,0), (0,-1)]
        steps = 0
        while queue:
            for _ in range(len(queue)):
                cur_row, cur_col = queue.popleft()
                if lot[cur_row][cur_col] == 9:
                    return steps
                for i, j in directions:
                    new_row, new_col = cur_row+i, cur_col+j
                    if 0 <= new_row < len(lot) and 0 <= new_col < len(lot[0]) and not visited[new_row][new_col] and lot[new_row][new_col] != 0:
                        queue.append((new_row, new_col))
                        visited[new_row][new_col] = True
            steps += 1
        return -1

if __name__ == "__main__":
    # Test case1
    lot=    [[1, 0, 0],
            [1, 0, 0],
            [1, 9, 1]]
    ro = RobotRemoveObstacles()
    print(ro.removeObstacles(lot))
    print("Expected result: {}".format(3))
    # Test case2
    lot=    [[9, 0, 0],
            [1, 0, 0],
            [1, 1, 1]]
    ro = RobotRemoveObstacles()
    print(ro.removeObstacles(lot))
    print("Expected result: {}".format(0))
    # Test case3
    lot=    [[1, 0, 0],
            [0, 0, 0],
            [1, 9, 1]]
    ro = RobotRemoveObstacles()
    print(ro.removeObstacles(lot))
    print("Expected result: {}".format(-1))
    # Test case4
    lot=    [[0, 0, 0],
            [0, 0, 0],
            [1, 9, 1]]
    ro = RobotRemoveObstacles()
    print(ro.removeObstacles(lot))
    print("Expected result: {}".format(-1))
    # Test case5
    lot=    [[1, 1, 1],
            [1, 0, 1],
            [0, 9, 1]]
    ro = RobotRemoveObstacles()
    print(ro.removeObstacles(lot))
    print("Expected result: {}".format(5))