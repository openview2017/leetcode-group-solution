


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

# 347. Top K Frequent Elements

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. o(1)
        if (k == nums.length) {
            return nums;
        }
        
        Map<Integer,  Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        
        Queue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2) );
        
        for (int e1 : count.keySet()) {
            minHeap.offer(e1);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        int[] res = new int[minHeap.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = minHeap.poll();
        }
        return res;
    }
}


```


# 215. Kth Largest Element in an Array
``` java
class Solution { 
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }
    
    private int findKthLargest(int[] nums, int left, int right, int k) {
        int pivot = left + (int)((right - left + 1) * Math.random());
        pivot = left;
        swap(nums, pivot, right);
        for (int i = left; i < right; i++) {
            if (nums[i] <= nums[right]) {
                swap(nums, i, pivot++);
            }
        }
        swap(nums, pivot, right);
        int count = right - pivot + 1;
        if (count == k) return nums[pivot];
        if (count > k) return findKthLargest(nums, pivot + 1, right, k);
        return findKthLargest(nums, left, pivot - 1, k - count);
    }
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
```

# 973. K Closest Points to Origin