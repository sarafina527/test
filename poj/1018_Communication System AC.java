import java.util.*;
public class Main {   
    static class device{
        int bw;
        int pr;
        public device(int b,int p){
            bw = b;pr=p;
        }
    } 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        while(cases-->0){
            int n = input.nextInt();
            device[][] arr = new device[n][];
            Set<Integer> bwset = new TreeSet<Integer>();
            for(int i=0;i<n;i++){                
                int m = input.nextInt();
                arr[i] = new device[m];
                for(int j=0;j<m;j++){
                    arr[i][j] = new device(input.nextInt(),input.nextInt());
                    bwset.add(arr[i][j].bw);
                }
            }
            int m = bwset.size();
            int[] bws = new int[m];int i=0;
            for(int b:bwset){
                bws[i++] = b;
            }
            int[][] dp = new int[n+1][m+1];
            for(i=1;i<=n;i++){
                for(int j=0;j<=m;j++)
                    dp[i][j] = 1<<30;
            }
            for(i=0;i<n;i++){
                for(int j=0;j<arr[i].length;j++){
                    int curb = arr[i][j].bw;
                    int curp = arr[i][j].pr;
                    int index = m-1;
                    int tmp = 1<<30;
                    while(index>=0&&bws[index]>=curb){
                        tmp = Math.min(tmp,dp[i][index--]+curp);
                    }
                    if(index>=0&&bws[index]==curb)
                        dp[i+1][index] = Math.min(tmp,dp[i+1][index+1]);
                    else
                        dp[i+1][index+1] = Math.min(tmp,dp[i+1][index+1]);
                    while(index>=0){
                        dp[i+1][index] = Math.min(dp[i+1][index],dp[i][index]+curp);
                        index--;
                    }
                }
            }
            double ans = 0.0;
            for(i=0;i<m;i++){
                double tmp = bws[i]/(1.0*dp[n][i]);
                ans = Math.max(ans,tmp);
            }
            System.out.format("%.3f%n",ans);
        }
    }
       
}