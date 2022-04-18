/*
先左右往里看，如果一样就一直走。如果不一样，看删左边或者删右边。
TC: O(n)
SC: O(1)

*/

class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1); // 关键在这里
            }
        }
        return true;
    }
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
            
        }
        return true;
    }
}