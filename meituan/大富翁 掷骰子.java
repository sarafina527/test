import java.util.*;
public class Main {    
    static int[] dp = new int[7];
    static{
        dp[0] = 1;
        for(int i=1;i<=6;i++){
            for(int j=i-1;j>=0;j--)
                dp[i] += dp[j];
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            System.out.println(dp[n]);
        }
    }
       
}