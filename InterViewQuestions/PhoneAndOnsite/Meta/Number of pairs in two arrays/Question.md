# Find number of pairs in 2 arrays meeting condition  

**Reference:**   
(https://leetcode.com/discuss/interview-question/1719834/Meta-coding-question-2022)  

**Description:**  
Given two arrays of integers a and b of the same length, find the number of pairs (i, j) such that i <=j
and a[i] - b[j] = a[j] - b[i].  

**Example:**  
. For a= [2, -2, 5, 3] and b= [1, 5, -1, 1], the output should be solution (a, b) = 6.

. For (1, 5) = (0, 0) equality holds: a[0] - b[0] = 2 - 1 = 1 and a[0] - b[0] = 2- 1 = 1

. For (1, 3) = (0, 1) equality holds: a[0] - b[1]= 2 - 5 = -3 and a[1] - b[0]= (-2) - 1 = -3,

. For (1, 3) = (0, 2) equality doesn't hold: a[0] - b[2] =  2 - (-1) = 3 and a[2] - b[0] = 5-1 = 4.

and so on ............