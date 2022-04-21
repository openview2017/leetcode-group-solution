import java.util.Arrays;

public class main0360 {
    public static void main(String[] args) {
        Solution360 sol = new Solution360();
        int nums[], a, b, c, res[];
        nums = new int[]{-4,-2,2,4};
        a = 1; b = 3; c = 5;
        res = sol.sortTransformedArray(nums, a, b, c);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(res));
    }
}

class Solution360 { 
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int i = a >= 0 ? nums.length - 1 : 0;
        while(start <= end) {
            int startNum = getNum(nums[start], a, b, c);
            int endNum = getNum(nums[end], a, b, c);
            if(a >= 0) {
                if(startNum >= endNum) {
                    res[i--] = startNum;
                    start++;
                }
                else{
                    res[i--] = endNum;
                    end--;
                }
            }
            else{
                if(startNum <= endNum) {
                    res[i++] = startNum;
                    start++;
                }
                else{
                    res[i++] = endNum;
                    end--;
                }
            }
        }
        return res;
    }
    public int getNum(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
/*abstract
if a>0: the quadratic function is something like this

y
^
|	+               +
|	 +             +
|	   +         +
|		   + +
---------------------------> x
if a<0: the quadratic function is something like this

y
^
|	       + +
|	   +         +  
|	 +             +
|	+	            +
---------------------------> x
*/