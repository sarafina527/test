import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int[] h = new int[n];
            for(int i=0;i<n;i++){
                h[i] = input.nextInt();
            }
            true[][][] dp = new int[5001][5001][n+1];
            dp[0][0][0] = true;

            for(int i=0;i<n;i++){
                for(int left=0;left<=5000++){
                    for(int right=0;right<=5000;right++)
                        if(left>=h[i]&&dp[left-h[i]][right][i]||right>=h[i]&&dp[left][right][i]||dp[left][right][i])
                            dp[left][right][i+1] = true;
                }
            }
            int ans = -1;
            Label:
            for(int hh=5000;hh>=0;hh--){
                for(int i=0;i<n;i++)
                    if(dp[hh][hh][i]){
                        ans = hh;
                        break Label;
                    }
            }
            System.out.println(ans);            
        }
    }
       
}