import java.util.*;
public class Main { 
	static int INF = 1000001;   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int[] a = new int[n];
            int[] dp = new int[n][2];
            for(int i=0;i<n;i++){
            	a[i] = input.nextInt();
            }
            for(int i=0;i<n;i++){
            	dp[i][0] = INF;
            }
            dp[0][0] = 0;dp[1][1] = 1;
            dp[1][0] = Math.abs(a[1]-a[0]);
            for(int i=2;i<n;i++){
            	dp[i][0] = Math.min(dp[i-1][0]+Math.abs(a[i]-a[i-1],dp[i-1][1]);
            	dp[i][1] = Math.min(dp[i-1][1]+Math.abs(a[i]-a[i-1],dp[i-1][0]);
            }
            int ans = Math.min(dp[n-1][0],dp[n-1][1]);            
            System.out.println(ans);
        }
    }
       
}