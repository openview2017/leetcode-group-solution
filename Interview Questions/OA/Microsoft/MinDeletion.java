/**
 * Created by yingli on 4/21/22.
 */
public class MinDeletion {

    public static void main(String[] args) {
        MinDeletion test = new MinDeletion();
        String str = "ABBAABABABABBBBBBBBBBAAAAAA";
        System.out.println(test.minDeletion(str));
        System.out.println(test.minDeletion2(str));
    }
    public int minDeletion(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int count = 0;
        int maxCount = 0;

        //find how many B, assume we delete every B
        for (char c : str.toCharArray()) {
            if (c == 'B') {
                count += 1;
            }
        }
        maxCount = count;

        //find A from left to right
        for (char c : str.toCharArray()) {
            if (c == 'A') {
                count += 1;
            } else {
                count -= 1;
            }
            //each step, update maxCount
            maxCount = Math.max(maxCount, count);
        }
        return str.length() - maxCount;

    }

    public int minDeletion2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int BCount = 0;
        int deletionCount = 0;
        for (char c : str.toCharArray()) {
            if (c == 'B') {
                BCount += 1;
            } else {
                //determine delete current A,  or all previous B

                //assume if we delete current A
                deletionCount += 1;

                //if delete all previous B need less effort, we will delete all previous B
                deletionCount = Math.min(deletionCount, BCount);
            }
        }
        return deletionCount;
    }
}
