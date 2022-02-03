class FindPairs:
    def getNumOfPairs(self, array1, array2):
        if len(array1) != len(array2):
            raise ValueError
        result_dict = dict()
        for i in range(len(array1)):
            key = array1[i] + array2[i]
            if key in result_dict:
                result_dict[key] += 1
            else:
                result_dict[key] = 1
        pairs = 0
        for key, val in result_dict.items():
            pairs += (val+1) * val // 2
        return pairs

if __name__ == "__main__":
    # Test case1
    a = [2, -2, 5, 3]
    b = [1, 5, -1, 1]
    fp = FindPairs()
    print(fp.getNumOfPairs(a, b))
    print("Expected result: {}".format(6))
        