public class Solution {
    public int countDigitOne(int n) {
    	if(n<=0) return 0;
    	long ans = 0;
        long factor = 1;
        while(n/factor>0){
        	int curbit = (int)(n/factor)%10;
        	int highbit = (int)(n/(factor*10));
        	int lowbit = (int)(n%factor);
        	long curbitcnt = 0;
        	switch(curbit){
        		case 0: curbitcnt = highbit*factor;//当前位 是0 时，只和高位有关 12000 百位为1情况 100-199 1100-1199...11100-11199
        				break;
        		case 1: curbitcnt = highbit*factor+lowbit+1;//是1时与高位和低位都有关 12112 以上的12000种情况加上12100-12112 13种
        				break;
        		default: curbitcnt = (highbit+1)*factor;//>1 只和高位 12200因为 12000种意外，12100-12199也可，所以是13*100
        	}
        	factor*=10;
        	ans+=curbitcnt;
        }
        return (int)ans;
    }
}