"""
Divide the array into multiple decreasing subarray sections.
[9, 8, 4, 9, 3] => [9,8,4] + [9,3]
For each array with length n, number of subarrays is n + (n-1) + ... + 1 = n*(n-1) // 2
Sum the numbers and get the result.

Time complexity: O(N)
Space complexity: O(1) => we are using pointer rather than really splitting the array.
"""
#[9, 8, 4, 9, 3]
class CountDecreasingSubarray:
    def getSubarrayCount(self, array):
        cur_len = 0
        result = 0
        for i in range(len(array)):
            if i == 0 or array[i] < array[i-1]:
                cur_len += 1
            else:
                result += (cur_len+1) * cur_len // 2
                cur_len = 1
        result += (cur_len+1) * cur_len // 2
        return result

if __name__ == "__main__":
    # Test case1
    array = [1,2,3,4,5]
    c = CountDecreasingSubarray()
    print(c.getSubarrayCount(array))
    print("Expected result: {}".format(5))

    # Test case2
    array = [5, 4, 3, 2, 1]
    c = CountDecreasingSubarray()
    print(c.getSubarrayCount(array))
    print("Expected result: {}".format(15))

    # Test case3
    array = [9, 8, 4, 9, 3]
    c = CountDecreasingSubarray()
    print(c.getSubarrayCount(array))
    print("Expected result: {}".format(9))