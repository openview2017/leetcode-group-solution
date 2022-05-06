import java.util.*;

public class main0128 {
    public static void main(String[] args) {
        Solution0128 sol = new Solution0128();
        int nums[], count;

        nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        count = sol.longestConsecutive(nums);
        System.out.println(count);
    }
}

class Solution0128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}