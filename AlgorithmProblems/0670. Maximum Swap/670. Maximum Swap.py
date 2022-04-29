"""
Solution 1: Sort
"""
class Solution:
    def maximumSwap(self, num: int) -> int:
        num_list = [i for i in str(num)]
        sorted_num_list = sorted(num_list, reverse=True)
        left = 0
        while left < len(num_list) and num_list[left] == sorted_num_list[left]:
            left += 1
        if left == len(num_list):
            return num
        for right in range(len(num_list)-1, left, -1):
            if num_list[right] == sorted_num_list[left]:
                break
        num_list[right], num_list[left] = num_list[left], num_list[right]        
        return int("".join(num_list))

"""
Solution 2: Without sort. Same as java solution.
"""
class Solution:
    def maximumSwap(self, num: int) -> int:
        num_str = str(num)
        num_list = [i for i in num_str]
        num_position = [-1 for i in range(10)]
        for i in range(len(num_str)-1, -1, -1):
            if num_position[int(num_list[i])] != -1:
                continue
            else:
                num_position[int(num_list[i])] = i
        for i in range(len(num_list)):
            for j in range(9, int(num_list[i]), -1):
                if num_position[j] > i:
                    num_list[i], num_list[num_position[j]] = num_list[num_position[j]], num_list[i]
                    return int("".join(num_list))
        return num
