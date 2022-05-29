public class main0318 {
    
}

class Solution { // 31 - 36
    public int maxProduct(String[] words) {
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            masks[i] = convMask(words[i]);
        }
        int res = 0;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    res = Math.max(res,  words[i].length() * words[j].length());
                }   
            }
        }
        return res;
    }
    
    private int convMask(String str) {
        int m = 0;
        for (char c : str.toCharArray()) {
            m |= (1 << (c - 'a'));
        }
        return m;
    }
}