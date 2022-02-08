import java.util.*;

public class mainoa020822 {
    public static void main(String[] args) {
        SolutionOA020822 sol = new SolutionOA020822();
        List<String> list1, list2, res;
        list1 = Arrays.asList(new String[]{"ACK", "BAC", "BAR"});
        list2 = Arrays.asList(new String[]{"KACT", "BAAC", "ESAD", "BASS"});
        res = sol.selectWord(list1, list2);
        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println(Arrays.toString(list2.toArray()));
        System.out.println(Arrays.toString(res.toArray()));
    }
}

class SolutionOA020822 {
    public List<String> selectWord(List<String> list1, List<String> list2) {
        Set<String> res = new HashSet<>();
        Set<String> dict = new HashSet<>(); // ANAGRAM DICT OF list1
        for (String str : list1) {
            dict.add(conv(str));
        }
        // System.out.println("dict:" + dict.toString());
        for (String str : list2) {
            for (int i = 0; i < str.length(); i++) {
                String tmp = str.substring(0,i) + str.substring(i+1);
                //System.out.println(tmp);
                String tmpcode = conv(tmp);
                if (dict.contains(tmpcode)) {
                    res.add(str);
                }
            }
        }
        return new ArrayList<String>(res);
    }
    private String conv(String s) {
        int[] res = new int[26];
        for (char c : s.toCharArray()) {
            res[c-'A']++;
        }
        return Arrays.toString(res);
    }
}