import java.util.*;
public class Main {  
    static int[] dx = {-1,0,1,1};
    static int[] dy={1,1,1,0}; 
    static int m = 19;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        int n = input.nextInt();
        for(int c=0;c<n;c++){
            int[][] board = new int[m][m];
            for(int i=0;i<m;i++){//init
                for(int j=0;j<m;j++)
                    board[i][j] = input.nextInt();
            }
            boolean[][][] visited = new boolean[m][m][4];
            boolean blackwin = false,whitewin = false;
            int si=-1,sj=-1;
            outer:
            for(int i=0;i<m;i++){
                for(int j=0;j<m;j++){
                    if(board[i][j]!=0&&dfs(i,j,visited,board,board[i][j])){
                        if(board[i][j]==1)
                            blackwin = true;
                        else
                            whitewin = true;
                        si = i+1;sj=j+1;
                        break outer;
                    }
                }
            }
            
            if(blackwin||whitewin){
                if(blackwin)
                    System.out.println(1);
                else
                    System.out.println(2);
                System.out.println(si+" "+sj);
            }else
                System.out.println(0);
        }        
    }
    public static boolean dfs(int i,int j,boolean[][][] visited,int[][] board,int v){
        for(int k=0;k<4;k++){//4 dir
            if(!visited[i][j][k]){
                int d = 1;
                int adi = i+dx[k];int adj = j+dy[k];
                while(adi>=0&&adi<m&&adj>=0&&adj<m&&board[adi][adj]==v){
                    visited[adi][adj][k] = true;
                    adi += dx[k];
                    adj += dy[k];
                    d++;
                    if(d>=5)
                        return true;
                }
            }
        }
        return false;
    }
}