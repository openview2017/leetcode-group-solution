public class main0014 {
    
}

class Solution0014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        for (int i = 0; i < minLen; i++) { // cur index
            boolean allEqual = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[j-1].charAt(i)) {
                    allEqual = false;
                    break;
                }
            }
            if (allEqual) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }
}