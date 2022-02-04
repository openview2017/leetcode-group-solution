class Solution {
    
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