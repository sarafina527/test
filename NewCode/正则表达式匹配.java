public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        int[][] dp = new int[str.length+1][pattern.length+1];
        return matchRecur(s,0,p,0,dp);
    }
    public boolean matchRecur(char[] s,int i,char[] p,int j,int[][] dp){
    	if(dp[i][j]!=0) return dp[i][j]>0;
    	if(i==s.length&&j==p.length){
    		dp[i][j] = 1;
    		return true;
    	}
    	if(j==p.length){
    		dp[i][j] = -1;return false;
    	}
    	boolean ans;
    	if(j+1<p.length&&p[j+1]=='*'){    		
    		if(i<s.length&&(p[j]==s[i]||p[j]=='.'))
    			ans = match(s,i+1,p,j+2,dp)||match(s,i,p,j+2,dp)||match(s,i+1,p,j,dp);
    		else
    			ans = match(s,i,p,j+2,dp);	    	
    	}else{
    		if(i<s.length&&(p[j]==s[i]||p[j]=='.'))
    			ans = match(s,i+1,p,j+1,dp);
    		else
    			ans = false;
    	}
    	if(ans) dp[i][j] = 1;
    	else dp[i][j] = -1;
    	return ans;
    }
}