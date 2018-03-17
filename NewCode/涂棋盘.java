import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            char[][] board = new char[n][];
            for(int i=0;i<n;i++){
                String tmp = input.next();
                board[i] = tmp.toCharArray();
            }
            int maxlen = 0;
            for(int c=0;c<n;c++){
                int i=0;
                for(int j=i+1;j<=n;j++){
                    if(j==n||board[j][c]!=board[i][c]){
                        int tmp = j-i;
                        if(tmp>maxlen) maxlen = tmp;
                        i=j;
                    }
                }
            }
            System.out.println(maxlen);            
        }
    }    
}