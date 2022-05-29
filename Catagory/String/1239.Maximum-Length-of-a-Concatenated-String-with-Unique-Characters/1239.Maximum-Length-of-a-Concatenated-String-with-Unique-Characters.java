class Solution {

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) return 0;
        int[] maxLength = new int[1];
        //use a bit map to represent each string and its length, set length to 0 if string has dup letter
        int n = arr.size();
        int[][] bitmap = new int[n][2];
        for (int i = 0; i < n; i++) {
            int collection = 0;
            for (char c : arr.get(i).toCharArray()) {
                // get the int to represent this letter
                int bit = c -'a';

                //check if we have this letter in collection
                if (((collection >> bit) & 1) == 1) {
                    //if this letter exist, reset collection to empty and skip this str
                    collection = 0;
                    break;
                }
                //if we dont have this letter, then add cur letter to collection
                collection = collection | (1 << bit);
            }
            //fill bit map with information
            bitmap[i][0] = collection;
            bitmap[i][1] = collection == 0 ? 0 : arr.get(i).length();
        }

        // dfs(arr, 0, "", maxLength);
        dfsWithBitMap(bitmap, 0, maxLength, 0, 0);
        return maxLength[0];
    }

    //Solution 2 dfs + check
    private void dfs(List<String> arr, int index, String path, int[] maxLength) {
        //path must be unique when pass in, so update max length directly
        maxLength[0] = Math.max(maxLength[0], path.length());

        for (int i = index; i < arr.size(); i++) {
            if (checkUnique(path + arr.get(i))) {
                dfs(arr, i + 1, path + arr.get(i), maxLength);
            }
        }
    }

    private boolean checkUnique(String str) {
        int[] letter = new int[26];
        for (char c : str.toCharArray()) {
            letter[c - 'a'] += 1;
            if (letter[c - 'a'] > 1) return false;
        }
        return true;
    }

    //Solution3 : DFS + Bitmap
    private void dfsWithBitMap(int[][] bitmap, int index, int[] maxLength, int curLength, int curBit) {
        maxLength[0] = Math.max(maxLength[0], curLength);
        for (int i = index; i < bitmap.length; i++) {
            //skip duplicated string and duplicated concatenation
            if (bitmap[i][1] == 0 || (curBit & bitmap[i][0]) != 0) continue;
            dfsWithBitMap(bitmap, i + 1, maxLength, curLength + bitmap[i][1], curBit | bitmap[i][0]);
        }
    }
}