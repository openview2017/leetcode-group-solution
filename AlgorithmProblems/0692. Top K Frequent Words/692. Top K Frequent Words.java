/*
692. Top K Frequent Words
Medium

Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.



*/

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