import java.util.*;

public class main0167 {
    public static void main(String[] args) {
        Solution0167 sol = new Solution0167();
        int numbers[], target, res[];
        numbers = new int[]{2,7,11,15};
        target = 9;
        res = sol.twoSum(numbers, target);
        System.out.println(Arrays.toString(res));
    }
}

class Solution0167 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i+1, j+1};
            }
            if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{-1, -1};
    }
}