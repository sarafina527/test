public class Solution {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger*(maxChoosableInteger+1)<2*desiredTotal) return false;
    	boolean[] used = new boolean[maxChoosableInteger+1];
     	return canIWin(desiredTotal,true,used);
    }
    public boolean canIWin(int left,boolean myturn,boolean[] used){
    	int i;
    	for(i=used.length-1;i>=1&&used[i];i--);//find the unused max
    	if(i>=left){//base case
    		if(myturn) return true;
    		else return false;
    	}else{
    		for(i=1;i<used.length;i++){
    			if(!used[i]){
    				used[i] = true;
    				if(canIWin(left-i,!myturn,used))
    					return true;
    				used[i] = false;
    			}
    		}
    		return false;
    	}
    }
    public static void main(String[] args){
        Solution s = new Solution();
       System.out.println(s.canIWin(20,200));
    }
}