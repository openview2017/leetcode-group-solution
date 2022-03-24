import java.util.*;

/*
Example 1:

Input: password = "a"
Output: 5
Example 2:

Input: password = "aA1"
Output: 3
Example 3:

Input: password = "1337C0d3"
Output: 0


*/

public class main0420 {
    public static void main(String[] args) {
        Solution0420 sol = new Solution0420();
        String password;
        int res;

        password = "a";
        res = sol.strongPasswordChecker(password);
        System.out.println(password + ": " + res);
        
        password = "aA1";
        res = sol.strongPasswordChecker(password);
        System.out.println(password + ": " + res);
        
        password = "1337C0d3";
        res = sol.strongPasswordChecker(password);
        System.out.println(password + ": " + res);
    }
}


class Solution0420 {
    public int strongPasswordChecker(String password) {
        int len = password.length(), kind = 0;
        boolean number, lower, upper;
        number = lower = upper = false;
        List<Integer> continuousList = new ArrayList<>();
        char[] pw = password.toCharArray();
        for (int i = 0; i < len; i++) {
            char c = pw[i];
            if (!number && Character.isDigit(c)) {
                number = true;
                kind++;
            } else if (!lower && Character.isLowerCase(c)) {
                lower = true;
                kind++;
            } else if (!upper && Character.isUpperCase(c)) {
                upper = true;
                kind++;
            }
            int continuous = 1;
            while (i + 1 < len && pw[i + 1] == c) {
                i++;
                continuous++;
            }
            if (continuous >= 3) {
                continuousList.add(continuous);
            }
        }
        // 满足要求，返回0
        if (len >= 6 && len <= 20 && kind == 3 && continuousList.isEmpty()) {
            return 0;
        }
        // 需要增加的字符种类，可以通过insert或update
        int needChangeByKind = 3 - kind;
        if (len >= 6 && len <= 20) {
            // 数量满足要求只需要update即可
            // needChangeByContinuous=continuous/3
            int needChangeByContinuous = 0;
            for (int continuous : continuousList) {
                needChangeByContinuous += continuous / 3;
            }
            return Math.max(needChangeByContinuous, needChangeByKind);
        } else if (len < 6) {
            // 需要insert
            int needInsert = 6 - len;
            // 1. 如果需要插入2个或2个以上，仅考虑插入的数量就可以满足密码要求
            // 2. 如果只需要插入1个，以下两种情况需要insert一次，update一次，其它情况均只需要操作1次：
            //      a. 连续五个相同的字母
            //      b. 虽然不是五个相同的字母，但是字符种类只有一种
            // 综上： 如果只需要插入1个字母，且字符种类只有一种时需要操作2次。其它情况均只需要考虑需要插入的个数即可
            if (needInsert == 1 && needChangeByKind == 2) {
                return 2;
            }
            return needInsert;
        } else {
            // 需要delete
            int needDelete = len - 20;
            // 1.仅通过删除就可以解决多个字符连续问题，则直接返回needDelete+needChangeByKind
            int needDeleteByContinuous = 0;
            for (int continuous : continuousList) {
                needDeleteByContinuous += (continuous - 2);
            }
            if (needDelete >= needDeleteByContinuous) {
                return needDelete + needChangeByKind;
            }
            // 2.仅通过删除无法解决多个字符连续的问题，那么就需要删除连续字符，使得需要替换的字符数量最少
            // 2.1 先考虑删除一个连续的字符，就可以使得需要替换的字符减少一个的
            int remain = needDelete;
            for (int i = 0; i < continuousList.size(); i++) {
                int continuous = continuousList.get(i);
                if (continuous % 3 == 0) {
                    continuousList.set(i, continuous - 1);
                    if (--remain == 0) {
                        break;
                    }
                }
            }
            // 2.2 再考虑删除两个连续的字符，就可以使得需要替换的字符减少一个的
            if (remain > 1) {
                for (int i = 0; i < continuousList.size(); i++) {
                    int continuous = continuousList.get(i);
                    if ((continuous - 1) % 3 == 0) {
                        continuousList.set(i, continuous - 2);
                        if ((remain -= 2) < 2) {
                            break;
                        }
                    }
                }
            }
            // 2.3 再考虑删除三个连续的字符的情况
            while (remain > 2) {
                for (int i = 0; i < continuousList.size(); i++) {
                    int continuous = continuousList.get(i);
                    if (continuous > 2) {
                        continuousList.set(i, continuous - 3);
                        if ((remain -= 3) < 3) {
                            break;
                        }
                    }
                }
            }
            // 经过以上删除步骤后，remain可能为0，1，2但这都不影响结果
            int needChangeByContinuous = 0;
            for (int continuous : continuousList) {
                needChangeByContinuous += continuous / 3;
            }
            return needDelete + Math.max(needChangeByContinuous, needChangeByKind);
        }
    }
}
//https://leetcode-cn.com/problems/strong-password-checker/solution/si-lu-qing-xi-ban-yun-ban-ben-by-bakezq/
//https://leetcode-cn.com/problems/strong-password-checker/solution/zhi-xing-1ms-ji-bai-100-javajie-ti-si-lu-by-chu-yu/