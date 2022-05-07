public class main2103 {
    
}
class Solution2103 { // 54 - 59
    public int countPoints(String rings) {
        int[] r = new int[10];
        int[] g = new int[10];
        int[] b = new int[10];
        for (int i = 0; i < rings.length(); i+= 2) {
            int idx = (int) (rings.charAt(i+1) - '0');
            char c = rings.charAt(i);
            if (c == 'B') {
                b[idx]++;
            } else if (c == 'G') {
                g[idx]++;
            } else if (c == 'R') {
                r[idx]++;
            }
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (r[i] > 0 && g[i] > 0 && b[i] > 0) {
                count++;
            }
        }
        return count;
    }
}