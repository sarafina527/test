public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
        	int min = Integer.MAX_VALUE;
        	for(int j=0;j<coins.length;j++){
                if(i-coins[j]<0) break;
        		int precnt = dp[i-coins[j]];
        		if(precnt>=0&&precnt<min)
        			min = precnt;
        	}
            if(min!=Integer.MAX_VALUE)
        	    dp[i] = 1+min;
            else
                dp[i] = -1;
        }
        //System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
}