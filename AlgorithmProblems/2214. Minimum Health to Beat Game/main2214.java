import java.util.Arrays;

public class main2214 {
    public static void main(String[] args) {
        int res, armor, damage[];
        Solution2214 sol = new Solution2214();
        
        damage = new int[]{2,7,4,3}; 
        armor = 4;
        res = (int) sol.minimumHealth(damage, armor);
        System.out.println("damage: " + Arrays.toString(damage));
        System.out.println("armor: " + armor);
        System.out.println("minHealth: " + res);
        
        damage = new int[]{2,5,3,4}; 
        armor = 7;
        res = (int) sol.minimumHealth(damage, armor);
        System.out.println("damage: " + Arrays.toString(damage));
        System.out.println("armor: " + armor);
        System.out.println("minHealth: " + res);
                
        damage = new int[]{3,3,3}; 
        armor = 10;
        res = (int) sol.minimumHealth(damage, armor);
        System.out.println("damage: " + Arrays.toString(damage));
        System.out.println("armor: " + armor);
        System.out.println("minHealth: " + res);
    }
}

class Solution2214 {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0, max = 0;
        for(int a: damage) {
            sum += a;
            max = Math.max(a, max);
        }
        return sum - Math.min(max, armor)+1;        
    }
}