class Solution {
    public int findLHS(int[] nums) {
        Map<Long,Integer> hashtable = new TreeMap<Long,Integer>();
        int ans = 0;
        for(int e:nums){
        	long cur = (long)e;        	
        	if(hashtable.containsKey(cur))
        		hashtable.put(cur,hashtable.get(cur)+1);
        	else
        		hashtable.put(cur,1);        	
        }
        long pre = Long.MAX_VALUE;
        for(Map.Entry<Long,Integer> e:hashtable.entrySet()){
        	if(pre!=Long.MAX_VALUE){
        		if(e.getKey()-pre==1){
        			int cnt = e.getValue()+hashtable.get(pre);
        			if(cnt>ans) ans=cnt;
        		}
        	}
        	pre = e.getKey();
        }
        return ans;
    }
}