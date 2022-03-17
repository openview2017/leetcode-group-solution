import java.util.Arrays;

public class countDescSubarray {
    public static void main(String[] args) {
        int[] arr;
        int count;
        countDescSubarray sol = new countDescSubarray();

        arr = new int[]{9, 8, 4, 9, 3};
        count = sol.countDesSubarray(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
        
        arr = new int[]{9, 8, 7, 6, 5};
        count = sol.countDesSubarray(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
                
        arr = new int[]{10, 10, 10};
        count = sol.countDesSubarray(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }

    public int countDesSubarray(int[] arr) {
        int count = 0;
        if (arr.length == 0) {
            return count;
        } else if (arr.length == 1) {
            return 1;
        }
        //int prev = arr[0];
        int curLen = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                curLen += 1;
            } else {
                count += (curLen + 1) * curLen / 2;
                curLen = 1;
            }
            //System.out.println(curLen);
        }
        count += (curLen + 1) * curLen / 2;
        return count;
    }
}
