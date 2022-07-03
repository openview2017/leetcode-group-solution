from typing import List


class Solution0014:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        shortest = min(strs, key = len)
        for i, ch in enumerate(shortest):
            for each in strs:
                if ch != each[i]:
                    return shortest[:i]
        return shortest