package SuspiciousActivity;

import java.util.*;

/**
 * Created by yingli on 5/24/22.
 */
public class FindSuspiciousActivity {
    public static void main(String[] arg) {

        FindSuspiciousActivity sol = new FindSuspiciousActivity();
        Set<String> suspiciousSet = new HashSet<>();
        suspiciousSet.add("Brad");
        suspiciousSet.add("San Francisco");
        suspiciousSet.add("withdraw");

        List<String> activity1 = new ArrayList<>(Arrays.asList("Joe", "Miami", "withdraw"));
        List<String> activity2 = new ArrayList<>(Arrays.asList("John", "San Francisco", "deposit"));
        List<String> activity3 = new ArrayList<>(Arrays.asList("Albert", "London", "withdraw"));
        List<String> activity4 = new ArrayList<>(Arrays.asList("Diana", "London", "withdraw"));
        List<String> activity5 = new ArrayList<>(Arrays.asList("Diana", "San Francisco", "withdraw"));
        List<String> activity6 = new ArrayList<>(Arrays.asList("Lynn", "San Francisco", "withdraw"));
        List<String> activity7 = new ArrayList<>(Arrays.asList("Xun", "San Francisco", "withdraw"));
        List<String> activity8 = new ArrayList<>(Arrays.asList("Joe", "New York", "update_address"));

        List<List<String>> candidateActivity = new ArrayList<>();


        candidateActivity.add(activity1);
        candidateActivity.add(activity2);
        candidateActivity.add(activity3);
        candidateActivity.add(activity4);
        candidateActivity.add(activity5);
        candidateActivity.add(activity6);
        candidateActivity.add(activity7);
        candidateActivity.add(activity8);


        List<List<String>> res = sol.suspiciousActivity(suspiciousSet, candidateActivity, 2);

        System.out.println(res.size());
        for (List<String> activity : res) {
            System.out.println(activity);
        }
    }

    public List<List<String>> suspiciousActivity(Set<String> suspiciousSet, List<List<String>> candidate_activity, int k) {

//        return findSuspiciousList(suspiciousSet, candidate_activity, k, new HashSet<>(), 1);
        return BFSFindSuspiciousActivity(suspiciousSet, candidate_activity, k, new HashSet<>());
    }


    //DFS recursion, DFS 算出来的depth不对！！！！

    private List<List<String>> findSuspiciousList(Set<String> suspiciousSet, List<List<String>> candidateActivity, int k, Set<Integer> visited, int depth) {

        List<List<String>> suspiciousActivityList = new ArrayList<>();

        int count = 0;
        int index = -1;
        boolean flag = false;

        for (int i = 0; i < candidateActivity.size(); i++) {
            //avoid loop, check visited
            if (visited.contains(i)) continue;

            List<String> curActivity = candidateActivity.get(i);

            for (String element : curActivity) {
                if (suspiciousSet.contains(element)) {
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
                List<List<String>> suspiciousListNextLevel = findSuspiciousList(suspiciousSet, candidateActivity, k, visited, depth + 1);
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

    private List<List<String>> BFSFindSuspiciousActivity(Set<String> suspiciousSet, List<List<String>> candidateActivity, int k, Set<Integer> visited) {

        List<List<String>> res = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < candidateActivity.size(); i++) {
            queue.offer(i);
        }
        int depth = 1;
        List<String> newSuspiciousElement = new ArrayList<>();
        Map<Integer, List<List<String>>> resWithDepth = new HashMap<>();

        while (!queue.isEmpty()) {
            System.out.println("into loop");
            int size = queue.size();
            newSuspiciousElement = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                if (visited.contains(index)) {
                    break;
                }
                List<String> curCandidateActivity = candidateActivity.get(index);
                int count = 0;
                for (String ele : curCandidateActivity) {
                    if (suspiciousSet.contains(ele)) {
                        count += 1;
                    }
                    if (count == k) {
                        //cur activity is suspicious
                        //add depth , add to res
                        if (!resWithDepth.containsKey(depth)) {
                            resWithDepth.put(depth, new ArrayList<>());
                        }
                        resWithDepth.get(depth).add(curCandidateActivity);

                        visited.add(index);
                        newSuspiciousElement.addAll(curCandidateActivity);
                    }
                }
            }
            if (newSuspiciousElement.size() == 0) break;

            for (int i = 0; i < candidateActivity.size(); i++) {
                if (!visited.contains(i)) {
                    queue.offer(i);
                }
            }
            suspiciousSet.addAll(newSuspiciousElement);
            depth++;

        }
        for (Map.Entry<Integer, List<List<String>>> entry : resWithDepth.entrySet()) {
            List<List<String>>  subRes = resWithDepth.get(entry.getKey());
            for (List<String> each : subRes) {
                each.add(String.valueOf(entry.getKey()));
                res.add(each);
            }

        }
        return res;
    }
}
