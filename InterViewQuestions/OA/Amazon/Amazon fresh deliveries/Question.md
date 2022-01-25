# Amazon fresh deliveries
**reference link**: (https://leetcode.com/discuss/interview-question/1033264/amazon-oa-1-year-experienced-for-sde1)

**Similar leetcode question**: 
[215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)

**Solution link**: [Click](/AlgorithmProblems/215.Kth%20Largest%20Element%20in%20an%20Array/215.Kth-Largest-Element-in-an-Array.py)

Amazon Fresh Deliveries
Given allLocations list of co-ordinates (x,y) you have to find the X - closest locations from truck's location which is (0,0). Distance is calculated using formula (x^2 + y^2).
If the there is tie then choose the co-ordinate with least x value.
Sample Input :
allLocations : [ [1, 2] , [1, -1], [3, 4] ]
numOfDeliveries : 2
Sample Output :
[ [1, -1], [1 , 2] ]
Output list can be in any order.
This question was basically K closest points to the origin (0,0) with added tie condition.