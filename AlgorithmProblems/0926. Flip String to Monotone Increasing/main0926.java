public class main0926 {
    public static void main(String[] args) {
        Solution0926 sol = new Solution0926();
        String s = "00110";
        int res = sol.minFlipsMonoIncr(s);
        System.out.println(res);
    }
}


class Solution0926 {
    public int minFlipsMonoIncr(String s) {
        int res = 0;
        
        int cntOnes = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            // if c is 1, then it will not inpact the minFlips
            // if c is 0, then 2 options we can do to make it mono incr
            // 1. keep it as 0, and flip all the preceeding 1 to 0, need to know the count of ones so far
            // 2. flip it to 1, will not need to do anything
            if(c == '1') cntOnes++;
            else{
                int tmp1 = cntOnes;
                int tmp2 = res + 1;
                res = Math.min(tmp1, tmp2);
            }
        }
        
        return res;
    }
}