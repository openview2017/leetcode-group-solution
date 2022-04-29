/*
https://www.youtube.com/watch?v=6hFyHU7BNlI

brute force: n^2, 对于每一个值，找右边的比他大的最大的数，交换。

O(n)的方法：
step1: 遍历这个num，记录下每一个数字最后出现的index
step2: 再次从左到右遍历这个num，从9开始看，到比这个数大的数，看是否在后面有出现，有的话，就可以swap

TC: O(n)
SC: O(10) indexLast array, used to 记录每个数字最后一次出现的index
*/

class Solution {
    public int maximumSwap(int num) {
        char[] array = String.valueOf(num).toCharArray();
        
        int[] indexLast = new int[10]; // 记录每一个数字最后一次出现的index
        for (int i = 0; i < array.length; i++) {
            indexLast[array[i] - '0'] = i;
        }
        
    
        for (int i = 0; i < array.length; i++) {
            int cur = array[i] - '0';
            for (int j = 9; j > cur; j--) {
                if (indexLast[j] > i) {
                    swap(array, indexLast[j], i);
                    return Integer.valueOf(String.valueOf(array));
                }
            }

        }
        return num;
    }
    
    private void swap(char[] array, int x, int y) {
        char tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}