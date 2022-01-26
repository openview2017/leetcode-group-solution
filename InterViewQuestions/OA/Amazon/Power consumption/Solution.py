from collections import deque
class PowerConsumptions:
    def getPowerConsumptions(self, bootpower, processpower, powerlimit):
        # Max(bootPower[i...j]) + Sum(processPower[i....j]) * length of subArray.
        cur_sum = 0
        left = right = 0
        monostack = deque([])
        while right < len(bootpower):
            # put right into monostack
            pass
        return