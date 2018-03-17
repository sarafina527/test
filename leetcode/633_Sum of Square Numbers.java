public class Solution {
    public boolean judgeSquareSum(int c) {
    	
        for(int i=0;i*i<=c;i++){
        	int left = c-i*i;
        	int root = (int)Math.sqrt(left); 
        	if(root*root==left) return true;
        }
        return false;
    }
}