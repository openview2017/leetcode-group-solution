from collections import deque
class PowerConsumptions:
    def getPowerConsumptions(self, bootpower, processpower, powerlimit):
        # Max(bootPower[i...j]) + Sum(processPower[i....j]) * length of subArray.
        if powerlimit <= 0:
            return 0
        max_len = 0
        left = right = 0
        monostack = deque([])
        cur_processPower = 0
        while right < len(bootpower):
            if not monostack:
                total_power = 0
            else:
                total_power = bootpower[monostack[0]]+ cur_processPower * (right-left)
            if total_power <= powerlimit:
                max_len = max(max_len, right-left)
                while monostack and bootpower[monostack[-1]] < bootpower[right]:
                    monostack.pop()
                monostack.append(right)
                cur_processPower += processpower[right]
                right += 1
            else:
                if monostack[0] == left:
                    monostack.popleft()
                cur_processPower -= processpower[left]
                left += 1
        total_power = bootpower[monostack[0]]+ cur_processPower * (right-left)
        if total_power <= powerlimit:
            max_len = max(max_len, right-left)
        return max_len

if __name__ == "__main__":
    # Test case1
    p = PowerConsumptions()
    bootpower = [1,2,3]
    processpower = [4,5,6]
    print(p.getPowerConsumptions(bootpower, processpower, 5))
    print("Expected result: {}".format(1))
    # Test case2
    p = PowerConsumptions()
    bootpower = [5,3,1,4,2]
    processpower = [0,1,1,3,2]
    print(p.getPowerConsumptions(bootpower, processpower, 11))
    print("Expected result: {}".format(3))
    # Test case3
    p = PowerConsumptions()
    bootpower = [8,9,5,3,1]
    processpower = [9,9,0,1,1]
    print(p.getPowerConsumptions(bootpower, processpower, 11))
    print("Expected result: {}".format(3))