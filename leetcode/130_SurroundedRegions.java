//130. Surrounded Regions
//给定一个包含“X”和“O”板，捕获所有被x包围的区域。将包围区域中翻转所有的' O '到X。
//用DFS导致栈溢出，所以用BFS，并且在入队的时候就标记区域号，最大程度地减少重复访问
public class Solution {
	int regioncnt = 0;
	class Point{
		int i;
		int j;
		public Point(int pi,int pj){
			i = pi;
			j = pj;
		}
	}
    public void solve(char[][] board) {
        int m = board.length;
        if(m<=0) return;
        int n = board[0].length;
        int [][] regionlabel = new int[m][n];
        LinkedList<Boolean> change = new LinkedList<Boolean>(); //label the region should be changed
        change.addLast(false);
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(board[i][j]=='O'&&regionlabel[i][j]==0){//迭代选取每个区域的起始点
        			++regioncnt;
        			Point pi = new Point(i,j);       			
        			boolean curchange = BFS(board,regionlabel,pi,regioncnt);//BFS标记该区域标号，并返回是否被包围
        			change.addLast(curchange);
        		}
        	}
        }
        for(int i=0;i<m;i++){//change the region
        	for(int j=0;j<n;j++){
        		if(board[i][j]=='O'&&change.get(regionlabel[i][j]))
        			board[i][j]='X';
        	}
        }
    }
    public boolean BFS(char[][] board,int[][] regionlabel,Point pi,int label){
   		LinkedList<Point> que = new LinkedList<Point>();
    	que.offer(pi);
    	regionlabel[pi.i][pi.j] = label;
    	boolean curchange = true;
    	while(!que.isEmpty()){
    		Point cur = que.poll();
    		int i = cur.i,j = cur.j;
    		//set label (contain visited)
    		if(curchange&&(i==0||i==board.length-1||j==0||j==board[0].length-1)){//边缘点，不被包围
    			curchange = false;
    		}
    		//四个方向入队
    		if(i-1>=0&&board[i-1][j]=='O'&&regionlabel[i-1][j]==0){
    		    que.offer(new Point(i-1,j));
    		    regionlabel[i-1][j] = label;
    		}
		    	
			if(i+1<board.length&&board[i+1][j]=='O'&&regionlabel[i+1][j]==0){
			    que.offer(new Point(i+1,j));
			    regionlabel[i+1][j]= label;
			}
				
			if(j-1>=0&&board[i][j-1]=='O'&&regionlabel[i][j-1]==0){
			    que.offer(new Point(i,j-1));
			    regionlabel[i][j-1] = label;
			}
			    
			if(j+1<board[0].length&&board[i][j+1]=='O'&&regionlabel[i][j+1]==0){
			    que.offer(new Point(i,j+1));
			    regionlabel[i][j+1] = label;
			}
			    
    	}
		return curchange;
    }
}
