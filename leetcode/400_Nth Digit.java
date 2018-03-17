class Solution {
    public int findNthDigit(int n) {
    	long sum = 0;
    	long nth = n;
    	long tenp = 1;
    	int c = 1;
        for(int i=1;i<=9;i++){
        	sum+=9*tenp*i;
        	if(nth<=sum){
                c = i;
        		break;        		
        	}
        	tenp*=10;
        }
        long pren = sum-9*tenp*c;
        long curi = (nth-pren)/c;
        int interi = (int)(nth-pren)%c;
        long num = tenp+curi-1;
        if(interi==0){
        	return (int)(num%10);
        }else{
        	return (int)((num+1)/(tenp/Math.pow(10,interi-1)))%10;
        }
    }
}