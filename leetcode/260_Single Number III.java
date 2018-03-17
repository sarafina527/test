class Solution {
    public int[] singleNumber(int[] nums) {
        int eor = 0;
        for(int elem:nums){
        	eor = eor^elem;
        }

        ArrayList<Integer> onelist = new ArrayList<Integer>();
        ArrayList<Integer> zeroList = new ArrayList<Integer>();
        int mask = 1;
        for(int i=0;i<32;i++){
        	
        	if((eor&mask)!=0){
        		break;
        	}
        	mask = mask<<1;
        }
        for(int elem:nums){
        	if((elem&mask)!=0)
        		onelist.add(elem);
        	else
        		zeroList.add(elem);
        }
        int oneeor = 0,zeroeor=0;
        for(int elem:onelist){
        	oneeor^=elem;
        }
        for(int elem:zeroList){
        	zeroeor^=elem;
        }
        int[] ans = new int[2];
        ans[0]=oneeor;
        ans[1]=zeroeor;
        return ans;
     }
}