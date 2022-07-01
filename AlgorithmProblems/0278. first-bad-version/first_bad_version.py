class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        if n == 1:
            if isBadVersion(n):
                return 1
            
        l, r = 0, n        
        while l < r:
            m = l + (r - l) // 2
            if isBadVersion(m):
                r = m
            else:
                l = m + 1
                
        return r
