/*
TC: O(m + n) where m and n are length of input
SC: O(26) -> O(1)

        sliding window里面，一定只有m个elements，m是s1的长度。
        所以在长度是m的基础上，所有的字母也match了，就可以return。
        不会出现所有字母match了，也有多出来别的字母的情况，因为长度只能是m。
        
        和76. https://leetcode.com/problems/minimum-window-substring/ 对比，76题的sliding window size并不固定，在符合条件的过程中，
        移动slow指针，找到最短的window size
        
        类似题目： https://leetcode.com/problems/find-all-anagrams-in-a-string/
        https://leetcode.com/problems/permutation-in-string/
        
        
*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        int[] array = new int[26];
        int count = 0;
        
        for (char c : s1.toCharArray()) {
            int index = c - 'a';
            if (array[index] == 0) {
                count++;
            }
            array[index]++;
        }
        
        int match = 0;

        for (int i = 0; i < s2.length(); i++) {
            // process the letter to be added
            int index = s2.charAt(i) - 'a';
            array[index]--;
            if (array[index] == 0) {
                match++;
            } 
             
            // process the letter to be deleted
            // 每次都要减，以此维持sliding window的fixed size
            if (i >= s1.length()) {
                int indexDelete = s2.charAt(i - s1.length()) - 'a';
                array[indexDelete]++;
                if (array[indexDelete] == 1) {
                    match--;
                }
            }

            // after adding and deleting for one round, check if is valid
            if (match == count) {
                    return true;
            }
        }
        return false;
    }
}