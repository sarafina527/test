import java.util.*;

public class Main{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int[] nums = new int[n];
            int sum = 0;
            for(int i=0;i<n;i++){
                nums[i] = input.nextInt()>>10;
                sum+=nums[i];
            }
            int[] dp = new int[sum/2+1];
            for(int i=0;i<nums.length;i++){
                for(int j=sum/2;j>=nums[i];j--){
                    dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
                }
            }
            System.out.println(Math.max(dp[sum/2],sum-dp[sum/2])<<10);
        }
		  		
	}
	
}