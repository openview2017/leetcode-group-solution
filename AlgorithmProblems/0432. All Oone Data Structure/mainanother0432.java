public class mainanother0432 {
    class AllOne {

        DoubleLinkedList list;
        Map<String, Node> map;
        
        public AllOne() {
            list = new DoubleLinkedList();
            map = new HashMap<>();
        }
        
        
        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            Node node = map.get(key);
            if (node == null) {
                Node newInserted = list.insertValue(new Node(1, key), list.head.next, "right");
                map.put(key, newInserted);
                return;
            }
            Node inserted = list.insertValue(new Node(node.val+1, key), node.next, "right");
            map.put(key, inserted);
            list.removeValue(key, node);
        }
        
        
        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            Node node = map.get(key);
            if (node == null) {
                System.out.println("Can not remove from null!");
                return;
            }
            Node inserted = list.insertValue(new Node(node.val-1, key), node.prev, "left");
            map.remove(key);
            if (inserted != null){
                map.put(key, inserted);
            }
            list.removeValue(key, node);
        }
        
        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            
            return map.size() == 0 ? "" : list.getMax();
        }
        
        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            return map.size() == 0 ? "" : list.getMin();
        }
    }
    
    
    class DoubleLinkedList{
        
        Node head, tail;
        public DoubleLinkedList(){
            head = new Node(0);
            tail = new Node(Integer.MAX_VALUE);
            head.next = tail;
            tail.prev = head;
           
        }
        // 1 -> 2 -> 4
        // h  aaa
        // insert value to the neighbor of current node
        public Node insertValue(Node toInsert, Node target, String insertLocation){
            if (toInsert.val <= 0){
                return null;
            }
            if (toInsert.val == target.val){
                for(String word : toInsert.set){
                    target.set.add(word);
                }
                return target;
            }
            if (insertLocation == "left"){
                insert(target, target.next, toInsert);
                return toInsert;
            }
            else {
                insert(target.prev, target, toInsert);
                return toInsert;
            }
        }
        
        public void insert(Node left, Node right, Node cur){
            left.next = cur;
            cur.next = right;
            cur.prev = left;
            right.prev = cur;
        }
        
        public void removeValue(String word, Node cur) {
            cur.set.remove(word);
            if (cur.set.isEmpty()){
                remove(cur);
            }
        }
        
        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
        public String getMax(){
            Set<String> set = tail.prev.set;
            return set.iterator().next();// 随机
        }
        
        public String getMin(){
            Set<String> set = head.next.set;
            return set.iterator().next();
        }
    }
    
    
    class Node{
        int val;// frequency
        Set<String> set = new HashSet(); // strore string key with the same frequency
        Node next, prev;
        
        public Node(int val){
            this.val = val;// initilize
        }
        
        public Node(int val, String word){
            this.val = val;
            set.add(word);
        }
        
        public String toString(){
            return val+"";
        }
    }
    
}
