public class main0126 {
    
}


class Solution { //14 - 25
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Deque<List<String>> queue = new ArrayDeque<>();
        List<String> path = new ArrayList<>(Arrays.asList(beginWord));
        
        Set<String> dictSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();

        // 1. init
        queue.offerLast(path); // string, integer (from beginWord to string, 2)
        while (!queue.isEmpty()) {
            int size = queue.size(); //1
            while (size-- > 0) { // for (int i = 0; i < size; i++)
                List<String> curPath = queue.pollFirst();
                List<String> neis = getNei(curPath.get(curPath.size() - 1), dictSet);
                for (String nei : neis) {
                    List<String> nextPath = new ArrayList<>(curPath);
                    nextPath.add(nei);
                    visited.add(nei);
                    if (nei.equals(endWord)) {
                        res.add(nextPath);
                    } else {
                        queue.offerLast(nextPath);
                    }
                }    
            }
            for (String v : visited) dictSet.remove(v);
            if (res.size() > 0) break;
        }
        return res;
    }
    
    private List<String> getNei(String str, Set<String> dict) { // tc: o(26n)
        List<String> nei = new ArrayList<>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char orig = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != orig) {
                    arr[i] = c;
                    String newStr = new String(arr);
                    if (dict.contains(newStr)) {
                        nei.add(newStr);
                    }
                }
                arr[i] = orig;
            }
        }
        return nei;
    }
}