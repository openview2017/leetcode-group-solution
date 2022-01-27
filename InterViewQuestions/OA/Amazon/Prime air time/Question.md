# Prime Air time (Optimally utilized travel distance) (high frequency)

**Reference:**  
(https://leetcode.com/discuss/interview-question/1025705/amazon-oa-prime-air-time)  

This problem is a variant of closest pair sum. You'll be given two arrays  
    *arr1* = { {1, 2000}, {2, 3000}, {3, 4000} }  
    *arr2* = { { 1, 5000 }, {2, 3000} }  
The first element of every pair represents id and the second value represents the value.  
And a target x = 5000  
Find the pairs from both the arrays whose value add up to a sum which is less than the given target and should be close to the target.  

**Output for the above example:**
{ {1, 2} } // Note that the output should be in id's  

Optimally utilized travel distance  
Given max. travel distance and forward and backward route list, return pair of ids of forward and backward routes that optimally utilized the max travel distance.  

eg: max travel distance is : 11000  
    forward route list : [[1,3000],[2,5000],[3,4000],[4,10000]]  
    backward route list : [[1,2000],[2,3000],[3,4000]]  
 
Result : [2,3] ...2 is from forward and 3 is from backward...total distance is 9000...no other combination is there which is >9000 and <=11,000  