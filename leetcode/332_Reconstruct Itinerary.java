class Solution {
    public List<String> findItinerary(String[][] tickets) {
    	int n = tickets.length+1;
        Map<String,Set<String>> gh = new HashMap<String,Set<String>>();
        for(String[] t:tickets){
        	if(gh.containsKey(t[0])){
        		gh.get(t[0]).add(t[1]);
        	}else{
        		Set<String> adj = new TreeSet<String>();
        		adj.add(t[1]);
        		gh.put(t[0],adj);
        	}
        }
        LinkedList<String> ans = new LinkedList<String>();
        ans.add("JFK");
        DFS(ans,n,gh);
        return ans;
    }
    public boolean DFS(LinkedList<String> ans,int n,Map<String,Set<String>> gh){
    	if(ans.size()==n) return true;
    	String cur = ans.getLast();
    	if(gh.containsKey(cur)){
    		Set<String> can = gh.get(cur);
	    	for(String adj:can){
	    		ans.add(adj);
	    		if(DFS(ans,n,gh))
	    			return true;
	    		ans.removeLast();
	    	}
    	}
    	return false;
    }
}