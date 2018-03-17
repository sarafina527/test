class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length(),n=p.length();
        int[][] dp = new int[m+1][n+1];
        return match(s,0,p,0,dp);
    }
    public boolean match(String s,int i,String p,int j,int[][] dp){
    	if(dp[i][j]!=0) return dp[i][j]>0;
    	if(i==s.length()&&j==p.length()){
    		dp[i][j] = 1;
    		return true;
    	}
    	if(j==p.length()){
    		dp[i][j] = -1;return false;
    	}
    	boolean ans;
    	if(j+1<p.length()&&p.charAt(j+1)=='*'){    		
    		if(i<s.length()&&(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.'))
    			ans = match(s,i+1,p,j+2,dp)||match(s,i,p,j+2,dp)||match(s,i+1,p,j,dp);
    		else
    			ans = match(s,i,p,j+2,dp);	    	
    	}else{
    		if(i<s.length()&&(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.'))
    			ans = match(s,i+1,p,j+1,dp);
    		else
    			ans = false;
    	}
    	if(ans) dp[i][j] = 1;
    	else dp[i][j] = -1;
    	return ans;
    }
}