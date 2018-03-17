import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String a = input.nextLine();
            String b = input.nextLine();
            int m = a.length(),n=b.length();
            int[][] dp = new int[m+1][n+1];
            int ans = 0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(a.charAt(i)==b.charAt(j)){
                        dp[i+1][j+1] = dp[i][j]+1;
                        if(ans<dp[i+1][j+1]) ans = dp[i+1][j+1];
                    }
                }
            }
            System.out.println(ans);
        }
    }
       
}