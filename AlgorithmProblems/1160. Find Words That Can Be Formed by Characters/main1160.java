public class main1160 {
    
}


class Solution1160 { // 27 - 31
    public int countCharacters(String[] words, String chars) {
        int[] charDict = new int[26];
        int count = 0;
        for (char c : chars.toCharArray()) {
            charDict[c - 'a']++;
        }
        for (String word : words) {
            if (isValid(word, charDict.clone())) {
                count += word.length();
            }
        }
        return count;
    }
    
    private boolean isValid(String word, int[] charDict) {
        for (char c : word.toCharArray()) {
            if (--charDict[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}