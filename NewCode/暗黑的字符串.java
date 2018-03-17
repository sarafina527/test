import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            long[][][] dp = new long[n][3][3];
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++)
                    dp[1][i][j] = 1L;
            }
            for(int pos=2;pos<n;pos++){
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        if(j==i){
                            for(int p=0;p<3;p++){
                                dp[pos][i][j]+=dp[pos-1][p][i];
                            }
                        }else
                            dp[pos][i][j] = dp[pos-1][j][i]+dp[pos-1][i][i];                        
                    }
                }
            }
            long ans = 0;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    ans += dp[n-1][i][j];
                }
            }
            System.out.println(ans);
        }
    }
}