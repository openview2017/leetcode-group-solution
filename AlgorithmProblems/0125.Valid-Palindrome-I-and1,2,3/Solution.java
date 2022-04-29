/*
总结：while里面再加while loop，就是left和right都分别走到可以对比的时候，再停下来。
就是要注意：在while里面的while loop，要确保同时满足外面的while loop条件也随时满足
TC： O（n）
SC： O（1）

*/

class Solution {
    public boolean isPalindrome(String s) {
        String a = s.toLowerCase();
        char[] array = a.toCharArray();
        
        int n = array.length;
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(array[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(array[right])) {
                right--;
            }
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}