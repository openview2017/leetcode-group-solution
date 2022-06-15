# 784. Letter Case Permutation
https://leetcode.com/problems/letter-case-permutation/
- 输入：`String s `字符串 s

  - 将字符串 s 中的每个字母转变大小写，可以获得一个新的字符串
- 输出：`List<String>` 所有可能得到的字符串集合 ；顺序无所谓

```
Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
```

## DFS

*Huichen Ma - June 14 2022*; *Ziheng Gong - June 15 2022*

| 二进制    | 十进制 | 十六进制 | 字符 |
| --------- | ------ | -------- | ---- |
| 0100 0001 | 65     | 0x41     | A    |
| 0100 0010 | 66     | 0x42     | B    |
| 0100 0011 | 67     | 0x43     | C    |
| …         | …      | …        | …    |
| 0110 0001 | 97     | 0x61     | a    |
| 0110 0010 | 98     | 0x62     | b    |
| 0110 0011 | 99     | 0x63     | c    |

转换字母大小写：

- ASCII 里，大写字母与其对应的小写字母的 ASCII 的差为 32， i.e. $2^5$, i.e. `1 << 5`
  - `小写字母 -  32` → 大写字母
  - `大写字母 + 32` → 小写字母
- 也就是说，`字母 ^ 1 << 5` 就可以得到其另外的 case

Complexity Analysis:

- Time Complexity: $O(2 ^ n)$

Java

```java
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, result);
        return result;
    }
    
    private void dfs(char[] charArray, int index, List<String> result) {
        if (index == charArray.length) {
            result.add(new String(charArray));
            return;
        }
        
        // 不变
        dfs(charArray, index + 1, result);
        // 变
        if (Character.isLetter(charArray[index])) {
            charArray[index] ^= 1 << 5;
            dfs(charArray, index + 1, result);
        }
    }
}
```

Python

```python
class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        result = [] 
        self.dfs(list(s), 0, result)
        # [["a","1","b","2"],["a","1","B","2"],["A","1","B","2"],["A","1","b","2"]]
        return ["".join(item) for item in result]
    
    
    def dfs(self, array, index, result):
        if index == len(array):
            result.append(array.copy())
            return
        
        self.dfs(array, index + 1, result)
        
        if array[index].isalpha():
            changed_case = ord(array[index]) ^ 1 << 5
            array[index] = chr(changed_case)
            self.dfs(array, index + 1, result)
```