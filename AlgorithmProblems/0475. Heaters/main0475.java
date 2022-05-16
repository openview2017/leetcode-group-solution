public class main0475 {
    public static void main(String[] args) {
        Solution0475 sol = new Solution0475();
        int houses[], heaters[], res;

        houses = new int[]{1,2,3};
        heaters = new int[]{2};
        res = sol.findRadius(houses, heaters);
        System.out.println(res);

    }
}

class Solution0475 { // 30
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);        
        Arrays.sort(heaters);
        int m = houses.length, n = heaters.length;
        int heatRad = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            int curDist = Math.abs(houses[i] - heaters[j]);
            int nextDist = Integer.MAX_VALUE;
            if (j < n - 1) {
                nextDist = Math.abs(houses[i] - heaters[j+1]);
            }
            if (curDist < nextDist) {
                heatRad = Math.max(heatRad, curDist);
                i++;
            } else {
                j++;
            }
        }
        return heatRad;
    }
}