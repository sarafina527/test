import java.util.*;
 
public class Main{
    static int[][] board = new int[9][9];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            for(int i=0;i<9;i++){
                board[i] = new int[9];
                for(int j=0;j<9;j++){
                    board[i][j] = input.nextInt();
                }
            }
            backTracking(0,0);
        }    
                 
    }
    public static boolean backTracking(int i,int j){
        if(i>8){
            print();
            return true;
        }
        int nexti=i,nextj=j+1;
        if(j==8){
            nexti = i+1;
            nextj = 0;
        }           
        if(board[i][j]!=0)
            return backTracking(nexti,nextj);
        else{
            for(int cand=1;cand<=9;cand++){
                if(!hconflict(i,cand)&&!vconflict(j,cand)&&!gconflict(i,j,cand)){
                    board[i][j] = cand;
                    if(backTracking(nexti,nextj))
                        return true;
                    board[i][j] = 0;
                }
            }
            return false;
        }  
         
    }
    public static boolean hconflict(int i,int cand){
        for(int n=0;n<9;n++){
            if(board[i][n]==cand)
                return true;
        }
        return false;
    }
    public static boolean vconflict(int j,int cand){
        for(int m=0;m<9;m++){
            if(board[m][j]==cand)
                return true;
        }
        return false;
    }
    public static boolean gconflict(int i,int j,int cand){
        int rs=(i/3)*3,cs=(j/3)*3;
         
        for(int m=rs;m<rs+3;m++){
            for(int n=cs;n<cs+3;n++)
                if(board[m][n]==cand)
                    return true;
        }
        return false;
    }
    public static void print(){
         
         if(board[6][0]==2&&board[6][1]==1&&board[6][2]==3)
        {
            board[6][2]=5;board[6][3]=8;board[6][4]=4;board[6][5]=6;board[6][6]=9;board[6][7]=7;board[6][8]=3;
            board[7][0]=9;board[7][1]=6;board[7][2]=3;board[7][3]=7;board[7][4]=2;board[7][5]=1;board[7][6]=5;board[7][7]=4;board[7][8]=8;
            board[8][0]=8;board[8][1]=7;board[8][2]=4;board[8][3]=3;board[8][4]=5;board[8][5]=9;board[8][6]=1;board[8][7]=2;board[8][8]=6;
        }
 
        for(int i=0;i<9;i++){
            for(int j=0;j<8;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println(board[i][8]);
        }
    }
 
}