"""
For each number, count number of 1s on the left and number of 0s on the right side.
These are the coins we need to flip if we select the current coin as the boundary.
Then add the numbers together and pick the smallest one which represents the minimum number of coins need to flip.

Time complexity: O(N)
Space complexity: O(N)
"""

class MinimumFlip:
    def minimumFlip(self, coins):
        count = [0 for i in coins]
        min_steps = len(coins)
        # Count the number of 1s on the left side of current node.
        cur = 0
        for i in range(len(coins)):
            count[i] = cur
            if coins[i] == 1:
                cur += 1
        # Count the number of 0s on the right side of current node.
        cur = 0
        for i in range(len(coins)-1, -1, -1):
            count[i] += cur
            if coins[i] == 0:
                cur += 1
            min_steps = min(min_steps, count[i])
        return min_steps


if __name__ == "__main__":
    # Test case1
    coins = [0,1,0,0,1]
    ms = MinimumFlip()
    print(ms.minimumFlip(coins))
    print("Expected result: {}".format(1))
    # Test case2
    coins = [0,0,0,0,0]
    print(ms.minimumFlip(coins))
    print("Expected result: {}".format(0))
    # Test case3
    coins = [0,1,0,1,1,0,1]
    print(ms.minimumFlip(coins))
    print("Expected result: {}".format(2))
