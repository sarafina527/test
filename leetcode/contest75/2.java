class Solution {
    int N;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        N = graph.length;
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        LinkedList<Integer> p = new LinkedList<Integer>();
        path(0,graph,p,ans);
        return ans;
    }
    public void path(int cur,int[][] graph,LinkedList<Integer> p,List<List<Integer>> ans){
        p.add(cur);
        if(cur==N-1){
            ans.add(new LinkedList<Integer>(p));
        }else{
            for(int i=0;i<graph[cur].length;i++){
                path(graph[cur][i],graph,p,ans);
            }
        }
        p.removeLast();
    }
}
