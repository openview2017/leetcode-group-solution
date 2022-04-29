"""
Minimum number of swaps equals to the sum of the distances between corresponding 0s and 1s.
Time complexity: O(N)
Space complexity: O(1)
"""
import sys
class SortBinaryArrayWithSwap:
    def findMinSwaps(self, arr):
        no_of_ones = sum(arr)
        result = sys.maxsize

        idx_of_zeros = 0
        idx_of_ones = 0
        # Move all 1s to the left
        for i in range(len(arr)):
            if i < no_of_ones:
                if arr[i] == 0:
                    idx_of_zeros += i
            else:
                if arr[i] == 1:
                    idx_of_ones += i
        result = min(result, idx_of_ones - idx_of_zeros)

        idx_of_zeros = 0
        idx_of_ones = 0
        # Move all 1s to the right
        for i in range(len(arr)):
            if i < len(arr) - no_of_ones:
                if arr[i] == 1:
                    idx_of_ones += i
            else:
                if arr[i] == 0:
                    idx_of_zeros += i
        result = min(result, idx_of_zeros - idx_of_ones)

        return result

if __name__ == "__main__":

    # Test case1
    arr = [ 0, 0, 1, 0, 1, 0, 1, 1 ]
    s = SortBinaryArrayWithSwap()
    print (s.findMinSwaps(arr))
    print("Expected result: {}".format(3))

    # Test case2
    arr = [ 0, 0, 1, 0, 1]
    s = SortBinaryArrayWithSwap()
    print (s.findMinSwaps(arr))
    print("Expected result: {}".format(1))

    # Test case3
    arr = [ 1, 0, 1, 0, 1 ]
    s = SortBinaryArrayWithSwap()
    print (s.findMinSwaps(arr))
    print("Expected result: {}".format(3))