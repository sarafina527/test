import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int[] h = new int[n];
            int sum = 0;
            for(int i=0;i<n;i++){
                h[i] = input.nextInt();
                sum+=h[i];
            }
            int max = sum/2+1;
            if(max<0||max>500001) max = 500001;
            boolean[][][] dp = new boolean[max][max][n+1];
            dp[0][0][0] = true;
            for(int i=0;i<n;i++){
                for(int left=0;left<max;left++){
                    for(int right=0;right<max;right++){
                        if(left>=h[i]&&dp[left-h[i]][right][i]||right>=h[i]&&dp[left][right-h[i]][i]||dp[left][right][i])
                            dp[left][right][i+1] = true;
                    }
                        
                }
            }
            int ans = -1;
            boolean found = false;
            for(int hh=1;hh<max;hh++){
                for(int i=1;i<=n;i++)
                    if(dp[hh][hh][i]){
                        ans = hh;
                    }
            }
            System.out.println(ans);
        }
    }
       
}