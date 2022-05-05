import java.util.*;

public class main0068 {
    public static void main(String[] args) {
        Solution0068 sol = new Solution0068();
        String words[];
        //int maxWith;
        List<String> res;

        words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        res = sol.fullJustify(words, maxWidth);
        System.out.println(Arrays.deepToString(res.toArray()));
    }
}

class Solution0068 { // 22 - 32 - 40
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int wIdx = 0, wLen = words.length;
        
        while (wIdx < wLen) {
            int count = words[wIdx].length();
            int next = wIdx + 1;
            while (next < wLen) {
                if (words[next].length() + count + 1 > maxWidth) break;
                count += words[next].length() + 1;  // add ' '
                next++;
            }
            
            StringBuilder sb = new StringBuilder();
            int spaceCount = next - wIdx - 1;
            // left align
            if (next == wLen || spaceCount == 0) {
                midAlign(sb, wIdx, next, maxWidth, words);
            } else { // mid align
                leftAlign(sb, wIdx, next, count, spaceCount, maxWidth, words);
            }
            res.add(sb.toString());
            wIdx = next;
        }
        return res;
    }
    
    private void midAlign(StringBuilder sb, int wIdx, int next, int maxWidth, String[] words) {
        for (int i = wIdx; i < next; i++) {
            sb.append(words[i] + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        for (int i = sb.length(); i < maxWidth; i++) {
            sb.append(" ");
        }         
    }
    
    private void leftAlign(StringBuilder sb, int wIdx, int next, int count, int spaceCount, int maxWidth, String[] words) {
        int space = (maxWidth - count) / spaceCount;
        int spaceRem = (maxWidth - count) % spaceCount;
        for (int i = wIdx; i < next; i++) {
            sb.append(words[i]);
            if (i < next - 1) {
                for (int j = 0; j <= (space + ((i - wIdx) < spaceRem ? 1 : 0)); j++) {
                    sb.append(" ");
                }
            }
        }        
    }
}