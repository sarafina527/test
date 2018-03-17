import java.util.*;
public class HasCircle{
	static class Node {
	    private Node adjacent[];
	    public int adjacentCount;
	    public String vertex;
	    //public boolean visited = false;
	    public Node(String vertex, int adjacentLength) {
	        this.vertex = vertex;                
	        adjacentCount = 0;        
	        adjacent = new Node[adjacentLength];
	    }
	    
	    public void addAdjacent(Node x) {
	        if (adjacentCount < 30) {
	            this.adjacent[adjacentCount] = x;
	            adjacentCount++;
	        } else {
	            System.out.print("No more adjacent can be added");
	        }
	    }
	    public Node[] getAdjacent() {
	        return adjacent;
	    }
	    public String getVertex() {
	        return vertex;
	    }
	}

	public static void main(String[] args) {
		Map<String,Node> vertices = new HashMap<String,Node>();
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.next());
		for(int i=0;i<n;i++){
			String hname = input.next();
			String tname = input.next();
			//System.out.println(hname+tname);
			Node head,tail;
			if(vertices.containsKey(hname))
				head = vertices.get(hname);
			else{
				head = new Node(hname,n);
				vertices.put(hname,head);
			}
			if(vertices.containsKey(tname))
				tail = vertices.get(tname);
			else{
				tail = new Node(tname,n);
				vertices.put(tname,tail);
			}
			head.addAdjacent(tail);
		}
		String s = input.next();
		String t = input.next();
		//System.out.println(s+t);
		Node vt = vertices.get(t);
		Node st = vertices.get(s);
		Set<Node> visited = new HashSet<Node>();
		boolean flag1 = DFS(st,vt,visited);
		visited.clear();
		boolean flag2 = DFS(vt,st,visited);
		if(flag1&&flag2)
			System.out.println("T");
		else
			System.out.println("F");


	}
	public static boolean DFS(Node start,Node end,Set<Node> visited){
		for(int i=0;i<start.adjacentCount;i++){
			Node v = start.getAdjacent()[i];			
			if(!visited.contains(v)){
				//System.out.println(start.vertex+"- "+v.vertex);
				visited.add(v);
				if(v.vertex.equals(end.vertex))
					return true;
				if(DFS(v,end,visited))
					return true;
			}			
		}
		return false;
	}


}