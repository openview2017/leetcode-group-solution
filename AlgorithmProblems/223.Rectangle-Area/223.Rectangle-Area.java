class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int aArea = (ax2 - ax1) * (ay2 - ay1);
        int bArea = (bx2 - bx1) * (by2 - by1);
        //if one of the area is 0
        if (ax1 == ax2 || ay1 == ay2) return bArea;
        if (bx1 == bx2 || by1 == by2) return aArea;

        //if two areas have no overlap
        if (ax2 <= bx1 || bx2 <= ax1 || ay2 <= by1 || by2 <= ay1) return aArea + bArea;

        int overLapX1 = Math.max(ax1, bx1);
        int overLapX2 = Math.min(ax2, bx2);
        int overLapY1 = Math.max(ay1, by1);
        int overLapY2 = Math.min(ay2, by2);


        // if (overLapX2 <= overLapX1 || overLapY2 <= overLapY1) return 0;
        int overLapArea = (overLapX2 - overLapX1) * (overLapY2 -overLapY1);

        return aArea + bArea - overLapArea;
    }
}