public class Solution {
    public int findIntegers(int num) {
        int[] mask = new int[30];
        int ans = 0;
        for(int i=0;i<30;i++){
        	mask[i] = 3<<i;
        }
        //System.out.println(Arrays.toString(mask));
        for(int i=0;i<=num;i++){
        	boolean noncon = true;
        	for(int j=0;j<30;j++){
        		if((mask[j]&i)==mask[j]){
                    noncon = false;
                    break;
                }        			
        	}
        	if(noncon)
        		ans++;
        }
        return ans;
    }
}
//超时