from heapq import heappush, heappop


class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        flights = collections.defaultdict(list)
        result = []
        for ticket in tickets:
            heappush(flights[ticket[0]], ticket[1])

        self.dfs("JFK", flights, result)
        return result[::-1]

    def dfs(self, dep, flights, res):
        arrival = flights[dep]
        while arrival:
            new_dep = heappop(arrival)
            self.dfs(new_dep, flights, res)

        res.append(dep)
