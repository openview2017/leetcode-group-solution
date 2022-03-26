/*
Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"



*/

public class main0273 {
    public static void main(String[] args) {
        Solution0273 sol = new Solution0273();
        int num;
        String str;

        num = 123;
        str = sol.numberToWords(num);
        System.out.println(num + ": " + str);
        
        num = 12345;
        str = sol.numberToWords(num);
        System.out.println(num + ": " + str);
        
        num = 1234567;
        str = sol.numberToWords(num);
        System.out.println(num + ": " + str);
    }
}


class Solution0273 {
    public String numberToWords(int num) {
        if(num==0) {
            return "Zero";
        }
        return helper(num);
    }
    public String helper(int num) {
        String[] words = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", 
		"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        StringBuilder res = new StringBuilder();
        
        if(num>=1000000000) {
            res.append(helper(num/1000000000)).append(" Billion ").append(helper(num%1000000000));
        } else if(num>=1000000) {
            res.append(helper(num/1000000)).append(" Million ").append(helper(num%1000000));
        } else if(num>=1000) {
            res.append(helper(num/1000)).append(" Thousand ").append(helper(num%1000));
        } else if(num>=100) {
            res.append(helper(num/100)).append(" Hundred ").append(helper(num%100));
        } else if(num>=20) {
            res.append(words[(num-20)/10+20]).append(" ").append(words[num%10]);
        } else {
            res.append(words[num]);
        }
        
        return res.toString().trim();
    }
}