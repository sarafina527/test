public class Solution {

    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return new int[0][0];
        int m = matrix.length,n = matrix[0].length;
        int[][] d = new int[m][n];
        int[][] visited = new int[m][n];
        for(int i=0;i<m;i++){//init
            for(int j=0;j<n;j++)
                d[i][j] = m*n;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                if(matrix[i][j]==0){
                    bfs(i,j,matrix,d);
                }
        }
        return d;
    }
    class Point{
        int i;int j;
        Point(int ii,int jj){
            i=ii;j=jj;
        }
    }
    public void bfs(int i,int j,int[][] matrix,int[][] d){
        d[i][j] = 0;
        int m = matrix.length,n = matrix[0].length;
        LinkedList<Point> q = new LinkedList<Point>();
        boolean[][] visited = new boolean[m][n];
        int dr[] = {-1,0,1,0};
        int dc[] = {0,-1,0,1};
        q.offer(new Point(i,j));
        visited[i][j] = true;
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int dir=0;dir<4;dir++){
                int adji=cur.i+dr[dir],adjj=cur.j+dc[dir];
                if(adji>=0&&adji<m&&adjj>=0&&adjj<n&&!visited[adji][adjj]&&matrix[adji][adjj]!=0&&d[adji][adjj]>d[cur.i][cur.j]+1){
                    q.offer(new Point(adji,adjj));
                    d[adji][adjj] = 1+d[cur.i][cur.j];
                    visited[adji][adjj] = true;
                }
            }
        }
    }
}