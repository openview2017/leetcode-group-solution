from collections import deque
class CountMaximumTeams:
    def teamCount(self, skill, teamSize, maxDiff):
        if not skill or len(skill) < teamSize:
            return 0
        result = 0
        skill = sorted(skill, reverse=True)
        left, right = 0, teamSize - 1
        while right < len(skill):
            if skill[left] - skill[right] <= maxDiff:
                result += 1
                left = right + 1
                right += teamSize
            else:
                left += 1
                right += 1        
        return result

if __name__ == "__main__":
    # Test case1
    skill = [3, 4, 3, 1, 6, 5]  
    teamSize = 3  
    maxDiff = 2 
    c = CountMaximumTeams()
    print(c.teamCount(skill,teamSize,maxDiff))
    print("Expected result: {}".format(2))

    # Test case2
    skill = [21, 20, 19, 10, 9, 2, 2, 2]  
    teamSize = 2  
    maxDiff = 1
    c = CountMaximumTeams()
    print(c.teamCount(skill,teamSize,maxDiff))
    print("Expected result: {}".format(3))

    # Test case3
    skill = [100, 90, 80, 70, 60]  
    teamSize = 3  
    maxDiff = 1
    c = CountMaximumTeams()
    print(c.teamCount(skill,teamSize,maxDiff))
    print("Expected result: {}".format(0))
