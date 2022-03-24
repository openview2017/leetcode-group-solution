import java.util.*;

/*
Example 1:

Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".


Example 2:

Input: words = ["cat","dog","catdog"]
Output: ["catdog"]



*/


public class main0472 {
    public static void main(String[] args) {
        Solution0472_0 sol = new Solution0472_0();
        String[] words;
        List<String> res;

        words = new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println("Input : " + Arrays.deepToString(words));
        res = sol.findAllConcatenatedWordsInADict(words);
        System.out.println("Output: " + Arrays.deepToString(res.toArray()));
    }
}

class Solution0472_0 { // tc:o(n3), sc:o(n)
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }
        
        return result;
    }
	
    private static boolean canForm(String word, Set<String> dict) {
        if (dict.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
            if (!dp[j]) continue;
            if (dict.contains(word.substring(j, i))) {
                dp[i] = true;
                break;
            }
            }
        }
        return dp[word.length()];
    }
}