# 212. Word Search II

Same as [LintCode 132](https://www.lintcode.com/problem/132/)

See also LeetCode - [79. Word Search](https://leetcode.com/problems/word-search/); LintCode - 1848 Word Search III

输入一个图和一个单词表，问哪些词在图中能找到

```输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
输出：["eat","oath"]
```

![Untitled](https://assets.leetcode.com/uploads/2020/11/07/search1.jpg)

## Pseudo-Trie (Set) Solution

*Ziheng Gong - June 15 2022*

- DFS 搜索什么时候结束：

  1. 如果 dfs 路径长度大于最大词的长度，结束递归
  2. 如果 dfs 路径不是某个词的前缀，结束递归

- 意味着要用 Trie：

  ![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ba4df069-18af-41aa-ac29-0f0f5f41ca14/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220616%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220616T010355Z&X-Amz-Expires=86400&X-Amz-Signature=00fa7cf8fb0593cc754526aa9a7869f9ee013c6ea79c7408c1e842be20cdfbbd&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

- 同一个词可能在结果中找到多次 —— 用 set 去重

LeetCode - Time Limit Exceeded

LeetCode 有病：**63 / 63** test cases passed, but took too long.

Java:

```java
class Solution {
    public static int[] dx = {0, 1, -1, 0};
    public static int[] dy = {1, 0, 0, -1};
    
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0] == null|| board[0].length == 0 ) {
            return new ArrayList<>();
        }
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        Set<String> wordSet = new HashSet<>(); // 词
        Set<String> prefixSet = new HashSet<>(); // 词和前缀
        
        // 初始化两个 Set
        for (String word : words){
            for (int i = 0; i < word.length(); i++) {
                prefixSet.add(word.substring(0, i + 1));
            }
            wordSet.add(word);
        }
            
        Set<String> resultSet = new HashSet<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                dfs(board, visited, i, j, Character.toString(board[i][j]), wordSet, prefixSet, resultSet);
                visited[i][j] = false;                
            }
        }
        
        return new ArrayList<String>(resultSet);
    }
    
    public void dfs(char[][] board, 
                    boolean[][] visited,
                    int x,
                    int y,
                    String word,
                    Set<String> wordSet,
                    Set<String> prefixSet,
                    Set<String> resultSet)
    {
        
        if(!prefixSet.contains(word)) {
            return;
        }
    
    
        if (wordSet.contains(word)) {
            resultSet.add(word);
        }
    
        for (int i = 0; i< 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            
            if (!isInside(board, nX, nY) || visited[nX][nY]) {
                continue;
            }
            
            visited[nX][nY] = true;
            dfs(board, visited, nX, nY, word + board[nX][nY],wordSet, prefixSet, resultSet);
            visited[nX][nY] = false;
        }
    }
        
    private boolean isInside(char[][] board, int x, int y) {
        return x >=0 && x < board.length && y >= 0 && y < board[0].length;
    }
     
}
```

Python

```python
DIRECTIONS = [(0, -1), (0, 1), (-1, 0), (1, 0)]

class Solution:
    def findWords(self, board, words):
        if board is None or len(board) == 0:
            return []
        
        word_set = set(words) # 所有需要找的词
        prefix_set = set() # 所有词的前缀，包括整个词
        for word in words:
            for i in range(len(word)):
                prefix_set.add(word[:i + 1])
        
        result = set()
        for i in range(len(board)):
            for j in range(len(board[0])):
                c = board[i][j]
                self.search(
                    board,
                    i,
                    j,
                    board[i][j],
                    word_set,
                    prefix_set,
                    set([(i, j)]),
                    result,
                )
                
        return list(result)
        
    def search(self, board, x, y, word, word_set, prefix_set, visited, result):
        if word not in prefix_set:
            return
        
        if word in word_set:
            result.add(word)
        
        for delta_x, delta_y in DIRECTIONS:
            x_ = x + delta_x
            y_ = y + delta_y
            
            if not self.inside(board, x_, y_):
                continue
            if (x_, y_) in visited:
                continue
            
            visited.add((x_, y_))
            self.search(
                board,
                x_,
                y_,
                word + board[x_][y_],
                word_set,
                prefix_set,
                visited,
                result,
            )
            visited.remove((x_, y_))
            
    def inside(self, board, x, y):
        return 0 <= x < len(board) and 0 <= y < len(board[0])
```

## DFS - Trie Solution

*Ziheng Gong - June 15 2022*

- 遍历 board 中的所有格子
- 从每个格子出发进行 DFS，探索相邻且不重复的路径
  - 如果当前路径是一个 word 的前缀 —— 继续搜索
  - 如果当前路径是一个 word —— 添加到 result 中
  - 如果当前路径不是一个 word 的前缀 —— 剪枝
- 结果要使用 set 去重；因为同一单词可能出现在不同路径中

Java

```java
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> result = new HashSet<String>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(board, trie.getRoot(), i, j, result);
            }
        }

        return new ArrayList<String>(result);
    }

    public void dfs(char[][] board, TrieNode node, int x, int y, Set<String> result) {
        if (!node.children.containsKey(board[x][y])) {
            return;
        }
        char ch = board[x][y];
        node = node.children.get(ch);
        if (!"".equals(node.word) && node.word != null) {
            result.add(node.word);
        }

        board[x][y] = '#';
        for (int[] dir : dirs) {
            int nX = x + dir[0], nY = y + dir[1];
            if (nX >= 0 && nX < board.length && nY >= 0 && nY < board[0].length) {
                dfs(board, node, nX, nY, result);
            }
        }
        board[x][y] = ch;
    }
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
```

Python

LeetCode - Time Limit Exceeded

```python
from collections import defaultdict

class TrieNode:         #定义字典树的节点
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.is_word = False
        self.word = None
        
        
class Trie:
    def __init__(self):
        self.root = TrieNode()
        
    def add(self, word):        #字典树插入单词
        node = self.root
        for letter in word:
            if letter not in node.children:
                node.children[letter] = TrieNode()   #在此节点申请节点
            node = node.children[letter]            #继续遍历
        node.is_word = True
        node.word = word        #存入单词
        

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = Trie()
        for word in words:
            trie.add(word)

        result = set()
        

        for i in range(len(board)):
            for j in range(len(board[0])):
                self.dfs(board, trie.root, i, j, result)

        return list(result)

    def dfs(self, board, node, i, j, result):
        m, n = len(board), len(board[0])
        if board[i][j] not in node.children:
            return

        char = board[i][j]

        node = node.children[char]
        if node.word is not None:
            result.add(node.word)

        board[i][j] = "#"
        for n_i, n_j in [(i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)]:
            if 0 <= n_i < m and 0 <= n_j < n:
                self.dfs(board, node, n_i, n_j, result)
        board[i][j] = char
```