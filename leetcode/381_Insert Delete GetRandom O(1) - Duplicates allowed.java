public class RandomizedCollection {
    private Map<Integer,Integer> cnttbl;
    private Iterator<Integer> keyit; 
    private int curkey;
    private int curindex;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        cnttbl = new HashMap<Integer,Integer>();
        keyit = cnttbl.keySet().iterator();
        curindex=0;
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(cnttbl.containsKey(val))
            cnttbl.put(val,cnttbl.get(val)+1);
        else
            cnttbl.put(val,1);
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(cnttbl.contained(val)&&cnttbl.get(val)>0)
            cnttbl.put(val.cnttbl.get(val)-1);
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        if(!keyit.hasNext())
            keyit = cnttbl.keySet().iterator();
        if(curindex==0&&keyit.hasNext()){
            curkey = keyit.next();
        }
        int n = cnttbl.get(curkey);
        curindex++;
        if(curindex==n) 
            curindex = 0;
        return curkey;
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */