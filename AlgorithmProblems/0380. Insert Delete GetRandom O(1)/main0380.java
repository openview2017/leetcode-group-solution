public class main0380 {
    
}

class RandomizedSet {
    Map<Integer, Integer> map; // val, index
    List<Integer> vals;
    Random rand;
    
    public RandomizedSet() {
        rand = new Random();
        vals = new ArrayList<>();
        map = new HashMap<Integer, Integer>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, vals.size());
        vals.add(val); // !!! don't forget
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }        
        int lastElementVal = vals.get(vals.size() - 1);
        int deleteIndex = map.get(val);
        vals.set(deleteIndex, lastElementVal);
        vals.remove(vals.size() - 1);
        map.put(lastElementVal, deleteIndex);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int index = rand.nextInt(vals.size());
        return vals.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */