public class Solution {
    public int JumpFloorII(int target) {
    	if(target<=0) return 1;
        int[] d = new int[target+1];
        d[0] = 1;d[1] = 1;
        for(int i=2;i<=target;i++){
        	for(int j=0;j<i;j++)
        		d[i]+=d[j];
        }
        return d[target];
    }
}