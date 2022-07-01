/*
从左到右扫一遍即可，因为保证了input是valid的括号。找到单独的左括号最多的时刻。
TC：O(n)
SC: O(1)
*/
class Solution {
    public int maxDepth(String s) {
        char[] array = s.toCharArray();
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < array.length; i++) {
            char cur = array[i];
            if (cur == '(') {
                count++;
                maxCount = Math.max(maxCount, count);
            } else if (cur == ')') {
                count--;
            } else {
                continue;
            }
        }
        return maxCount;
    }
}
