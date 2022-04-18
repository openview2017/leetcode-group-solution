"""
Similar to the solution of problem 907.Sum of Subarray Minimums.
Example:
input string = abcbd
    a   b   c   b   d
    |
    1        5
a appears 1 * 5 times in all subarrays (a to a) * (a to d)

    a   b   c   b   d
        |
      2       4
1st b appears 2 * 4 times in all subarrays (b to a) * (b to d)

    a   b   c   b   d
            |
        3       3
c appears 3 * 3 times in all subarrays (c to a) * (c to d)

    a   b   c   b   d
            |
        3       3
2nd b appears 2 * 2 times in all subarrays (b to c) * (b to d). Previous b has been calculated.

    a   b   c   b   d
            |
        3       3
d appears 5 * 1 times in all subarrays (d to a) * (d to d).

result = 1*5+2*4+3*3+2*2+5*1 = 31

Time complexity: O(N)
Space complexity: O(N)
"""
class DistinctCharacterCount:
    def distinctCharCount(self, s):
        most_recent_idx = dict()
        result = 0
        for i in range(len(s)):
            if s[i] not in most_recent_idx:
                closest = -1
            else:
                closest = most_recent_idx[s[i]]
            result += (i-closest) * (len(s)-i)
            most_recent_idx[s[i]] = i
        return result


if __name__ == "__main__":
    # Test case1
    s = "test"
    ds = DistinctCharacterCount()
    print(ds.distinctCharCount(s))
    print("Expected result: {}".format(19))
    # Test case2
    s = "abcbd"
    ds = DistinctCharacterCount()
    print(ds.distinctCharCount(s))
    print("Expected result: {}".format(31))
    # Test case3
    s = "dddd"
    ds = DistinctCharacterCount()
    print(ds.distinctCharCount(s))
    print("Expected result: {}".format(10))