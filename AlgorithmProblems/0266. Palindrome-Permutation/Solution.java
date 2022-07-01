/*
用int[26]数每一个字母的个数，双数个数的可以，单数个数的最多只能有一个。

*/
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] a = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            a[index]++;
        }
        int single = 0;
        for (int i : a) {
            if (i % 2 == 0) {
                continue;
            } else {
                if (single == 0) {
                    single = 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}