class LRUCache{
    HashMap<Integer,Integer> cache;
    LinkedList<Integer> keys;
    int cap;
    public LRUCache(int capacity) {
        cap = capacity;
        keys = new LinkedList<Integer>();
        cache = new HashMap<Integer,Integer>();
    }

    public int get(int key) {
      if(cache.containsKey(key)){
        keys.remove(new Integer(key));
        keys.offer(key);
        return (int)cache.get(key);
      }else
        return -1;
    }

    public void put(int key, int value) {
      if(cache.containsKey(key)){
        keys.remove(new Integer(key));
      }
      keys.offer(key);
      cache.put(key,value);
      if(keys.size()>cap){
        int eldest = keys.poll();
        cache.remove(eldest);
      }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
