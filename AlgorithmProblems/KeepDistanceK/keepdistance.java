// print all possible combinations for keep distance questions

import java.util.*;

public class keepdistance {
    public static void main(String[] args) {
        SolutionKeepdistance sol = new SolutionKeepdistance();
        int k = 7;
        // List<String> res = new ArrayList<>();
        sol.keepDistance00(k);
    }
}

class SolutionKeepdistance {
    public void keepDistance00(int k) {
        int[] arr = new int[2*k];
        List<String> res = new ArrayList<>();
        helper(arr, k, res);
        System.out.println(Arrays.toString(res.toArray()));
    }
    

    private void helper(int[] arr, int k, List<String> res) {
        if (k == 0) {
            res.add(Arrays.toString(arr));
            return;
        }
        for (int i = 0; i + k + 1 < arr.length; i++) {
            if (arr[i] == 0 && arr[i + k + 1] == 0) {
                arr[i] = k;
                arr[i + k + 1] = k;
                //System.out.println(Arrays.toString(arr));
                helper(arr, k - 1, res);

                arr[i] = 0;
                arr[i + k + 1] = 0;
            }
        }
        return;
    }
}