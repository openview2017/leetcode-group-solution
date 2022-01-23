


# 378. Kth Smallest Element in a Sorted Matrix
```java
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.val == c2.val) {
                    return 0;
                }
                return c1.val - c2.val;
            }
        });
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for (int i = 1; i < k; i++) {
            Cell tmp = minHeap.poll(); // expand
            int tmpx = tmp.x;
            int tmpy = tmp.y;
            
            if (tmpx + 1 < row && !visited[tmpx + 1][tmpy]) {
                minHeap.offer(new Cell(tmpx + 1, tmpy, matrix[tmpx+1][tmpy]));
                visited[tmpx + 1][tmpy] = true;
            }
            if (tmpy + 1 < col && !visited[tmpx][tmpy + 1]) {
                minHeap.offer(new Cell(tmpx, tmpy + 1, matrix[tmpx][tmpy+1]));    
                visited[tmpx][tmpy + 1] = true;
            }
        }
        return minHeap.poll().val;
    }
}

class Cell {
    int x, y, val;
    public Cell(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}


```

# 692. Top K Frequent Words
```java
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0 || k == 0) {
            return new ArrayList<String>();
        }
        // 1. conv to hashmap<string, integer> - tc/sc: o(n)
        Map<String, Integer> freqMap = new HashMap<>();
        for (String str : words) {
            freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
        }
        
        // 2. pq minheap from map.value: tc: o(nlogk); sc: o(k)
        Queue<String> minHeap = new PriorityQueue<String>((w1, w2) -> freqMap.get(w1).equals(freqMap.get(w2)) ?
                w2.compareTo(w1) : freqMap.get(w1) - freqMap.get(w2) );
        
        for(String str : freqMap.keySet()) {
            minHeap.offer(str);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // 3. output: tc/sc: o(k)
        List<String> ans = new ArrayList();
        while (!minHeap.isEmpty()) ans.add(minHeap.poll());
        Collections.reverse(ans);
        return ans;
    }
}


```

