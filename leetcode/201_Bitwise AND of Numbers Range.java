public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==n) return m;
        int ans = 0;
        int bm = highestbit(m),bn = highestbit(n);
        while(bm==bn){
        	ans |= (1<<bm);
        	bm = highestbit(m-ans);
        	bn = highestbit(n-ans);
        }
        return ans;
    }
    public int highestbit(int num){
        for(int i=30;i>=0;i--){
            if((num&(1<<i))!=0)
                return i;
        }
        return -1;
    }
}

//solution 2 异或 找第一个不同的，及之后的位都为0; 先与 
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==n) return m;
        int xor = m^n;
        int and = m&n;
        int bxor = highestbit(xor);
        int mask = (-1<<<(bxor+1));
        return and&mask;
    }
    public int highestbit(int num){
        for(int i=30;i>=0;i--){
            if((num&(1<<i))!=0)
                return i;
        }
        return -1;
    }
}

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
    	if(m==0) return m;
        int ans = 0;
        int bm = highestbit(m),bn = highestbit(n);
        if(bm==bn){
        	ans |= (1<<bm);
            System.out.println(ans);
        	ans |= rangeBitwiseAnd(m-ans,n-ans);
        }else{
        	int mask = (-1>>>(32-bm-1));
            System.out.println(mask);
        	int p = n&mask;
            System.out.println(p);
        	if(p<m){
        		int t = m;
        		m = p;
        		p=m;
        	}
            ans |= rangeBitwiseAnd(m,p);
        }
        return ans;
    }
    public int highestbit(int num){
        for(int i=30;i>=0;i--){
            if((num&(1<<i))!=0)
                return i;
        }
        return -1;
    }
}