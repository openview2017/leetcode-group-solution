class NumbersOfPagesWays:
    def numberOfWays(self, book):
        if not book:
            return 0
        cur = 1
        page_blocks = []
        result = 0
        for i in range(1, len(book)):
            if book[i] == book[i-1]:
                cur += 1
            else:
                page_blocks.append(cur)
                cur = 1
        page_blocks.append(cur)
        if len(page_blocks) < 3:
            return 0
        for i in range(2,len(page_blocks)):
            result += page_blocks[i] * page_blocks[i-1] * page_blocks[i-2]
        return result

if __name__ == "__main__":
    # Test case1
    n = NumbersOfPagesWays()
    print(n.numberOfWays("01001"))
    print("Expected result: {}".format(4))
    # Test case2
    n = NumbersOfPagesWays()
    print(n.numberOfWays("10111"))
    print("Expected result: {}".format(3))
    # Test case3
    n = NumbersOfPagesWays()
    print(n.numberOfWays("00000"))
    print("Expected result: {}".format(0))
