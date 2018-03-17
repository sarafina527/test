public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] adjList = (List<Integer>[]) new List[n];
        for(int i=0;i<n;i++){
        	adjList[i] = new LinkedList<Integer>();
        }
        for(int ei=0;ei<edges.length;ei++){//construct graph
        	int u = edges[ei][0];
        	int v = edges[ei][1];
        	adjList[u].add(v);
        	adjList[v].add(u);
        }
        boolean visited[] = new boolean[n];
        int[] d = new int[n];
        List<Integer> ans = new LinkedList<Integer>();
        int[] minH = new int[1];
        minH[0] = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
        	int preh = minH[0];
        	if(BFS(i,adjList,minH,visited,d)){
        		if(minH[0]<preh){
        			ans.clear();
        		}
        		ans.add(i);
        	}
        		
        }
        return ans;
    }
    public boolean BFS(int s,List<Integer>[] adjList,int[] minH,boolean[] visited,int[] d){
    	Arrays.fill(visited,false);
    	LinkedList<Integer> que = new LinkedList<Integer>();
    	que.offer(s);
    	d[s] = 0;
    	visited[s] = true;
    	int h = 0;
    	while(!que.isEmpty()){
    		int cur = que.poll();
    		for(int a:adjList[cur]){
    			if(!visited[a]){
    				que.offer(a);
    				d[a] = d[cur]+1;
    				visited[a] = true;
    				if(h<d[a]) h = d[a];
    				if(h>minH[0]) return false;
    			}
    		}
    	}
    	minH[0] = h;
    	return true;
    }
}