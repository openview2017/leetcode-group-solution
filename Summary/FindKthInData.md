


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

# [973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)
``` java
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Use a lambda comparator to sort the PQ by farthest distance
        Queue<int[]> maxPQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < points.length; i++) {
            int[] entry = {squaredDistance(points[i]), i};
            if (maxPQ.size() < k) {
                // Fill the max PQ up to k points
                maxPQ.add(entry);
            } else if (entry[0] < maxPQ.peek()[0]) {
                // If the max PQ is full and a closer point is found,
                // discard the farthest point and add this one
                maxPQ.poll();
                maxPQ.add(entry);
            }
        }
        
        // Return all points stored in the max PQ
        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            int entryIndex = maxPQ.poll()[1];
            answer[i] = points[entryIndex];
        }
        return answer;
    }
    
    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
};

```


``` java
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        return quickSelect(points, k);
    }
    
    private int[][] quickSelect(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        int pivotIndex = points.length;
        while (pivotIndex != k) {
            // Repeatedly partition the array
            // while narrowing in on the kth element
            pivotIndex = partition(points, left, right);
            if (pivotIndex < k) {
                left = pivotIndex;
            } else {
                right = pivotIndex - 1;
            }
        }
        
        // Return the first k elements of the partially sorted array
        return Arrays.copyOf(points, k);
    }

    private int partition(int[][] points, int left, int right) {
        int[] pivot = choosePivot(points, left, right);
        int pivotDist = squaredDistance(pivot);
        while (left < right) {
            // Iterate through the range and swap elements to make sure
            // that all points closer than the pivot are to the left
            if (squaredDistance(points[left]) >= pivotDist) {
                int[] temp = points[left];
                points[left] = points[right];
                points[right] = temp; 
                right--;
            } else {
                left++;
            }
        }
        
        // Ensure the left pointer is just past the end of
        // the left range then return it as the new pivotIndex
        if (squaredDistance(points[left]) < pivotDist)
            left++;
        return left;
    }

    private int[] choosePivot(int[][] points, int left, int right) {
        // Choose a pivot element of the array
        return points[left + (right - left) / 2];
    }
    
    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
}
```


# 703. Kth Largest Element in a Stream
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
``` java
class KthLargest {
    final PriorityQueue<Integer> minHeap;
    final int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<Integer>(k);
        for (int n : nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();    
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
```


# 230. Kth Smallest Element in a BST

``` java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
         Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
         TreeNode p = root;
         int count = 0;

         while(!stack.isEmpty() || p != null) {
             if(p != null) {
                 stack.offerLast(p);    // Just like recursion
                 p = p.left;   

             } else {
                TreeNode node = stack.pollLast();
                if(++count == k) return node.val; 
                p = node.right;
             }
         }

         return Integer.MIN_VALUE;
     }
}

```