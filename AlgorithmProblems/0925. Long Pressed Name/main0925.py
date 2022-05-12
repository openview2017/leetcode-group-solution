class Solution0925:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        m, n = len(name), len(typed)
        i, j = 0, 0
        
        while i < m and j < n:
            c1, c2 = name[i], typed[j]
            if c1 != c2:
                return False
            count1, count2 = 0, 0
            while i < m and name[i] == c1:
                count1 += 1
                i += 1
            while j < n and typed[j] == c2:
                count2 += 1
                j += 1
            if count2 < count1:
                return False
        return i == m and j == n

sol = Solution0925()
name = "alex"
typed = "aaleex"
print(sol.isLongPressedName(name, typed))
