from collections import deque
class CountMaximumTeams:
    def teamCount(self, skill, teamSize, maxDiff):
        if not skill or len(skill) < teamSize:
            return 0
        result = 0
        skill = sorted(skill, reverse=True)
        left = right = 0
        max_stack = deque([])  #[idx1, idx2]
        min_stack = deque([])
        while right < len(skill):
            while max_stack and skill[right] > skill[max_stack[-1]]:
                max_stack.pop()
            while min_stack and skill[right] < skill[min_stack[-1]]:
                min_stack.pop()
            max_stack.append(right)
            min_stack.append(right)
            right += 1
            if skill[max_stack[0]] - skill[min_stack[0]] > maxDiff:
                if max_stack[0] == left:
                    max_stack.popleft()
                if min_stack[0] == left:
                    min_stack.popleft()
                left += 1
            if right - left == teamSize:
                result += 1
                left = right
                max_stack.clear()
                min_stack.clear()
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