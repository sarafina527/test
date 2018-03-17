import java.util.*;
public class Main {
    static int m = 1000000000; 
    static int MaxN = 1000000;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] dp = new int[MaxN+1];//j fen cheng pre i e 
        int log = (int)(Math.log((double)MaxN)/Math.log((double)2));
        for(int j=0;j<=MaxN;j++)
                dp[j] = 1;
        for(int i=1;i<=log;i++){
            int part = 1<<i;
            for(int j=part;j<=MaxN;j++){
                dp[j] = (dp[j-part]+dp[j])%m;
            }
        }
        while(input.hasNext()){
            int n = input.nextInt();
            System.out.println(dp[n]);
        }
    }  
}