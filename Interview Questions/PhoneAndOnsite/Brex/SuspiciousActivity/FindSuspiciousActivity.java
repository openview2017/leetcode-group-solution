package SuspiciousActivity;

import java.util.*;

/**
 * Created by yingli on 5/24/22.
 */
public class FindSuspiciousActivity {
    public static void main(String[] arg) {

        FindSuspiciousActivity sol = new FindSuspiciousActivity();
        List<String> suspicious = new ArrayList<>();
        suspicious.add("Brad");
        suspicious.add("San Francisco");
        suspicious.add("withdraw");

        List<String> activity1 = new ArrayList<>(Arrays.asList("Joe", "Miami", "withdraw"));
        List<String> activity2 = new ArrayList<>(Arrays.asList("John", "San Francisco", "deposit"));
        List<String> activity3 = new ArrayList<>(Arrays.asList("Albert", "London", "withdraw"));
        List<String> activity4 = new ArrayList<>(Arrays.asList("Diana", "London", "withdraw"));
        List<String> activity5 = new ArrayList<>(Arrays.asList("Diana", "San Francisco", "withdraw"));
        List<String> activity6 = new ArrayList<>(Arrays.asList("Lynn", "San Francisco", "withdraw"));
        List<String> activity7 = new ArrayList<>(Arrays.asList("Xun", "San Francisco", "withdraw"));
        List<String> activity8 = new ArrayList<>(Arrays.asList("Joe", "New York", "update_address"));
        List<String> activity9 = new ArrayList<>(Arrays.asList("Albert", "London", "hehe"));


        List<List<String>> candidateActivity = new ArrayList<>();


        candidateActivity.add(activity1);
        candidateActivity.add(activity2);
        candidateActivity.add(activity3);
        candidateActivity.add(activity4);
        candidateActivity.add(activity5);
        candidateActivity.add(activity6);
        candidateActivity.add(activity7);
        candidateActivity.add(activity8);
        candidateActivity.add(activity9);


        List<Activity> res = sol.suspiciousActivity(suspicious, candidateActivity, 2);

        for (Activity activity : res) {
            System.out.println(activity.name + ", " + activity.location + ", " + activity.action + ", " + activity.depth);
        }
    }

    public List<Activity> suspiciousActivity(List<String> suspicious, List<List<String>> candidateActivity, int k) {
        Activity suspiciousActivity = new Activity(suspicious.get(0), suspicious.get(1), suspicious.get(2));
        List<Activity> activities = new ArrayList<>();
        for (List<String> candidate : candidateActivity) {
            activities.add(new Activity(candidate.get(0), candidate.get(1), candidate.get(2)));
        }
        return BFSFindSuspiciousActivity(suspiciousActivity, activities, k, new HashSet<>());
    }

    //BFS with depth
    private List<Activity> BFSFindSuspiciousActivity(Activity suspicious, List<Activity> candidateActivity, int k, Set<Activity> visited) {
        List<Activity> res = new ArrayList<>();
        Queue<Activity> queue = new LinkedList<>();
        queue.offer(suspicious);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Activity curSuspiciousActivity = queue.poll();
                for (Activity activity : candidateActivity) {
                    if (visited.contains(activity)) continue;
                    int similarity = getSimilarity(curSuspiciousActivity, activity);
                    if (similarity >= k) {
                        queue.offer(activity);
                        activity.depth = depth;
                        res.add(activity);
                        visited.add(activity);
                    }
                }
            }
            depth += 1;
        }

        return res;
    }

    private int getSimilarity(Activity a1, Activity a2) {
        if (a1 == null || a2 == null) return -1;
        int count = 0;
        if (a1.name.equals(a2.name)) count += 1;
        if (a1.location.equals(a2.location)) count += 1;
        if (a1.action.equals(a2.action)) count += 1;
        return count;
    }

    class Activity {
        String name;
        String location;
        String action;
        int depth;
        public Activity(String name, String location, String action) {
            this.name = name;
            this.location = location;
            this.action = action;
        }

    }
}
