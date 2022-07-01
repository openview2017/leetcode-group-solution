### 1239. Maximum Length of a Concatenated String with Unique Characters
### https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

#### Solution1 : Brute Force
```
for each String curStr in list  [takes n]
        set up a set/array, add all letter to set [takes m ]
            start from curStr, try to concatenate following string [takes time n * m]
            keep updating max length, max length is max size of set
```
Time: n * m * (n * m)
Space: set/array of max size 26


#### Solution2: DFS

consider current string, check unique char , store these char to somewhere
use recursion to deal with following string

eg
```
dfs(arr, path, index) - > for (i = index + 1 to end )
                               dfs(arr, path + arr.get(index), i)
```

#### Solution2 : DFS + bitmap // use bitmap to replace int array to check unique letter
```
        int[][] bitmap = new int[n][2];
        bitmap[i][0] represent a string by bit
        bitmap[i][1] represent a string length by int

```
