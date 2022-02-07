/*
Given an integer k, arrange the sequence of integers [1, 1, 2, 2, 3, 3, ...., k - 1, k - 1, k, k], such that the output integer array satisfy this condition:

Between each two i's, they are exactly i integers (for example: between the two 1s, there is one number, between the two 2's there are two numbers).

If there does not exist such sequence, return null.

Assumptions:

k is guaranteed to be > 0
Examples:

k = 3, The output = { 2, 3, 1, 2, 1, 3 }.
*/

public class Solution {
    public int[] keepDistance(int k) {
     int[] array = new int[2 * k];
      return helper(array, k)? array : null; 
    }
    // the below method returns whether there exists a way to put down the 1...k numbers, and put it in the array
    private boolean helper(int[] array, int k) {
      if (k == 0) {
        return true;
      }
      for (int i = 0; i + k + 1 < array.length; i++) {
        if (array[i] == 0 && array[i + k + 1] == 0) {
          array[i] = k;
          array[i + k + 1] = k;
  
          if (helper(array, k - 1)) {
            return true;
          }
  
          array[i] = 0;
          array[i + k + 1] = 0;
        }
      }
      //return false;
    }
  }
  
  // O(k!)
