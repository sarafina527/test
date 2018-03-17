public class Solution {
    public double Power(double base, int exponent) {
        if(Double.valueOf(base).equals(0.0)&&exponent<0)
        	throw new RuntimeException("fenmuwei0");
        int e = exponent>=0?exponent:-exponent;
        double ans = pospow(base,e);
        if(exponent<0) ans= 1.0/ans;
        return ans;
  	}
  	public double pospow(double base,int e){
  		if(e==0) return 1;
        if(e==1) return base;
  		double half = pospow(base,e>>1);
  		double ans = half*half;
  		if((e&1)==1) ans*=base;
  		return ans;
  	}
}