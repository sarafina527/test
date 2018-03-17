public class Solution {
    public int findComplement(int num) {
        if(num==0) return 1;
        if(num>0){
        	int n = num;
	        int mask = 0;
	        while(n>0){
	        	n = n>>1;
	        	mask = (mask<<1)+1;
	        }
	        return ~num&mask;
        }else{
        	return num-1;
        }
    }
}