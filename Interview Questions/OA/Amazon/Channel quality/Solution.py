"""
Using recursive method with memo to solve this problem.
Time complexity: O(N*logN) + O(C(N-1,c-1)) => N is number of packets, c is number of channels. 
        Also as: O(N*logN) + O((N-1)!/((N-c)!(c-1)!) = O(N*logN) + O(N**c)
"""
import sys
class QualityChannel:
    def getQualityChannel(self, packets, channels):   # packets=>[1,2,3,4,5], channels=>2
        visited = dict()
        packets.sort()
        return self.dfs(packets, 0, channels, visited)

    def dfs(self, packets, idx, channels, visited):
        if (idx, channels) in visited:
            return visited[(idx, channels)]
        # Exit of the recursion. Return the median of the rest elements if only 1 channel left.
        if channels == 1:
            return self.findMedian(idx, len(packets)-1, packets)
        # Find the max number we can get from the result of the following elements.
        max_result = -sys.maxsize
        for i in range(idx, len(packets)-channels+1):
            max_result = max(max_result, self.findMedian(idx, i, packets) + self.dfs(packets, i+1, channels-1, visited))
            visited[(idx, channels)] = max_result
        return max_result

    # Find the median of a subarray with start and end index.
    # If odd number of elements, return the middle one.
    # If even number of elements, return the average of the two in the middle.
    def findMedian(self, start, end, packets):
        if start > end or start >= len(packets) or end >= len(packets) or start < 0 or end < 0:
            raise IndexError
        mid = (start+end) // 2
        if (start + end) % 2:
            return (packets[mid] + packets[mid+1]) / 2
        else:
            return packets[mid]
    
if __name__ == "__main__":
    # Test case1
    packets = [1,2,3,4,5]
    qc = QualityChannel()
    print(qc.getQualityChannel(packets, 2))
    print("Expected result: {}".format(7.5))
    # Test case2
    packets = [2, 2, 1, 5, 3]
    qc = QualityChannel()
    print(qc.getQualityChannel(packets, 2))
    print("Expected result: {}".format(7))
    # Test case3
    packets = [89, 48, 14]
    qc = QualityChannel()
    print(qc.getQualityChannel(packets, 2))
    print("Expected result: {}".format(151))
