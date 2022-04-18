# Power consumption of servers  

**reference link**: (https://leetcode.com/discuss/interview-question/1636493/Amazon-or-OA-or-Max-Length-of-Valid-Server-Cluster)  

**Similar leetcode question**:   
[239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)  

**Question description:**
Give you a list servers. Their processing power is given as a array of integer, and boot power as a array of integer.  
Write a function to return the max length of sub array which's power consumption is less than or equal to max power limit.  
Formula to calculate the power consumption for a subArray is:  
Max(bootPower[i...j]) + Sum(processPower[i....j]) * length of subArray.  

Note: Single server is also a subArray, return 0 if no such subArray can be found.  