from typing import List
"""
Use stack, keep tracking of the last timestamp. Each time there is only one thread running, so we add the time slot to the result and update the last timestamp.
Time complexity: O(N)
Space complexity: O(N)
"""
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        log_split = [log.split(":") for log in logs]
        log_list = [(int(log[0]), log[1], int(log[2])) for log in log_split]
        result = [0 for i in range(n)]
        stack = []
        last_timestamp = 0
        for log in log_list:
            uid, status, timestamp = log
            if not stack:
                stack.append(log)
                last_timestamp = timestamp
            else:
                if status == "start":
                    result[stack[-1][0]] += timestamp - last_timestamp
                    stack.append(log)
                    last_timestamp = timestamp
                else:
                    result[stack[-1][0]] += timestamp + 1 - last_timestamp
                    stack.pop()
                    last_timestamp = timestamp + 1
        return result