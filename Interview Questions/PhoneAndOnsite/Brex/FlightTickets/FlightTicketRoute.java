package FlightTickets;

import java.util.*;

/**
 * Created by yingli on 5/25/22.
 */
/*
* depart time
* arrive time
* location
**
*
*https://leetcode.com/problems/reconstruct-itinerary/
*
* */
public class FlightTicketRoute {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> path = new LinkedList<>();
        for (List<String> ticket : tickets) {
            String depart = ticket.get(0);
            String arrival = ticket.get(1);
            map.putIfAbsent(depart, new PriorityQueue<>());
            map.get(depart).offer(arrival);
        }

        dfs("JFK", map, path);

        return path;
    }

    private void dfs(String depart, Map<String, PriorityQueue<String>> map, List<String> path) {
        PriorityQueue<String> arrivals = map.get(depart);
        while (arrivals != null && !arrivals.isEmpty()) {
            String arrival = arrivals.poll();
            dfs(arrival, map, path);
        }
        path.add(0, depart);

    }

}
