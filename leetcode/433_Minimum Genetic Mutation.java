class Solution {
    public int minMutation(String start, String end, String[] bank) {
        LinkedList<String> que = new LinkedList<String>();
        Map<String,Integer> htb = new HashMap<String,Integer>();
        boolean[] visited = new boolean[bank.length];
        que.offer(start);
        htb.put(start,0);
        while(!que.isEmpty()){
        	String cur = que.poll();
        	if(cur.equals(end))
        		return htb.get(cur);
        	for(int i=0;i<bank.length;i++){
        		if(!visited[i]&&canMu(cur,bank[i])){
        			htb.put(bank[i],htb.get(cur)+1);
        			que.offer(bank[i]);
        			visited[i] = true;
        		}
        	}
        }
        return -1;
    }
    public boolean canMu(String s,String e){
    	if(s.length()!=e.length()) return false;
    	int cnt = 0;
    	for(int i=0;i<s.length();i++){
    		if(s.charAt(i)!=e.charAt(i))
    			cnt++;
    	}
    	if(cnt==1) return true;
    	else return false;
    }
}