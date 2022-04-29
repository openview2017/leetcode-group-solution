class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int[] map = new int[26];
        int odd = 0;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            map[index]++;
            if (map[index] % 2 == 1) {
                odd++;
            } else {
                odd--;
            }
        }
        
        if (odd > 1) {
            return res;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (map[i] >= 2) {
                sb.append((char)(i + 'a'));
                map[i] -= 2;
            }
        }
        
        String center = "";  //如果有center，center就是一个字母，否则center就是一个空位。
        for (int i = 0; i < 26; i++) {
            if (map[i] == 1) {
                center = center + (char)(i + 'a');
            }
        }
        
        char[] array = sb.toString().toCharArray();
        
        helper(res, array, 0, center);
        
        return res;
    }
    
    // 用permutation的方法，找出一半的所有permutation
    // 在base case的时候，把另一半也加上
    private void helper(List<String> res, char[] array, int index, String center) {
        
        if (index == array.length) {
            String cur = mirror(array, center);
            res.add(cur);
        }
        
        Set<Character> set = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            
            char c =  array[i]; // current char
  
            if (set.add(c)) {
                swap(array, i, index);
                helper(res, array, index + 1, center);
                swap(array, i, index);
            }
        }
    }
    
    private void swap(char[] array, int x, int y) {
        char tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
    
    private String mirror(char[] array, String center) {
        String sb = new String(array);
        StringBuilder m = new StringBuilder(sb);
        m.reverse();
        return sb + center + m.toString();
    }

}