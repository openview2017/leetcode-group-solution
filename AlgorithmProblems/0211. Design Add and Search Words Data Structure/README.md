# 211. Design Add and Search Words Data Structure

[Design Add and Search Words Data Structure - LeetCode](https://leetcode.com/problems/design-add-and-search-words-data-structure/)

Same as  [473 · Add and Search Word - Data structure design - LintCode](https://www.lintcode.com/problem/473/)

- 设计一个包含下面两个操作的数据结构：`addWord(word`),` search(word)`
- addWord(word) 会在数据结构中添加一个单词。
- search(word) 支持普通的单词查询或是只包含 ‘.’ 和 a-z 的简易正则表达式的查询。
- 一个‘.’可以代表一个任何的字母。

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/0aa687a0-3d35-48d7-90ce-8ebb208b05df/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220615%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220615T234505Z&X-Amz-Expires=86400&X-Amz-Signature=fb81e2feb7399ca583d32a36a01d5e6bef9bf841a2967810ec29b2c8c6e905ec&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

---

*Ziheng Gong - June 15 2022*

## HashSet Solution

可以用 HashSet 求解：

- 将所有的可能单词加入哈希表，如 “a.” 对应 “aa” – “az”
- 每次 search(word) 在哈希表中 O(L) 查找串是否存在
- 因为每一个 `.` 都对应 26 个字母，那么一个串长为 L 的只含有 ‘.’ 的串，对应 $26^L$ 个不同的字符串枚举字符串的时间复杂度将达到 $O(26 ^ L)$

## Trie Solution

- 字典树中的相同前缀越多，字典树的优化效果越明显
- 每次添加字符串，查询字符串复杂度最优均为 O(L)
- 最坏情况仍然需要遍历整棵树来得到结果

Python

```python
class TrieNode:
    def __init__(self):
        self.children = dict()
        self.is_word = False
        self.word = None
    
class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def get_root(self):
        return self.root
    
    def insert(self, word):
        node = self.root # 从根节点开始遍历
        
        for i in range(len(word)):
            letter = word[i]
            if letter not in node.children:
                node.children[letter] = TrieNode()
            
            node = node.children[letter]
        
        node.is_word = True
        node.word = word


class WordDictionary:
    def __init__(self):
        self.trie = Trie()

    def addWord(self, word: str) -> None:
        self.trie.insert(word)
        

    def search(self, word: str) -> bool:
        return self.dfs(
            self.trie.get_root(), word, 0
        )
    
    def dfs(self, root, word, index):
        if index == len(word):
            return root.is_word
        
        letter = word[index]
        if letter == ".":
            for child in root.children:
                if self.dfs(root.children[child], word, index + 1):
                    return True
            return False
        
        if letter in root.children:
            return self.dfs(root.children[letter], word, index + 1)
        
        return False
```

Java

```java
public class WordDictionary {

    public class TrieNode {
        public Map<Character, TrieNode> children;
        public boolean isWord;
        public String word;
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            isWord = false;
            word = null;
        }
    }

    public class Trie {
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

                // 移动指针
                node = node.children.get(letter);
            }

            node.isWord = true;
            node.word = word;
        }
    }


    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return dfs(trie.getRoot(), word, 0);
    }

    private boolean dfs(TrieNode root, String word, int index) {
        if (index == word.length()) {
            return root.isWord;
        }

        char letter = word.charAt(index);
        if (letter == '.') {
            for (Character child: root.children.keySet()) {
                if (dfs(root.children.get(child), word, index + 1)) {
                    return true;
                }
            }

            return false;
        }

        if (root.children.containsKey(letter)) {
            return dfs(root.children.get(letter), word, index + 1);
        }

        return false;
    }
}
```

``` java 
// solution 2 Zhao
class WordDictionary { 
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a']; 
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) { 
        return search(word.toCharArray(), 0, root);       
    }
    
    private boolean search(char[] arr, int index, TrieNode curr) {
        if (curr == null) {
            return false;
        }
        if (index == arr.length) {
            return curr.isWord;
        }
        if (arr[index] == '.') {
            for (TrieNode child : curr.children) {
                if (search(arr, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            curr = curr.children[arr[index] - 'a'];
            return search(arr, index + 1, curr);
        }
    }
}

class TrieNode {
    boolean isWord = false;
    TrieNode[] children = new TrieNode[26]; 
}



```