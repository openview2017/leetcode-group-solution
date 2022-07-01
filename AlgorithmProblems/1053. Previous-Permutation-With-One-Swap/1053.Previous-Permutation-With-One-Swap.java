//TBD
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        //find the first larger num from right , keep pre permutation order, largest smaller
        int lastPeak = -1;
        for (int i = arr.length - 1; i >= 1 ; i--) {
            if (arr[i - 1] > arr[i]) {
                lastPeak = i - 1;
                break;
            }
        }
        //if we cannot find arr[i - 1] > arr[i], means all arr[i - 1] <= arr[i], SORTED
        if (lastPeak == -1) return arr;

        //find the last largest smaller num from right to lastPeak
        int lastSmallerThanPeak = arr.length;
        for (int i = arr.length - 1; i > lastPeak; i--) {
            if (arr[i] < arr[lastPeak] && arr[i] != arr[i - 1]) {
                lastSmallerThanPeak = i;
                break;
            }
        }
        //cannot find smaller num of peak from right, sorted, should slready covered in previous check
        if (lastSmallerThanPeak == arr.length) return arr;

        // if (secondLastPeak == -1) return
        int temp = arr[lastPeak];
        arr[lastPeak] = arr[lastSmallerThanPeak];
        arr[lastSmallerThanPeak] = temp;
        return arr;
    }
}