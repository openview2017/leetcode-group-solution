/*
总结：
1. 把reverse的数通过*10和%10的方法求出来
2. 注意不要overflow，修改一下reversed number的输出类型就可以
3. x在走的过程中变了，要转存一下，最后才好对比

*/
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long reversed = 0;
        int cur = x;
        while (x > 0) {
            reversed = reversed * 10 + x % 10; // r=121
            x = x / 10; // x =1
        }
        if (reversed == (long) cur) {
            return true;
        } else {
            return false;
        }
    }
}