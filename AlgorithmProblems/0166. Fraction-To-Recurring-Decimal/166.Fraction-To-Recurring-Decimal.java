/*
https://www.youtube.com/watch?v=WJMrceU-ujs 
*/
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        //如果一正一负，给sb加一个负号在前面
        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) {
            sb.append("-");
        }
        
        //取abs绝对值时，如果是int最小值，会overflow，换成long
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // 先append整数部分，如果可以整除，就可以return了。
        sb.append(num / den);
        long remainder = num % den;
        if (remainder == 0) {
            return sb.toString();
        }
        
        //如果没有除净，进入小数部分
        sb.append(".");
        
        //使用map来记录每个数和其位置，用于加括号
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "("); // insert at index xx with yy
                sb.append(")");
                break;
            }
           
            map.put(remainder, sb.length());// 4:2， 40:3， 67:4， 
            remainder = remainder * 10; // 400//670
            sb.append(remainder / den);  //0.01//0.012
            remainder = remainder % den;//4
        }
        
        return sb.toString();
    }
}