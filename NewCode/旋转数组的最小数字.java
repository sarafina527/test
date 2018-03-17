import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
    	if(array==null||array.length==0) return -1;
    	int p=0,q=array.length-1;
    	while(p<q-1){
    		int mid = p+(q-p)/2;
    		if(array[mid]>=array[p])
    			p = mid;
    		else if(array[mid]<=array[q])
    			q = mid;
    	}
    	return array[q];
    }
}