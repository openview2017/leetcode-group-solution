public class main0245 {
    public static void main(String[] args) {
        Solution0245 sol = new Solution0245();
        String wordsDict[], word1, word2;
        int dist;

        wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        word1 = "makes";
        word2 = "coding";
        dist = sol.shortestWordDistance(wordsDict, word1, word2);
        System.out.println(dist);

        wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        word1 = "makes";
        word2 = "makes";
        dist = sol.shortestWordDistance(wordsDict, word1, word2);
        System.out.println(dist);        
    }
}


class Solution0245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int res = wordsDict.length;
        int prev = -1;
        for (int i = 0 ; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                if (prev != -1 && (word1.equals(word2) || !wordsDict[prev].equals(wordsDict[i]))) {
                    res = Math.min(i - prev, res);
                }
                prev = i;
            }
        }
        return res;
    }
}