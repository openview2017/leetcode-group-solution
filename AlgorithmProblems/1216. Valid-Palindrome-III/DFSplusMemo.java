class Solution1216 {
    
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        Integer[][] memo = new Integer[n][n];
        return isValid(s, 0, n - 1, memo) <= k;
        
    }
    
    // 物理意义：[left...right] 需要删几个可以是panlindrome
    private int isValid(String s, int left, int right, Integer[][] memo) {
        // base case 1
        if (left == right) {
            return 0;
        }
        // base case 2
        if (left == right - 1) {
            return s.charAt(left) == s.charAt(right) ? 0 : 1;
        }
        
        // 查表
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        
        if (s.charAt(left) == s.charAt(right)) {
            return isValid(s, left + 1, right - 1, memo);
        }
        
        int cur = 1 + Math.min(isValid(s, left + 1, right, memo), isValid(s, left, right - 1, memo));
        
        memo[left][right] = cur;
        
        return cur;
    }
    
}

class Solution1216DP { // tc: o(N2), sc: o(n2) -> o(N)
    public boolean isValidPalindrome(String s, int k) { // space optimization
        int n = s.length();
        int[][] memo = new int[2][n]; // memo [i, j] - remove min char
        memo[n%2][n-1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            memo[i%2][i] = 0;
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    memo[i%2][j] = memo[1-i%2][j-1];
                } else {
                    memo[i%2][j] = 1 + Math.min(memo[1-i%2][j], memo[i%2][j-1]);
                }
            }
        }
        return memo[0][n-1] <= k;
    }    
    // public boolean isValidPalindrome(String s, int k) {
    //     int n = s.length();
    //     int[][] memo = new int[n][n]; // memo [i, j] - remove min char
    //     memo[n-1][n-1] = 0;
    //     for (int i = n - 1; i >= 0; i--) {
    //         memo[i][i] = 0;
    //         for (int j = i+1; j < n; j++) {
    //             if (s.charAt(i) == s.charAt(j)) {
    //                 memo[i][j] = memo[i+1][j-1];
    //             } else {
    //                 memo[i][j] = 1 + Math.min(memo[i+1][j], memo[i][j-1]);
    //             }
    //         }
    //     }
    //     return memo[0][n-1] <= k;
    // }
}