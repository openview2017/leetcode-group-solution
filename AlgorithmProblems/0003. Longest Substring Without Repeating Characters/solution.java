//TC: O(n)
//SC: O(n) for the set

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int fast = 0;
        int longest = 0;
        
        Set<Character> set = new HashSet<>(); // [slow...fast) sliding window之间的内容
        while (fast < s.length()) {
            if (set.add(s.charAt(fast))) {
                fast++;
                longest = Math.max(longest, fast - slow);
            } else {
                set.remove(s.charAt(slow));
                slow++;
            }
        }
        return longest;
    }
}