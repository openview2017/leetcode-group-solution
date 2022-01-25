# Count maximum teams

**Reference link:** (https://leetcode.com/discuss/interview-question/1594880/Amazon-OA-questions-countMaximumTeams)  

Amazon is hosting a team hackathon.

1. Each team will have exactly teamSize developers.  
2. A developer's skill level is denoted by skill[i].  
3. The difference between the maximum and minimum skill levels within a team cannot exceed a threshold, maxDiff.  

Determine the maximum number of teams that can be formed from the contestants.  

**Example**  
*skill* = [3, 4, 3, 1, 6, 5]  
*teamSize* = 3  
*maxDiff* = 2  

                                Maximum Skill Level = 6  
                                Minimum Skill Level = 4  
                                Difference =6-4=2 <= maxDiff  
                    _________________________________________________
                    |                                   |           |
        3           4           3           1           6           5
        |_______________________|___________|
            Maximum Skill Level = 3  
            Minimum Skill Level = 1  
            Difference = 3-1 = 2 <= maxDiff  

At most, 2 teams can be formed: *[3, 3, 1]* and *[4, 6, 5]*. The difference between the maximum and minimum skill levels is 2 in each case, which does not exceed the threshold value of 2.  

**Function Description**  
Complete the function countMaximumTeams in the editor below.  

*countMaximumTeams* has the following parameter(s):  
    *int skill[n]*: the developers' skill levels  
    *int teamSize*: the number of developers to make up a team  
    *int maxDiff*: the threshold value  

**Returns:**  
    *int*: the maximum number of teams that can be formed at one time

**Constraints**  
- 1 ≤ teamSize ≤ n ≤ 10^5  
- 1 ≤ maxDiff ≤ 10^9  
- 1 ≤ skill[i] ≤ 10^9  