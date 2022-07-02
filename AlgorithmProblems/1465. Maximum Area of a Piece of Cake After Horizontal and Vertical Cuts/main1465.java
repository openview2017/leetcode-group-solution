public class main1465 {
    public static void main(String[] args) {
        
    }
}


class Solution1465 {
    // We will use long instead of int to prevent overflow
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        // Start by sorting the inputs
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int n = horizontalCuts.length;
        int m = verticalCuts.length;
        
        // Consider the edges first
        long maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[n - 1]);
        for (int i = 1; i < n; i++) {
            // horizontalCuts[i] - horizontalCuts[i - 1] represents the distance between
            // two adjacent edges, and thus a possible height
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        
        // Consider the edges first
        long maxWidth = Math.max(verticalCuts[0], w - verticalCuts[m - 1]);
        for (int i = 1; i < m; i++){
            // verticalCuts[i] - verticalCuts[i - 1] represents the distance between
            // two adjacent edges, and thus a possible width
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }

        // Be careful of overflow, and don't forget the modulo!
        return (int) ((maxWidth * maxHeight) % (1000000007));
    }
}