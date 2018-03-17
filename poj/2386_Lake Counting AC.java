import java.util.*;
public class Main {  
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int m = input.nextInt();
            int n = input.nextInt();
            char[][] board = new char[m][];
            for(int i=0;i<m;i++){
                board[i] = input.next().toCharArray();
            }
            int ans = 0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++)
                    if(board[i][j]=='W'){
                        dfs(i,j,board);
                        ans++;
                    }
            }
            System.out.println(ans);            
        }      
    }
    public static void dfs(int x,int y,char[][] board){
        board[x][y] = '.';
        int m = board.length,n=board[0].length;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int nx=i+x,ny=j+y;
                if(nx>=0&&nx<m&&ny>=0&&ny<n&&board[nx][ny]=='W')
                    dfs(nx,ny,board);
            }
            
        }

    }
   
}