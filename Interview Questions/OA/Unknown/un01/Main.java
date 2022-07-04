import java.util.*;

interface Iterable {
    public boolean hasNext();
    public Relation next();
}

class SList implements Iterable {
    int curidx;
    List<Relation> lists;
    public SList(List<Relation> lists) {
        this.lists = lists;
        this.curidx = 0;
    }
    public boolean hasNext() {
        return curidx < lists.size();
    }
    public Relation next() {
        return lists.get(this.curidx++);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Relation> rs = new ArrayList<>();
        rs.add(new Relation("ab", "cd"));        
        rs.add(new Relation("ab", "gh"));
        rs.add(new Relation("cd", "ef"));
        // build tree, find root
        Iterable irs = new SList(rs);
        Map<String, List<String>> childmap = new HashMap<>();
        String root = buildtree(irs, childmap);
        //
        printtree(root, 0, childmap);
    }
    
    static String buildtree(Iterable rs, Map<String, List<String>> childmap) {
        Set<String> roots = new HashSet<>();
        Set<String> nonroots = new HashSet<>();
        while (rs.hasNext()) {
            Relation cur = rs.next();
            childmap.putIfAbsent(cur.parent, new ArrayList<String>());
            childmap.get(cur.parent).add(cur.child);
            roots.add(cur.parent);            
            nonroots.add(cur.child);
        }
        for (String nr : nonroots) {
            roots.remove(nr);
        }
        return (String)roots.toArray()[0];        
    }
    
    static void printtree(String root, int level, Map<String, List<String>> childmap) {
        StringBuilder cursb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            cursb.append("  ");
        }
        cursb.append(root);
        System.out.println(cursb.toString());
        if (!childmap.containsKey(root)) {
            return;
        }
        for (String child : childmap.get(root)) {
            printtree(child, level+1, childmap);
        }
    }
}

class Relation {
    String parent;
    String child;
    public Relation(String parent, String child) {
        this.parent = parent;
        this.child = child;
    }
}
