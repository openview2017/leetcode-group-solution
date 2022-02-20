from collections import deque
from typing import List
class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        
        # Build email to name mapping
        email_map = dict()
        for account in accounts:
            for email in account[1:]:
                if email not in email_map:
                    email_map[email] = set(account[1:])
                else:
                    for e in account[1:]:
                        email_map[email].add(e)
        
        result = []
        visited = set() # visited email
        for account in accounts:
            cur_account = [account[0]]
            if account[1] in visited:
                continue
            queue = deque([account[1]])
            visited.add(account[1])
            while queue:
                cur = queue.pop()
                cur_account.append(cur)
                for neighbor in email_map[cur]:
                    if neighbor in visited:
                        continue
                    queue.append(neighbor)
                    visited.add(neighbor)
            # Emails should be in sorted order.
            cur_account = [cur_account[0]] + sorted(cur_account[1:])
            result.append(cur_account)
        return result
            
        
        