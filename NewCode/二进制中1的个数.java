public class Solution {
    public int NumberOf1(int n) {
    	int ans = 0;
    	while(n>0){
    		n = n&(n-1);
    		ans++;
    	}
    	return ans;
    }
}