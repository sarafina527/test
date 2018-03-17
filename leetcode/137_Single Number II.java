//除了一个只出现一次，其它数都出现3次
public class Solution {
    public int singleNumber(int[] nums) {
    	int ans = 0;
    	int mask = 1;
        for(int i=0;i<32;i++){
        	int onecnt = 0;//记录所有num在每个位上是1的次数，如果是3的倍数，说明目标数此位上是1
        	mask = (mask<<1);
        	for(int j=0;j<nums.length;j++){
        		if((nums[j]&mask)!=0)
        			onecnt++;
        	}
        	if(onecnt%3!=0)
        		ans |= mask;
        }
        return ans;
    }
}