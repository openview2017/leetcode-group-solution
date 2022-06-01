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

class Solution0692 {
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

class Solution {
    
    public class WordFreq {
        String word;
        int freq;
        public WordFreq(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }
    
    public void quickSelect(WordFreq[] array, int left, int right, int k) {
        int partitionIndex = partition(array, left, right);
        if(partitionIndex == k) {
            return;
        } else if (partitionIndex < k) {
            quickSelect(array, partitionIndex + 1, right, k);
        } else {
            quickSelect(array, left, partitionIndex - 1, k);
        }
    }
    
   // The difference here is quite obvious
   // quick select searches one partition each level
   // while quickSort goes through each partition regardless of partitionIndex
    public void quickSort(WordFreq[] array, int left, int right) {
        if(left >= right) return;
        int partitionIndex = partition(array, left, right);
        quickSort(array, partitionIndex + 1, right);
        quickSort(array, left, partitionIndex - 1);
    }
    
    public int partition(WordFreq[] array, int left, int right) {
        int partitionIndex = left + (right - left)/2;
        WordFreq checkPoint = array[partitionIndex];
        int storedIndex = left;
        swap(array, partitionIndex, right);
        for(int i = left; i < right; i++) {
            if(compareWordFreq(array[i], checkPoint) < 0) {
                swap(array, i, storedIndex);
                storedIndex++;
            }
        }
        swap(array, storedIndex, right);
        return storedIndex;
    }
    
    public void swap(WordFreq[] array, int a, int b) {
        WordFreq temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
    public int compareWordFreq(WordFreq a, WordFreq b) {
        if(a.freq == b.freq) {
            return a.word.compareTo(b.word);
        } else {
            return b.freq - a.freq;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        WordFreq[] array = new WordFreq[map.size()];
        int index = 0;
        for(String word : map.keySet()) {
            array[index++] = new WordFreq(word, map.get(word));
        }
      
        // pay attention that the k should be k-1 otherwise it will be array index out of bound when left == right in partition
        // quickSelect(array, 0, array.length - 1, k - 1);
        quickSort(array, 0, array.length - 1);
        
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i < k; i++) {
            res.add(array[i].word);
        }
        // When using QuickSelect, needs extra sort here
		//         Comparator<String> comp = Comparator
		//             .comparing((String w) -> -map.get(w)) 
		//             .thenComparing(Comparator.naturalOrder());
		//         Collections.sort(res, comp);
        return res;
    }
}





class Solution0692_0 {
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