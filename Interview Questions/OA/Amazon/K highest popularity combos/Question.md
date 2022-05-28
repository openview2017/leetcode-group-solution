# K highest popularity combos  

**Reference:**   
(https://leetcode.com/discuss/interview-question/1625460/amazon-oa-find-k-maximum-priority)  
(https://leetcode.com/discuss/interview-question/1474709/amazon-interview-question-k-highest-combination-sum)  

A combo is defined as a subset of the given n terms. The total popularity is the sum of the individual items of the combo. design an algorithmn that can find the k combos with the highest popularity.  
two combos are considered different if they have different subset of items. return the array of k integers where the ith term denotes the popularity of ith best combo. Combos should be returned arranged best to worst.  

**Example1**  
n = 3  
array = [3,5,-2]  
k = 3  
All possible populatrity of combos are 0,3,5,-2,8,3,1,6 .  
The best 3 are 8,6,5.  
hence , answer is [8,6,5].  

**Example2**  
n = 4  
array = [1, 2, -2]  
k = 2;  
combinations possible are:  
[] - Empty set is also a combo with 0 rating.  
[1] : 1  
[2] : 2  
[-2] : -2  
[1, 2] : 3  
[1, -2] : -1  
[2, -2] : 0  
[1,2,-2] : 1  
Here the top 2 combos are: 3 and 2. Hence this should be returned. Answer is [3, 2]  

**Constraints**  
1 <= n <= 10^5  
-10^9 <= array[i] <= 10^9  
1 <= k <= min(2000,2^n)  