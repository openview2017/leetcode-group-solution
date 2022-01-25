# Sort array with minimum swaps  
**reference link**: (https://leetcode.com/discuss/interview-question/1655441/Amazon-or-OA) question 2  

As part of your Day 1 Orientation at Amazon, you've been invited to participate in a programming challenge. Please represent your team
by completing the following challenge:  

Given an array of binary digits, O and 1, sort the array so that all zeros are at one end and all ones are at the other. Which end does not
matter. To sort the array, swap any two adjacent elements. Determine the minimum number of swaps to sort the array.  

**Example**  
arr=[0,1,0,1]  
With 1 move, switching elements 1 and 2, yields [0, 0, 1, 1], a sorted array.  

**Function Description**  
Complete the function minMoves in the editor below.  
*minMoves* has the following parameter(s):  
*int arr[n]*: an array of binary digits  

**Returns**  
*int*: the minimum number of moves necessary  

**Constraints**  
• 1 <= n <= 10^5  
arr[i] is in the set {0,1}  