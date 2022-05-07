public class main0383 {
    
}

class Solution0383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] dict = new int[26];
        int count = 0;
        for (char c : magazine.toCharArray()) {
            dict[c - 'a']++;
            if (dict[c - 'a'] > 0) {
                count++;
            }
        }
        for (char c : ransomNote.toCharArray()) {
            dict[c - 'a']--;
            if (dict[c - 'a'] < 0) {
                return false;
            } else if (dict[c - 'a'] == 0) {
                count--;
            }
        }
        return count >= 0; 
    }

}