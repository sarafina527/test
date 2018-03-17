import java.util.*;
public class Main {  
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);    
        int m = input.nextInt();
        int[] h = new int[m];
        for(int i=0;i<m;i++){
            h[i] = input.nextInt();
        }
        int[] dp = new int[m];
        System.out.println(play(0,dp,h)>0);
    }
    public static int play(int i,int dp[],int[] h){
        if(i>=h.length) return 0;
        if(dp[i]!=0) return dp[i];
        int ans = h[i]-play(i+1,dp,h);
        if(i+1<h.length)
            ans = Math.max(ans,h[i]+h[i+1]-play(i+2,dp,h));
        return dp[i] = ans;
    }    
}