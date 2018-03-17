import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                nums[i] = input.nextInt();
            }
            int dp[] = new int[n];            
            dp[0] = nums[0];
            int ans = dp[0];
            for(int i=1;i<n;i++){
                dp[i] = nums[i];
                dp[i] = Math.max(dp[i-1]+nums[i],dp[i]);
                ans = Math.max(dp[i],ans);
            }
            System.out.println(ans);
        }
    }
       
}