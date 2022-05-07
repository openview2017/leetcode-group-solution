public class main1920 {
    
}

class Solution1920 {
    public int[] buildArray(int[] nums) {
        int mask = 1023; // Decimal value of the binary number '1111111111'
        for(int i = 0; i < nums.length; i++)
            nums[i] |= (nums[nums[i]] & mask) << 10;
        for(int i = 0; i < nums.length; i++)
            nums[i] = nums[i] >> 10;
        return nums;
    }
    public int[] buildArray2(int[] nums) { // hashing thought, https://leetcode.com/problems/build-array-from-permutation/discuss/1316500/Java-solution-using-O(1)-space-with-explanation
        int n = nums.length; 
        System.out.println(Arrays.toString(nums));
        for(int i=0; i<n; i++){
            // this is done to keep both old and new value together. 
            // going by the example of [5,0,1,2,3,4]
            // after this nums[0] will be 5 + 6*(4%6) = 5 + 24 = 29;
            // now for next index calulation we might need the original value of num[0] which can be obtain by num[0]%6 = 29%6 = 5;
            // if we want to get just he new value of num[0], we can get it by num[0]/6 = 29/6 = 4
            nums[i] = nums[i] + n*(nums[nums[i]] % n);
        }
        System.out.println(Arrays.toString(nums));
        for(int i=0; i<n; i++){
            nums[i] = nums[i]/n;
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }    
}
    // bit shift https://leetcode.com/problems/build-array-from-permutation/discuss/1315480/Java-or-O(1)-Space-O(n)-Time
    