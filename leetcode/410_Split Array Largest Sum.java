public class Solution {
    public int splitArray(int[] nums, int m) {
    	int n = nums.length;
    	int[][][] d = new int[n][n][m+1];
    	boolean[][][] hascom = new boolean[n][n][m+1];
    	if(n<m) return 0;
    	dp(0,n-1,m,nums,d,hascom);
    	return d[0][n-1][m];
    }
    public void dp(int s,int e,int m,int[] nums,int[][][] d,boolean[][][] hascom){
    	if(hascom[s][e][m]) return;
    	if(e-s+1==m){
    		d[s][e][m] = max(nums,s,e);
    		hascom[s][e][m] = true;
    		return;
    	}
    	if(m==1){
    		d[s][e][m] = sum(nums,s,e);
    		hascom[s][e][m] = true;
    		return;
    	}
    	int firstsum = 0;
    	d[s][e][m] = Integer.MAX_VALUE;
    	for(int firstlen=1;e+1-firstlen>=m-1&&s+firstlen<=e;firstlen++){
    		firstsum+=nums[s+firstlen-1];
    		dp(s+firstlen,e,m-1,nums,d,hascom);
    		int curmax = Math.max(firstsum,d[s+firstlen][e][m-1]);
    		d[s][e][m] = Math.min(d[s][e][m],curmax);
    	}
    	hascom[s][e][m] = true;
    }
    public int max(int[] nums,int s,int e){
    	int ans = nums[s];
    	for(int i=s+1;i<=e;i++){
    		if(ans<nums[i]) ans=nums[i];
    	}
    	return ans;
    }
    public int sum(int[] nums,int s,int e){
        int ans = 0;
        for(int i=s;i<=e;i++)
            ans+=nums[i];
        return ans;
    }
}