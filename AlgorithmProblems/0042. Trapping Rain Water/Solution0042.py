from typing import List


class Solution0042:
    def trap(self, height: List[int]) -> int:
        left, right = 0, len(height)-1
        leftmax, rightmax = height[left], height[right]
        sum = 0
        while left <= right:
            if leftmax <= rightmax:
                sum += max(leftmax - height[left], 0)
                leftmax = max(leftmax, height[left])
                left += 1
            else:
                sum += max(rightmax - height[right], 0)
                rightmax = max(rightmax, height[right])
                right -= 1
        return sum