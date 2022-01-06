class Solution {
    public int maxPower(String s) {
        if (s == null) return 0;
        int power = 0;
        int slow = 0;
        int fast = 0;
        while (fast < s.length()) {
            while (fast < s.length() && s.charAt(slow) == s.charAt(fast)) {
                fast++;
            }
            //stop at slow point to letter a,  eg. aaabbb
            //fast points to the first letter not a, which should be b in above case
            power = Math.max(power, fast - slow);
            slow = fast;
        }
        return power;
    }

}