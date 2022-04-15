public class main0605 {
    public static void main(String[] args) {
        Solution0605 sol = new Solution0605();
        int flowerbed[], n;
        boolean res;

        flowerbed = new int[]{1,0,0,0,1};
        n = 1;
        res = sol.canPlaceFlowers(flowerbed, n);
        System.out.println(res);

        flowerbed = new int[]{1,0,0,0,1};
        n = 2;
        res = sol.canPlaceFlowers(flowerbed, n);
        System.out.println(res);        
    }
}


class Solution0605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 1;
        int result = 0;
        for(int i=0; i<flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                count++;
            }else {
                result += (count-1)/2;
                count = 0;
            }
        }
        if(count != 0) result += count/2;
        return result>=n;
    }
}

// reference: https://leetcode.com/problems/can-place-flowers/discuss/103883/Java-Very-easy-solution