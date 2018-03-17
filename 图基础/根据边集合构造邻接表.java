//无权 顶点无属性
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
//有权图 顶点仅有编号 无属性
class edge{
	int to;
	int cost;
}
List<edge>[] adjList = (List<Integer>[]) new List[n];//n个顶点

//顶点有属性
class vertex{
	int id;
	int w;
	List<vertex> edges;
}
vertex[] G = new vertex[n];
for(int i=0;i<n;i++){//init vertex
	G[i] = new vertex(id,w);
}
for(int ei=0;ei<edges.length;ei++){//add edges
	int u = edges[ei][0];
	int v = edges[ei][1];
	
	G[u].edges.add(G[v]);
	G[v].edges.add(G[u]);
}