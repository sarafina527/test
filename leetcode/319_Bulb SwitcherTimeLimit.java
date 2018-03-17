public class Solution {
    public int bulbSwitch(int n) {
        if(n==0) return 0;
        int ans = 1;//1一定开着
        boolean[] isPrime = new boolean[n+1];
        int[] minfactor = new int[n+1];
        ArrayList<HashMap<Integer,Boolean> > dec = new ArrayList<HashMap<Integer,Boolean> >(n+1);
        for(int i=0;i<=n;i++){
            isPrime[i] = true;
            dec.add(null);
        }
        for(int p=2;p*p<=n;p++){//筛法
            if(isPrime[p]){
                for(int k=p*p;k<=n;k+=p)//将该质数的倍数排除
                {
                    isPrime[k] = false;
                    minfactor[k] = p;
                }    
            }
        }
        for(int i=2;i<=n;i++){
            if(isPrime[i]){
                HashMap<Integer,Boolean> tmp = new HashMap<Integer,Boolean>();
                tmp.put(i,true);
                dec.set(i,tmp);
            }else{
                int factor = minfactor[i];
                int left = i/factor;
                HashMap<Integer,Boolean> tmp = new HashMap<Integer,Boolean>(dec.get(left));
                if(tmp.containsKey(factor))
                    tmp.put(factor,!tmp.get(factor));
                else
                    tmp.put(factor,true);
                dec.set(i,tmp);
                if(!tmp.containsValue(true)) ans++;                
            }
        }
        return ans;
    }
}