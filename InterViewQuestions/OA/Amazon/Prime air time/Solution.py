import sys
class ClosestPairSum:
    def getClosestPair(self, arr1, arr2, target):
        arr1 = sorted(arr1, key=lambda x: x[1])
        arr2 = sorted(arr2, key=lambda x: x[1])

        cur_closest = -sys.maxsize
        left_idx = right_idx = 0
        left, right = 0, len(arr2)-1
        while left < len(arr1) and right >= 0:
            cur_sum = arr1[left][1] + arr2[right][1]
            if cur_sum > target:
                right -= 1
            else:
                if cur_sum >= cur_closest:  # What if we have 2 closest pairs? Which one to select?
                    cur_closest = cur_sum
                    left_idx, right_idx = arr1[left][0], arr2[right][0]
                left += 1
        return [left_idx, right_idx]

if __name__ == "__main__":

    # Test case1
    arr1 = [[1, 2000], [2, 3000], [3, 4000]] 
    arr2 = [[ 1, 5000], [2, 3000]] 
    c = ClosestPairSum()
    print(c.getClosestPair(arr1, arr2, 5000))
    print("Expected result: {}".format([1,2]))

    # Test case2
    arr1 = [[1,3000],[2,5000],[3,4000],[4,10000]]
    arr2 = [[1,2000],[2,3000],[3,4000]] 
    c = ClosestPairSum()
    print(c.getClosestPair(arr1, arr2, 9000))
    print("Expected result: {}".format([2,3]))