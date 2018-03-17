import java.util.*;
public class Main {  
    static int[] dx = {-1,0,1,1};
    static int[] dy={1,1,1,0}; 
    static int m = 20;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            char[][] board = new char[m][m];
            for(int i=0;i<m;i++){//init
                board[i] = input.next().toCharArray();
            }
            boolean[][][] visited = new boolean[m][m][4];
            boolean win = false;
            outer:
            for(int i=0;i<m;i++){
                for(int j=0;j<m;j++){
                    if(board[i][j]!='.'&&dfs(i,j,visited,board,board[i][j])){
                        win = true;
                        break outer;
                    }
                }
            }
            
            if(win){
                System.out.println("Yes");
            }else
                System.out.println("No");
            
        }      
    }
    public static boolean dfs(int i,int j,boolean[][][] visited,char[][] board,char v){
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