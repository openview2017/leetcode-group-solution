#Solution1:
#Space O(1)
#Time O(n)
class Solution:
    def getNext(self, n):
        res = 0
        while n:
            m = n % 10
            res += m * m
            n = n // 10
        return res
            
        
    def isHappy(self, n: int) -> bool:
        slow = n
        fast = self.getNext(n)
        while fast != 1 and slow != fast:
            slow = self.getNext(slow)
            fast = self.getNext(self.getNext(fast))
        return fast == 1


#Solution2:
#Space O(n)
#Time O(n)
class Solution:
    def getNext(self, n):
        res = 0
        while n:
            m = n % 10
            res += m * m
            n = n // 10
        return res


    def isHappy(self, n: int) -> bool:
        seen = set()
        while n not in seen:
            seen.add(n)
            n = self.getNext(n)
            if n == 1:
                return True
        return
