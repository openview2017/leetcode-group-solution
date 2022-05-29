import java.util.TreeSet;

public class main2102 {
    public static void main(String[] args) {
        SORTracker tracker = new SORTracker(); // Initialize the tracker system.
        tracker.add("bradford", 2); // Add location with name="bradford" and score=2 to the system.
        tracker.add("branford", 3); // Add location with name="branford" and score=3 to the system.
        System.out.println(tracker.get());              // The sorted locations, from best to worst, are: branford, bradford.
                                    // Note that branford precedes bradford due to its higher score (3 > 2).
                                    // This is the 1st time get() is called, so return the best location: "branford".
        tracker.add("alps", 2);     // Add location with name="alps" and score=2 to the system.
        System.out.println(tracker.get());              // Sorted locations: branford, alps, bradford.
                                    // Note that alps precedes bradford even though they have the same score (2).
                                    // This is because "alps" is lexicographically smaller than "bradford".
                                    // Return the 2nd best location "alps", as it is the 2nd time get() is called.
        tracker.add("orland", 2);   // Add location with name="orland" and score=2 to the system.
        System.out.println(tracker.get());              // Sorted locations: branford, alps, bradford, orland.
                                    // Return "bradford", as it is the 3rd time get() is called.
        tracker.add("orlando", 3);  // Add location with name="orlando" and score=3 to the system.
        System.out.println(tracker.get());              // Sorted locations: branford, orlando, alps, bradford, orland.
                                    // Return "bradford".
        tracker.add("alpine", 2);   // Add location with name="alpine" and score=2 to the system.
        System.out.println(tracker.get());              // Sorted locations: branford, orlando, alpine, alps, bradford, orland.
                                    // Return "bradford".
        System.out.println(tracker.get());              // Sorted locations: branford, orlando, alpine, alps, bradford, orland.
                                    // Return "orland".
    }
}

class SORTracker {
    private TreeSet<Location> locations = new TreeSet<>(); 
    private Location lastReturned = new Location("", Integer.MAX_VALUE); // Last returned (or equivalent)
    
    public void add(String name, int score) {
        Location location = new Location(name, score);
        locations.add(location);
        
		// If the new location is before the last returned, we need to update the pointer
        if (location.compareTo(lastReturned) < 0) {
            lastReturned = locations.lower(lastReturned);
        }
    }
    
    public String get() {
        // Update the pointer
        lastReturned = locations.higher(lastReturned);
        
        return lastReturned.name;
    }
    
    private static class Location implements Comparable<Location> {
        private final String name;
        private final int score;
        
        public Location(String name, int score) {
            this.name = name;
            this.score = score;
        }
        
        public int compareTo(Location l) {
            // Sort by score (desc), then name (asc)
            return score != l.score ? -Integer.compare(score, l.score) : name.compareTo(l.name);
        }
    }
}
// https://leetcode.com/problems/sequentially-ordinal-rank-tracker/discuss/1623437/Java-TreeSet-%2B-pointer-(simple)