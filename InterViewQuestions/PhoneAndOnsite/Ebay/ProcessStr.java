/*
Input :You love having a great time.
[you, love, having, a, great, time]
[a, you, love, time, great, having]
[A, you, love, time, great, having.]
Result : A you love time great having.
*/

import java.util.*;

public class ProcessStr {
    public static void main(String[] args) {
        String s = "You love having a great time.";
        System.out.println("Input :" + s);
        // step 1. preprocessing;
        String[] strArr = s.split(" ");
        strArr[0] = strArr[0].toLowerCase();
        StringBuilder lastSb = new StringBuilder(strArr[strArr.length - 1]);
        strArr[strArr.length - 1]= lastSb.deleteCharAt(lastSb.length()-1).toString();
        System.out.println(Arrays.toString(strArr));
        
        // 2. sort the processed string
        Arrays.sort(strArr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }
                return s1.compareTo(s2);
            }
        });
        System.out.println(Arrays.toString(strArr));
        
        // 3. post processing string array
        strArr[0] = strArr[0].substring(0).toUpperCase() + strArr[0].substring(1);
        strArr[strArr.length - 1] = strArr[strArr.length - 1] + '.';
        System.out.println(Arrays.toString(strArr));
        
        // 4. combine result.
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        String res = sb.toString();
        System.out.println("Result : " + res);
        /* Method 2 of step 4
        String res = String.join(" ", strArr);
        System.out.println(res);
        */
        // tc/sc: o(n), n - character
    }    
}
