# LintCode 1848 · 单词搜索 III

[1848 · 单词搜索 III - LintCode](https://www.lintcode.com/problem/1848)

- Word Search II 是返回找到的所有的单词

- 此题是返回最多可以**同时**找到的词的个数
- 「同时」意味着单词之间互相不能有重叠

![](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/b7d2abc2-f0a7-4004-8983-f4b9fa1aa136/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220616%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220616T014255Z&X-Amz-Expires=86400&X-Amz-Signature=7df5dca066c021e924134250e79c37df56be7984fd285e013f971bcc1d6212ea&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

## DFS +  Trie

*Ziheng Gong - June 15 2022*

```java
public class Solution {
    int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int wordSearchIII(char[][] board, List<String> words) {
        int[] result = {0};
        int wordCount = 0;
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        } 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, board, trie.getRoot(), trie, visited, wordCount, result);
            }
        }

        return result[0];
    }

    void dfs(
        int x, int y, char[][] board, 
        TrieNode node, Trie trie,
        boolean[][] visited,
        int wordCount, int[] result    
    ) {
        // 当前格子不是一个前缀
        if (!node.children.containsKey(board[x][y])) {
            return;
        }
        int n = board.length, m = board[0].length;
        visited[x][y] = true;
        TrieNode child = node.children.get(board[x][y]);
        
        // 找到了一个单词
        if (child.isWord) {
            wordCount++;
            child.isWord = false; //标记这个单词为使用过 
            result[0] = Math.max(result[0], wordCount);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j]) {
                        continue;
                    }
                    dfs(i, j, board, trie.getRoot(), trie, visited, wordCount, result);
                }
            }
            wordCount--;
            child.isWord = true; // 回溯
        }

        for (int i = 0; i < 4; i++) {
            int nX = x + DIRECTIONS[i][0];
            int nY = y + DIRECTIONS[i][1];

            if (!isValid(nX, nY, visited)) {
                continue;
            }
            dfs(nX, nY, board, child, trie, visited, wordCount, result);

        }
        visited[x][y] = false; // 回溯
    }

    boolean isValid(int x, int y, boolean[][] visited) {
        if (x < 0 || x >= visited.length) {
            return false;
        }
        
        if (y < 0 || y >= visited[0].length) {
            return false;
        }

        return !visited[x][y];

    }

    class TrieNode {
        public Map<Character, TrieNode> children;
        public boolean isWord;
        public String word;
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            isWord = false;
            word = null;
    }    
}

    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        
        public TrieNode getRoot() {
            return root;
        }
        
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (!node.children.containsKey(letter)) {
                    node.children.put(letter, new TrieNode());
                }
                node = node.children.get(letter);
            }
            
            node.isWord = true;
            node.word = word;
        }
        
    }
}
```

