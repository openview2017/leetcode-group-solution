class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = new Comparator<>(){
             public int compare(Integer a, Integer b) {
                if (nums[a] != nums[b]) {
                    return Integer.compare(nums[a], nums[b]);
                }
                else {
                    return a - b;
                }
            } 
        };
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<>(comparator);
        double[] res = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            left.add(i);
        }
        balance(left, right);
        res[0] = getMedian(k, nums, left, right);

        int r = 1;
        for (int i = k; i < nums.length; i++) {
            if(!left.remove(i - k)) {
                right.remove(i - k);
            }
            right.add(i); 
            left.add(right.pollFirst());
            balance(left, right); 
            res[r] = getMedian(k, nums, left, right);
            r++;
        }

        return res;
    }
    
    private void balance(TreeSet<Integer> left, TreeSet<Integer> right) {
        while (left.size() > right.size()) {
            right.add(left.pollFirst());
        }
    }
    
    private double getMedian(int k, int[] nums, TreeSet<Integer> left, TreeSet<Integer> right) {
        if (k % 2 == 0) {
            return ((double) nums[left.first()] + nums[right.first()]) / 2;
        }
        else {
            return (double) nums[right.first()];
        }
    }
}