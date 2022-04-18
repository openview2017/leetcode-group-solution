/*

单调栈的方法：
思路：
1. max sliding window,要求的是每一个window里面的最大值，放入result里面。
2. 数据结构：deque， deque里面放当前window的最大值，和未来window的可能的最大值
3. deque里面放index，这样好用于index和位置的对比
3. 通过一个sliding window，一个index i，来看每个element。
						如果新的element比deque的last的element大，说明那时候的deque里的future最大值不会成立，就把那些小的删掉，加入当前这个更大的，在deque的最后
						如果deque的first的element的index已经出界了，也要poll出来
						把当前的element的index加入到deque
						如果可以往res里加东西了，就加
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();// store index of current and future max values
        
        int index = 0;
        for (int i = 0; i < len; i++) {
            
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            //看window里有几个element。如果有k个了，那就要先把前面的删掉
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            //每一个element都会被加到deque
            deque.offerLast(i);
            
            //开始添加res
            if (i >= k - 1) {
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
