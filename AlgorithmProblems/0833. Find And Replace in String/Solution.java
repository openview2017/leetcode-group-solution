/*
String API:

boolean s.startsWith("llo", int index);

*/
class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
            StringBuilder sb = new StringBuilder();
        
            Map<Integer, String> sourceMap = new HashMap<>(); // 0:ab, 2:ec
            Map<Integer, String> targetMap = new HashMap<>(); // 0:eee, 2:ffff
            
            for (int i = 0; i < indexes.length; i++) {
                sourceMap.put(indexes[i], sources[i]);
                targetMap.put(indexes[i], targets[i]);
            }
            
            int i = 0;
            while (i < S.length()) {
                if (sourceMap.containsKey(i) && S.startsWith(sourceMap.get(i), i)) {
                        sb.append(targetMap.get(i));
                        i = i + sourceMap.get(i).length();             
                } else {
                    sb.append(S.charAt(i));
                    i++;
                }
            }
            
            return sb.toString();
        }
    }
    
    