public class AllOne {
    private map<String,Integer> onemap = new HashMap<String,Integer>();
    private LinkedList<String> max = new LinkedList<String>();
    private LinkedList<String> min = new LinkedList<String>();

    /** Initialize your data structure here. */
    public AllOne() {
        
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int val = 1;
        if(onemap.containsKey(key)){
            val = onemap.get(key);
            val++;
            onemap.remove(key);
            onemap.put(key,val);
        }else{
            onemap.put(key,val);
        }
        if(stack.empty())

    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(onemap.containsKey(key)){
            int val = onemap.get(key);
            val--;
            onemap.remove(key);
            if(val>0)
                onemap.put(key,val);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */