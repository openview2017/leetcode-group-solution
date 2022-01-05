class Solution {
    private final Map<Character, Integer> vowels = new HashMap<>() {
        {
            put('a', 0);
            put('o', 1);
            put('e', 2);
            put('i', 3);
            put('u', 4);
        }
    };
    public int findTheLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        int vowelCombinationState = 0;
        Map<Integer, Integer> stateIndexMap = new HashMap<>();
        //initailization !!!!
        stateIndexMap.put(0, -1);
        for (int i = 0; i < s.length(); i++) {
            //check if cur letter is vowel
            char c = s.charAt(i);
            if (vowels.containsKey(c)) {
                int num = vowels.get(c);
                int bitRepresent = 1 << num;
                //if same vowel found, reset to 0,
                //if not same vowel, add it to combination
                vowelCombinationState ^= bitRepresent;
            }
            //if cur letter is not vowel, do nothing to vowelCombinationState
            //update map if we found new vowelCombinationState
            if (!stateIndexMap.containsKey(vowelCombinationState)) {
                stateIndexMap.put(vowelCombinationState, i);
            }

            //update result
            res = Math.max(res, i - stateIndexMap.get(vowelCombinationState));
        }
        return res;
    }
}