public class main0243 {
    public static void main(String[] args) {
        
    }
}


class Solution0243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int res = wordsDict.length;
        int prev = -1; // meet prev index of target 2
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                if (prev != -1 && wordsDict[prev].equals(word2)) {
                    res = Math.min(i - prev, res);
                }
                prev = i;
            } else if (wordsDict[i].equals(word2)) {
                if (prev != -1 && wordsDict[prev].equals(word1)) {
                    res = Math.min(i - prev, res);
                }
                prev = i;
            }
        }
        return res;
    }
}