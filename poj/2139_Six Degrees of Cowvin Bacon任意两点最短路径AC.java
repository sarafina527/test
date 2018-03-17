import java.util.*;
public class Main {
    static int max = 1<<20;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int m = input.nextInt();
            int[][] dp = new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++)
                    dp[i][j] = max;
                dp[i][i] = 0;
            }
            for(int i=0;i<m;i++){
                int mi = input.nextInt();
                int arr[] = new int[mi];
                for(int j=0;j<mi;j++){
                    arr[j] = input.nextInt();
                }
                init(dp,arr);
            }
            for(int k=1;k<=n;k++){
                for(int i=1;i<=n;i++){
                    for(int j=1;j<=n;j++){
                        dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                    }
                }
            }
            int ans = Integer.MAX_VALUE;
            //System.out.println(Arrays.deepToString(dp));
            for(int i=1;i<=n;i++){
                int tmp = 0;
                for(int j=1;j<=n;j++){
                    tmp +=dp[i][j];
                }
                if(tmp<ans){
                    ans = tmp;
                }
            }
            System.out.println(100*ans/(n-1));
        }
    }
    public static void init(int[][] dp,int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                dp[arr[i]][arr[j]] = 1;
                dp[arr[j]][arr[i]] = 1;
            }
        }
    }
}