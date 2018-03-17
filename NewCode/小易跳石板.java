
import java.util.*;

public class Main{
    static int INF = (1<<30);
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int m = input.nextInt();
            int dp[m+1];
            for(int i=0;i<=m;i++) dp[i]=INF;
            d[n] = 0;
            for(int i=n+1;i<=m;i++){
                for(int j=2;j<i-j&&i-j>=n;j++){//j jump bushu
                    if((i-j)%j==0){// can junp
                        d[i] = Math.min(dp[i],dp[i-j]+1);
                    }                    
                }
            }
            if(dp[m]>=INF) System.out.println(-1);
            else
                System.out.println(dp[m]);
        }
    }
    
}