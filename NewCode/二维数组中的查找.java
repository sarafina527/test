public class Solution {
    public boolean Find(int target, int [][] array) {
    	if(array==null||array.length==0||array[0].length==0)
    		return false;
    	int m=array.length,n=array[0].length;
    	int i=m-1,j=0;
    	while(i>=0&&j<n){
    		if(target==array[i][j])
    			return true;
    		else if(target<array[i][j])
    			i--;
    		else
    			j++;
    	}
    	return -1;
    }
}