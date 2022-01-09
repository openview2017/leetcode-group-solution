class DFSwMemoSolution {
    private static int MAX;
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        // A memo to record visited & min coins for amount i
        int[] minCount = new int[amount + 1];
        MAX = amount + 1;
        Arrays.fill(minCount, MAX);

        int min = coinChanger(coins, amount, minCount);

        return min;
    }

    // minimum number of coins to sum to `amount`, if impossible, return -1
    private int coinChanger(int[] coins, int amount, int[] minCount) {
        if (amount == 0) {
            return 0;
        }
        if (minCount[amount] != MAX) {
            return minCount[amount];
        }

        int min = MAX;
        for (int i = 0; i < coins.length; i++) {
            if (amount >= coins[i]) {
                int tmp = coinChanger(coins, amount - coins[i], minCount);

                if (tmp != -1 && tmp < MAX) {
                    min = Math.min(min, tmp + 1);
                }
            }
        }
        minCount[amount] = min == MAX ? -1 : min;
        return minCount[amount];
    }
}


class DPSolution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;             
        int[] dp = new int[amount + 1];  
        Arrays.fill(dp, max);  
        dp[0] = 0;   
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

class BFSwMemoSolution { // bfs
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> min = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(0);
        min.put(0, 0);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int tmp = queue.pollFirst();
                if (tmp == amount) {
                    return level;
                }
                for (int coin : coins) {
                    int nxt = tmp + coin;
                    if (min.getOrDefault(nxt, Integer.MAX_VALUE) > level + 1 && nxt <= amount) {
                        min.put(nxt, level + 1);
                        queue.offerLast(nxt);
                    }
                }
            }
            level++;
        }
        return min.getOrDefault(amount, -1);
    }
}

