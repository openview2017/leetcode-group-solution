from typing import List

class Solution:
    def getModifiedArray(self, length: int, updates: List[List[int]]) -> List[int]:
        # Here we use hashmap to track the start & end value. We can also use an array.
        addition_points = dict()
        for i in updates:
            # Add start to addtion_points
            if i[0] in addition_points:
                addition_points[i[0]] += i[2]
            else:
                addition_points[i[0]] = i[2]
            # Add end+1 to addtion_points because at end idx we still want to add increase.
            if i[1]+1 in addition_points:
                addition_points[i[1]+1] -= i[2]
            else:
                addition_points[i[1]+1] = -i[2]
        arr = [0 for _ in range(length)]
        cur = 0
        for i in range(length):
            if i in addition_points:
                cur += addition_points[i]
            arr[i] = cur
        return arr