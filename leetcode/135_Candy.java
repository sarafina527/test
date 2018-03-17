public class Solution {
    public int candy(int[] ratings) {
    	if(ratings.length==0) return 0;
    	int ans = 1;
    	LinkedList<Integer>[] graph = (LinkedList<Integer>[])new LinkedList[ratings.length];
    	for(int i=0;i<graph.length;i++){
    		graph[i] = new LinkedList<Integer>();
    	}
    	int[] counts = new int[ratings.length];
    	for(int i=0;i<ratings.length-1;i++){
    		if((i>0&&ratings[i]>ratings[i-1]||(i<ratings.length-1&&ratings[i]>ratings[i+1])){
    			if(i>0)
    				graph[i-1].add(i);
    			if(i<ratings.length-1)
    				graph[i+1].add(i);
    		}
    	}
    	BFS(graph,counts);
    	for(int i=0;i<counts.length;i++){
    		ans+=counts[i];
    	}   	

    	return ans;        
    }
    public void BFS(LinkedList<Integer>[] graph,int[] counts){
    	Set<Integer> Visited = new HashSet<Integer>();
    	while(Visited.size()<graph.length){
    		for(int i=0;i<graph.length;i++){
    			if(Visited.contains(i))
    				continue;
    			LinkedList<Integer> que = LinkedList<Integer>();
    			que.add(i);
    			counts[i] = 1;
    			Visited.add(i);
    			while(!que.IsEmpty()){
    				int cur = que.poll();
    				for(int adj:graph[cur]){
    					que.add(adj);
    					counts[adj] = counts[cur]+1;
    					Visited.add(adj);
    				}
    			}
    		}
    	}
    }
}