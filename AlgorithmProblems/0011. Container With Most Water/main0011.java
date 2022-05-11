public class main0011 {
    
}

class Solution0011 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int lmax = height[l], rmax = height[r];
        int curArea = 0, maxArea = 0;
        while (l < r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            if (lmax < rmax) {
                curArea = (r - l) * lmax;
                l++;
            } else {
                curArea = (r - l) * rmax;
                r--;
            }
            maxArea = Math.max(curArea, maxArea);
        }
        return maxArea;
    }
}