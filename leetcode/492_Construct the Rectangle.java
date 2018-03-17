public class Solution {
    public int[] constructRectangle(int area) {
    	int[] ans = new int[2];
        int root = (int)Math.sqrt(area);
        int i=root;
        for(;i>1;i--){
        	if(area%i==0)
        		break;
        }
        if(i==1){
        	ans[0] = area;
        	ans[1] = 1;
        }else{
        	ans[0] = area/i;
        	ans[1] = i;
        }
        return ans;
    }
}