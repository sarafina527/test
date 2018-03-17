public class Solution {
    public int findIntegers(int num) {        
        int n = highestbit(num);
        if(n==-1) return 1;
        System.out.println(n);
        int[] dp = new int[n+1];
        dp[0] = 1;dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        int[] max = new int[n+1];
        int[] sum = new int[n+1];

        sum[0] = 2;
        max[0] = 1;max[1] = 2;
        for(int i=2;i<=n;i+=2){
            max[i] = (max[i-2]<<2)+1;
        }
        for(int j=3;j<=n;j+=2){
            max[j] = (max[j-2]<<2)+2;
        }
        for(int i=1;i<=n;i++){
            sum[i] = sum[i-1]+dp[i];
        }
        //System.out.println(Arrays.toString(max));
        
        if(num>=max[n]) return sum[n];
        int ans = sum[n-1]+1;
        System.out.println(ans);
        int mask = (-1>>>32-n);
        int bitmask = 1<<(n-1);
        for(int i=n-1;bitmask>0;i--){
            System.out.println("num&mask="+(num&mask)+"mask="+mask);
            if((num&mask)>=max[i]){
                ans+=sum[i];
                break;
            }else if((num&bitmask)!=0){
                if(i-1>0)
                    ans+=sum[i-1];
                else
                    ans+=1;
            }
            mask=(mask>>1);
            bitmask = (bitmask>>1);
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