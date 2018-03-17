class Solution {
    public boolean hasAlternatingBits(int n) {
        int r = n>>1;
        int bc = bitcnt(n);
        if((n&r)==0&&(n|r)==(1<<bc)-1) return true;
        else return false;
    }
    public int bitcnt(int n){
        int ans = 0;
        while(n>0){
            ans++;
            n = n>>1;
        }
        return ans;
    }
}
