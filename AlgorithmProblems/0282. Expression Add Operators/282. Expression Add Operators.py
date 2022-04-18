from typing import List
"""
Use dfs to solve this question. Keep tracking of the last number and total sum.
TC: O(4^N)
SC: O(N) Recusion stack length
"""
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        self.dfs(num, target, 0, 0, 0, "", result)
        return result
    
    def dfs(self, num, target, index, last, total, path, result):
        # Exit of recursion. When the index is out of range and target equals current total.
        if index == len(num) and target == total:
            result.append(path)
            return
        if index >= len(num):
            return
        for i in range(index+1, len(num)+1):
            
            if i - index > 1 and num[index] == "0":
                continue
            if index == 0:
                self.dfs(num, target, i, int(num[index:i]), int(num[index:i]), num[index:i], result)
                continue
            self.dfs(num, target, i, int(num[index:i]), total + int(num[index:i]), path + "+" + num[index:i], result)
            self.dfs(num, target, i, -int(num[index:i]), total - int(num[index:i]), path + "-" + num[index:i], result)
            self.dfs(num, target, i, last * int(num[index:i]), total - last + last * int(num[index:i]), path + "*" + num[index:i], result)
        return