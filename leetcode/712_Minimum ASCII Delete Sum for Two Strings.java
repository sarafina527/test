class Solution {
    public int minimumDeleteSum(String s1, String s2) {
    	int m = s1.length(),n=s2.length();
        int[][] sum = new int[m+1][n+1];
        sum[m][n] = 0;
        for(int j=n-1;j>=0;j--){
        	sum[m][j] = sum[m][j+1]+(int)(s2.charAt(j));
        }
        for(int i=m-1;i>=0;i--){
        	sum[i][n] = sum[i+1][n]+(int)(s1.charAt(i));
        }
        for(int i=m-1;i>=0;i--){
        	for(int j=n-1;j>=0;j--){
        		if(s1.charAt(i)==s2.charAt(j))
        			sum[i][j] = sum[i+1][j+1];
        		else{
        			sum[i][j] = Math.min((int)(s1.charAt(i))+sum[i+1][j],(int)(s2.charAt(j))+sum[i][j+1]);
        		}
        	}
        }
        return sum[0][0];
    }
}