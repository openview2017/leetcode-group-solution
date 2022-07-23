from typing import List


class Solution0089:
    def grayCode(self, n: int) -> List[int]:
        res = [0]
        tmp = 1
        for i in range(1, n+1):
            cur_size = len(res)
            for j in range(cur_size - 1, -1, -1):
                res.append(res[j] + tmp)
            tmp *= 2
        
        return res