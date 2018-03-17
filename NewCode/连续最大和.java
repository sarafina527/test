import java.util.*;
import java.math.BigInteger;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            nums[i] = input.nextInt(); 
        }
        dp[0] = nums[0];
        for(int i=1;i<n;i++){
            dp[i] = nums[i];
            dp[i] = Math.max(dp[i-1]+nums[i],dp[i]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,dp[i]);
        }     
        System.out.println(ans);
    }
}
