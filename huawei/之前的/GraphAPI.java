import 

class Node {
    private Node adjacent[];
    public int adjacentCount;
    private String vertex;
    public Question.State state;//访问状态（枚举类型）
    public Node(String vertex, int adjacentLength) {
        this.vertex = vertex;                
        adjacentCount = 0;        
        adjacent = new Node[adjacentLength];
    }
    
    public void addAdjacent(Node x) {//为某个结点添加邻接点
        if (adjacentCount < 30) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.print("No more adjacent can be added");
        }
    }
    public Node[] getAdjacent() {//返回邻接数组
        return adjacent;
    }
    public String getVertex() {//返回结点名
        return vertex;
    }
}

class Graph {
	private Node vertices[];//结点对象中保存了邻接数组
	public int count;
	public Graph() {
		vertices = new Node[6];
		count = 0;
    }
	
    public void addNode(Node x) {//添加节点
		if (count < 30) {
			vertices[count] = x;
			count++;
		} else {
			System.out.print("Graph full");
		}
    }
    
    public Node[] getNodes() {//返回结点数组
        return vertices;
    }
}

