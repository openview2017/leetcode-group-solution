package SuspiciousActivity;

import java.util.*;

/**
 * Created by yingli on 5/24/22.
 */
public class Solution {
    public static void main(String[] arg) {

        Solution sol = new Solution();
        Set<String> suspiciousSet = new HashSet<>();
        suspiciousSet.add("Brad");
        suspiciousSet.add("San Francisco");
        suspiciousSet.add("withdraw");

        List<String> activity1 = new ArrayList<>(Arrays.asList("Joe", "Miami", "withdraw"));
        List<String> activity2 = new ArrayList<>(Arrays.asList("John", "San Francisco", "deposit"));
        List<String> activity3 = new ArrayList<>(Arrays.asList("Albert", "London", "withdraw"));
        List<String> activity4 = new ArrayList<>(Arrays.asList("Diana", "London", "withdraw"));
        List<String> activity5 = new ArrayList<>(Arrays.asList("Diana", "San Francisco", "withdraw"));
        List<String> activity6 = new ArrayList<>(Arrays.asList("Joe", "New York", "update_address"));

        List<List<String>> candidateActivity = new ArrayList<>();
        candidateActivity.add(activity1);
        candidateActivity.add(activity2);
        candidateActivity.add(activity3);
        candidateActivity.add(activity4);
        candidateActivity.add(activity5);
        candidateActivity.add(activity6);

        List<List<String>> res = sol.suspiciousActivity(suspiciousSet, candidateActivity, 2);

        for (List<String> activity : res) {
            System.out.println(activity);
        }
    }

    public List<List<String>> suspiciousActivity(Set<String> suspiciousSet, List<List<String>> candidate_activity, int k) {

        return findSuspiciousList(suspiciousSet, candidate_activity, k, new HashSet<>(), 1);
    }


    //DFS recursion
    private List<List<String>> findSuspiciousList(Set<String> suspiciousSet, List<List<String>> candidate_activity, int k, Set<Integer> visited, int depth) {
        List<List<String>> suspiciousActivityList = new ArrayList<>();
        int count = 0;
        boolean flag = false;
        int index = -1;
        for (int i = 0; i < candidate_activity.size(); i++) {
            if (visited.contains(i)) continue;
            List<String> curActivity = candidate_activity.get(i);

            for (String activity : curActivity) {
                if (suspiciousSet.contains(activity)) {
                    count++;
                }
                if (count == k) {
                    flag = true;
                    index = i;
                    break;
                }
            }
            //if we find a suspicious activity at index
            if (flag) {
                curActivity.add(String.valueOf(depth));
                suspiciousActivityList.add(curActivity);
                suspiciousSet.addAll(curActivity);
                visited.add(index);
                List<List<String>> suspiciousListNextLevel = findSuspiciousList(suspiciousSet, candidate_activity, k, visited, depth + 1);
                suspiciousActivityList.addAll(suspiciousListNextLevel);
                //reset flag
                flag = false;
            }

            //reset count
            count = 0;
        }
        return suspiciousActivityList;

    }

    //BFS with depth

}
