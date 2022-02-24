class Solution {
    public int compress(char[] chars) {
        // corner case
        if (chars.length == 1) {
            return 1;
        }
        
        int slow = 0; // (0...slow) to keep
        int fast = 0; // pointer to traverse the array
        while (fast < chars.length) {
            char cur = chars[fast];
            int count = 0;
            while (fast < chars.length && chars[fast] == cur) {
                fast++;
                count++;
            }
            
            chars[slow] = cur;
            slow++;
            if (count == 1) {
                continue;
            }
            char[] countArray = String.valueOf(count).toCharArray(); 
            // 这里是Integer.toString(count).toCharArray() 也可以
            for (char c : countArray) {
                chars[slow] = c;
                slow++;
            }
        }
        return slow;
    }
}