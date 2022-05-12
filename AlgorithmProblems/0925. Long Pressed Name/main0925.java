public class main0925 {
    public static void main(String[] args) {
        Solution0925 sol = new Solution0925();
        String name = "alex", typed = "aaleex";
        boolean res = sol.isLongPressedName(name, typed);
        System.out.println(res);
    }
}

class Solution0925 {
    public boolean isLongPressedName(String name, String typed) {
        int m = name.length(), n = typed.length();
        int i = 0, j = 0;
        
        while(i < m && j < n){
            char c1 = name.charAt(i), c2 = typed.charAt(j);
            if(c1 != c2) return false; // we are handling different chars, no!
            
			// count of consecutive c1/c2
            int count1 = 0; 
            while(i < m && name.charAt(i) == c1){
                count1++;
                i++;
            }
            
			// count of consecutive c1/c2
            int count2 = 0; 
            while(j < n && typed.charAt(j) == c2){
                count2++;
                j++;
            }
            
            if(count2 < count1) return false;
        }
        
		// they both reach the end
        return i == m && j == n;
    }
}