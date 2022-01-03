class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        return dfs(s, 0, '#', 0, k, map);
    }

    private int dfs(String s, int index, char preLetter, int countOfPreLetter, int k, Map<String, Integer> map) {
        String key = index + "#" + preLetter + "#" + countOfPreLetter + "#" + k;
        //memo to reduce time
        if (map.containsKey(key)) return map.get(key);

        //base case1
        if (k < 0) {
            return Integer.MAX_VALUE;
        }
        //base case2
        if (index >= s.length()) {
            return 0;
        }
        //if map dose not have combination, we need to calculate length by recursion
        //if cur letter is same with pre letter
        if (s.charAt(index) == preLetter) {
            //same letter, count + 1, move forward index
            int length = dfs(s, index + 1, preLetter, countOfPreLetter + 1, k, map);
            if (countOfPreLetter == 9 || countOfPreLetter == 99 || countOfPreLetter == 1) {
                length += 1;
            }
            map.put(key, length);
        } else {
            //if cur letter is new letter, we will decide delete it or not
            //if delete cur letter, pre and precount will remain
            int delete = dfs(s, index + 1, preLetter, countOfPreLetter, k - 1, map);
            //if not delete, pre will update to current letter, count will update to 1
            int notDelete = 1 + dfs(s, index + 1, s.charAt(index), 1, k, map);
            int length = Math.min(delete, notDelete);
            map.put(key, length);
        }
        return map.get(key);
    }



}