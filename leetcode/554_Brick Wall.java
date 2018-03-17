class Solution {
    public int leastBricks(List<List<Integer>> wall) {
    	int n = wall.size();
    	int ans = n;
    	Map<Integer,Integer> idcnt = new HashMap<Integer,Integer>();
        for(List<Integer> row:wall){
        	int sum = 0;
        	int i=0;
        	for(int e:row){
        		i++;
        		if(i==row.size()) break;
        		sum+=e;
        		if(idcnt.containsKey(sum))
        			idcnt.put(sum,idcnt.get(sum)+1);
        		else
        			idcnt.put(sum,1);
        	}
        }
        for(Map.Entry<Integer,Integer> e:idcnt.entrySet()){
        	if(n-e.getValue()<ans)
        		ans = n-e.getValue();
        }
        return ans;
    }
}