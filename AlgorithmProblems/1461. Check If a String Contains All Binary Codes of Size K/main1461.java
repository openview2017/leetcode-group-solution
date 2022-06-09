public class main1461 {
    
}


// class Solution {
//     public boolean hasAllCodes(String s, int k) {
//         int need = 1 << k;
//         Set<String> got = new HashSet<String>();

//         for (int i = k; i <= s.length(); i++) {
//             String a = s.substring(i - k, i);
//             if (!got.contains(a)) {
//                 got.add(a);
//                 need--;
//                 // return true when found all occurrences
//                 if (need == 0) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }

class Solution1461 { // tc:o(n), sc:o(2^k)
    public static boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        boolean[] got = new boolean[need];
        int allOne = need - 1;
        int hashVal = 0;

        for (int i = 0; i < s.length(); i++) {
            // calculate hash for s.substr(i-k+1,i+1), rolling hash of bitmask
            hashVal = ((hashVal << 1) & allOne) | (s.charAt(i) - '0');
                       // remove upperbound,          add new digit
            // hash only available when i-k+1 > 0
            if (i >= k - 1 && !got[hashVal]) {
                got[hashVal] = true;
                need--;
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}