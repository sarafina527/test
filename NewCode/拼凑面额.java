import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int a[] = {1,5,10,20,50,100};
            long dp[] = new long[n+1];
            dp[0] = 1L;
            for(int i=0;i<6;i++){
                for(int j=0;j<=n;j++)
                    if(j>=a[i])
                        dp[j] +=dp[j-a[i]];
                //System.out.println(Arrays.toString(dp));
            }
            System.out.println(dp[n]);
        }
    }
    
}