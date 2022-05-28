# Robot removes obstacles  
**reference link**:   
(https://leetcode.com/discuss/interview-question/1257344/amazon-oa-demolition-of-robot)  
(https://leetcode.com/discuss/interview-question/1033264/amazon-oa-1-year-experienced-for-sde1)  

You are in charge of preparing a recently purchased lot for one of Amazon's new buildings. The lot is covered with trenches and has a single obstacle that needs to be taken down before the foundation can be prepared for the building. The demolition robot must remove the obstacle before progress can be made on the building. Write an algorithm to determine the minimum distance required for the demolition robot to remove the obstacle.  

**Assumptions**:  
• The lot is flat, except for trenches, and can be represented as a two-dimensional grid.  
• The demolition robot must start from the top-left corner of the lot, which is always flat, and can move one block up, down, left, or right at a time.  
• The demolition robot cannot enter trenches and cannot leave the lot.  
• The flat areas are represented as 1, areas with trenches are represented by 0 and the obstacle is represented by 9.  

**Input**  
The input to the function/method consists of one argument:  
lot, representing the two-dimensional grid of integers.  

**Output**  
Return an integer representing the minimum distance traversed to remove the obstacle else return -1.  

**Constraints**  
1 <= numRows, numColumns <=1000  

**Example**  
Input:  
lot= [[1, 0, 0],  
      [1, 0, 0],  
      [1, 9, 1]]  

Output:  
3  

**Explanation**:  
In a matrix, 1 means there is a way, 0 means no way, and 9 means the destination. Starting from the upper left corner, find the shortest distance to destination 9. If it cannot be reached, return -1.  

Pay attention to several boundary conditions: This question hides a condition that the robot starts from the (0,0) coordinates in the upper left corner, which means that the value corresponding to the (0,0) coordinates must be 1, otherwise it will return -1 without a solution. But there is a pit, if the starting point is 9, you need to return 0  