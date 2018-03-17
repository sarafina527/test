import java.util.*;
public class Main {  
    static int m = 1000;
    static int INF = 1000*1000;
    static int[] dx ={1,0};
    static int[] dy = {0,1};
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);    
        while(input.hasNext()){
            int n = input.nextInt();
            boolean[][] board = new boolean[m+1][m+1];
            int[] x= new int[n];int[] y=new int[n];
            for(int i=0;i<n;i++){
                x[i] = input.nextInt();
            }
            for(int i=0;i<n;i++){
                y[i] = input.nextInt();
                board[x[i]][y[i]] = true;
            }
            int ans = INF;
            for(int i=1;i<=m;i++){
                for(int j=1;j<=m;j++){
                    if(board[i][j]){
                        int d = i-1+j-1;
                        if(d<ans) ans = d;
                    }
                }
            }          
        }
    }
    // public static void bfs(int x,int y,int sofar,board,int[] min){
    //     if(sofar>min[0]) return;
    //     if(board[x][y]){
    //         if(sofar<min[0]) min[0] = sofar;
    //         return;
    //     }
    //     bfs(x+1,y,sofar+1,board,min);
    //     bfs(x,y+1,sofar+1,board,min);
    // }
}