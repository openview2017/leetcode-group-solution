/*
sliding window
TC: O(n + m) where n and m are length of input
SC: O(m.length)

        sliding window里面，一定只有m个elements，m是s1的长度。
        所以在长度是m的基础上，所有的字母也match了，就可以return。
        不会出现所有字母match了，也有多出来别的字母的情况，因为长度只能是m。
        
        和76. https://leetcode.com/problems/minimum-window-substring/ 对比，76题的sliding window size并不固定，在符合条件的过程中，
        移动slow指针，找到最短的window size
        
        类似题目： https://leetcode.com/problems/find-all-anagrams-in-a-string/
        https://leetcode.com/problems/permutation-in-string/
        
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        int[] array = new int[26];
        int match = 0;
        int count = 0;
        
        for (int i = 0; i < p.length(); i++) {
            int index = p.charAt(i) - 'a';
            if (array[index] == 0) {
                count++;
            }
            array[index]++;
        }        
        
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (array[index] == 1) {
                match++;
            }
            array[index]--;
            
            if (i >= p.length()) {
                index = s.charAt(i - p.length()) - 'a';
                if (array[index] == 0) {
                    match--;
                }
                array[index]++;

            }
            if (match == count) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
   
}