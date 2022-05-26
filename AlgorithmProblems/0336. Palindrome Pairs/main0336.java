class TrieNode {
    public int wordEnding = -1; // We'll use -1 to mean there's no word ending here.
    public Map<Character, TrieNode> next = new HashMap<>();
    public List<Integer> palindromePrefixRemaining = new ArrayList<>();
}

class Solution0336 {

    // Is the given string a palindrome after index i?
    // Tip: Leave this as a method stub in an interview unless you have time
    // or the interviewer tells you to write it. The Trie itself should be
    // the main focus of your time.
    public boolean hasPalindromeRemaining(String s, int i) {
        int p1 = i;
        int p2 = s.length() - 1;
        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) return false;
            p1++; p2--;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {

        TrieNode trie = new TrieNode();

        // Build the Trie
        for (int wordId = 0; wordId < words.length; wordId++) {
            String word = words[wordId];
            String reversedWord = new StringBuilder(word).reverse().toString();
            TrieNode currentTrieLevel = trie;
            for (int j = 0; j < word.length(); j++) {
                if (hasPalindromeRemaining(reversedWord, j)) {
                    currentTrieLevel.palindromePrefixRemaining.add(wordId);
                }
                Character c = reversedWord.charAt(j);
                if (!currentTrieLevel.next.containsKey(c)) {
                    currentTrieLevel.next.put(c, new TrieNode());
                }
                currentTrieLevel = currentTrieLevel.next.get(c);
            }
            currentTrieLevel.wordEnding = wordId;
        }

        // Find pairs
        List<List<Integer>> pairs = new ArrayList<>();
        for (int wordId = 0; wordId < words.length; wordId++) {
            String word = words[wordId];
            TrieNode currentTrieLevel = trie;
            for (int j = 0; j < word.length(); j++) {
                // Check for pairs of case 3. We have a palindrome left on the word and are on a word end node (case 3).
                if (currentTrieLevel.wordEnding != -1
                   && hasPalindromeRemaining(word, j)) { //   a bccb,  a
                    pairs.add(Arrays.asList(wordId, currentTrieLevel.wordEnding));
                }
                // Move down to the next trie level.
                Character c = word.charAt(j);
                currentTrieLevel = currentTrieLevel.next.get(c);
                if (currentTrieLevel == null) break;
            }
            if (currentTrieLevel == null) continue;
            // Check for pairs of case 1. Note the check to prevent non distinct pairs.  dcba(0),  dcba(1)
            if (currentTrieLevel.wordEnding != -1 && currentTrieLevel.wordEnding != wordId) {
                pairs.add(Arrays.asList(wordId, currentTrieLevel.wordEnding));
            }
            // Check for pairs of case 2. We have no letters left on the word and there are indexes in the list attached to the node (case 2).  dcda(0),  dcd
            for (int other : currentTrieLevel.palindromePrefixRemaining) { //abc  -> cab
                pairs.add(Arrays.asList(wordId, other));
            }
        }

        return pairs;
    }
}

