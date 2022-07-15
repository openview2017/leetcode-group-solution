class Solution0719:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        def check(dis):
            cnt=a = 0
            for r in range(1, len(nums)):
                while nums[r] - nums[a] > dis:
                    a += 1
                cnt += r - a
            return cnt

        nums.sort()
        left, r = 0, nums[-1] - nums[0]
        while left < r:
            mid = left + r>>1
            if check(mid) < k:
                left = mid + 1
            else:
                r = mid
        return r        