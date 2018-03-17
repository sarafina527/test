class Solution {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet<Integer>();
        for(int i=2;i<=32;i++){
            if(isPrime(i))
                primes.add(i);
        }
        int ans = 0;
        for(int i=L;i<=R;i++){
            int bits = setbits(i);
            if(primes.contains(bits))
                ans++;
        }
        return ans;
    }
    public int setbits(int n){
        int ans = 0;
        while(n>0){
            ans++;
            n = n&(n-1);
        }
        return ans;
    }
    public boolean isPrime(int n){
        if(n==2) return true;
        for(int i=2;i<n;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
