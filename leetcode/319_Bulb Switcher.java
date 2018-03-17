public class Solution {
    public int bulbSwitch(int n) {
        if(n==0) return 0;
        int ans = 1;//1一定开着
        boolean[] isPrime = new boolean[n+1];
        int[] minfactor = new int[n+1];
        ArrayList<Set<Integer> > dec = new ArrayList<Set<Integer> >(n+1);
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
                dec.get(i).add(i);
            }else{
                int factor = minfactor[i];
                int left = i/factor;
                Set<Integer> tmp = new Set<Integer>();
                tmp.addAll(dec.get(left));
                if(tmp.contains(factor))
                    tmp.remove(factor);
                else
                    tmp.add(factor);
                dec.set(i,tmp);
                if(tmp.isEmpty()) ans++;                
            }
        }
        return ans;
    }
}


(int)(Math.sqrt(n)) //由于数i的约数是奇数的话则灯亮着，当i有平方根时才是奇数
//所以只要求1-n中平方数的个数即可
//由于1-n中平方数 是1，4，9，。。。（sqrt(n)）^2 
//个数就是sqrt(n)