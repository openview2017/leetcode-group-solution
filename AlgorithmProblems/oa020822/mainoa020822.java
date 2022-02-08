import java.util.*;

public class mainoa020822 {
    public static void main(String[] args) {
        SolutionOA020822 sol = new SolutionOA020822();
        String[] words;
        int res;

        words = new String[]{"a","b","ba","bca","bda","bdca"};
        res = sol.longestStrChain(words);
        System.out.println("Input : " + Arrays.toString(words));
        System.out.println("Resuult : " + res);
        // longest chain : "a","ba","bda","bdca"

        words = new String[]{"abcd","dbqca"};
        res = sol.longestStrChain(words);
        System.out.println("Input : " + Arrays.toString(words));
        System.out.println("Resuult : " + res);
    }
}

class SolutionOA020822 {
    public int longestStrChain(String[] words) {
        Map<String, Integer> chainLen = new HashMap<>();

        Arrays.sort(words, (s1, s2) -> (s1.length() - s2.length()));
        
        int longest = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); i++) {
                String tmp = word.substring(0, i) + word.substring(i+1);
                String tmpcode = conv(tmp);
                best = Math.max(best, chainLen.getOrDefault(tmpcode, 0)); 
            }
            
            chainLen.put(conv(word), best + 1);
            
            longest = Math.max(longest, best + 1);
        }
        
        return longest;
    }
    private String conv(String s) {
        int[] res = new int[26];
        for (char c : s.toCharArray()) {
            res[c-'a']++;
        }
        return Arrays.toString(res);
    }
}